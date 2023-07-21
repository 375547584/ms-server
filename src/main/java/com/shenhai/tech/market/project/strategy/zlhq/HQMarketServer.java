package com.shenhai.tech.market.project.strategy.zlhq;

import com.google.gson.JsonObject;
import com.shenhai.tech.market.common.exception.BusinessException;
import com.shenhai.tech.market.common.exception.BusinessExceptionEnums;
import com.shenhai.tech.market.common.response.ResponseCode;
import com.shenhai.tech.market.common.utils.*;
import com.shenhai.tech.market.project.config.MarketConfig;
import com.shenhai.tech.market.project.strategy.constant.Fields;
import com.shenhai.tech.market.project.strategy.constant.Symbols;
import com.shenhai.tech.market.project.strategy.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.*;

@Slf4j
@Service
public class HQMarketServer {
    @Autowired
    private HQMarketParser hqMarketParser;
    @Autowired
    protected RestTemplate restTemplate;
    @Autowired
    protected MarketConfig marketConfig;

    public List<StockCode> getAllStockCodes() {
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("bkcode", Symbols.CNACode);
        JsonObject jsonObject = postRequest(marketConfig.qhDomain + marketConfig.qhBlockStockList, JSONUtils.toExcJson(requestMap));
        return hqMarketParser.parseAllStockCodes(jsonObject);
    }

    public List<StockQuota> getAllStockQuotas() {
        long mils = System.currentTimeMillis();
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("industry", StockUtils.getBlockCode(Symbols.CNASymbol));
        requestMap.put("field", Fields.zlqhStockQuotaFields);
        JsonObject response = postRequest(marketConfig.qhDomain + marketConfig.qhStock, JSONUtils.toExcJson(requestMap));
        log.info("getAllNotRealTimeStocks 请求耗时:{}", TimeUtils.getHMSTime(System.currentTimeMillis() - mils));
        List<StockQuota> stockQuotas = hqMarketParser.parseStockQuotas(response, Fields.zlqhStockQuotaFields);
        log.info("getAllNotRealTimeStocks 总耗时:{}", TimeUtils.getHMSTime(System.currentTimeMillis() - mils));
        return stockQuotas;
    }

    /**
     * 查询所有股票
     * @return
     */
    public List<Stock> getAllStock() {
        long mils = System.currentTimeMillis();
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("industry", StockUtils.getBlockCode(Symbols.CNASymbol));
        requestMap.put("field", Fields.zlqhStockFields);
        JsonObject response = postRequest(marketConfig.qhDomain + marketConfig.qhStock, JSONUtils.toExcJson(requestMap));
        log.info("getAllStocks 请求耗时:{}", TimeUtils.getHMSTime(System.currentTimeMillis() - mils));
        List<Stock> qhStocks = hqMarketParser.parseStocks(response, Fields.zlqhStockFields);
        log.info("getAllStocks 总耗时:{}", TimeUtils.getHMSTime(System.currentTimeMillis() - mils));
        return qhStocks;
    }

    public List<Stock> getAllIndexs() {
        long mils = System.currentTimeMillis();
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("symbol", Symbols.indexSymbols);
        requestMap.put("field", Fields.zlqhIndexStockFields);
        JsonObject response = postRequest(marketConfig.qhDomain + marketConfig.qhStock, JSONUtils.toExcJson(requestMap));
        //log.info("getAllInexs 请求耗时:{}", TimeUtils.getHMSTime(System.currentTimeMillis() - mils));
        List<Stock> stocks = hqMarketParser.parseStocks(response, Fields.zlqhIndexStockFields);
        log.info("getAllInexs 总耗时:{}", TimeUtils.getHMSTime(System.currentTimeMillis() - mils));
        return stocks;
    }

    public Map<String, List<RTKLine>> getMinuteRealTimeKLines(List<String> codes) {
        long mils = System.currentTimeMillis();
        List<String> symbols = StockUtils.codeToSymbols(codes);
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("symbol", symbols);
        requestMap.put("field", Fields.zlqhMinuteRealTimeKLineFields);
        JsonObject response = postRequest(marketConfig.qhDomain + marketConfig.qhStock, JSONUtils.toExcJson(requestMap));
        Map<String, List<RTKLine>> realTimeKLineMap = hqMarketParser.parseMinuteRealTimeKLines(response, Fields.zlqhMinuteRealTimeKLineFields);
        log.info("getMinuteRealTimeKLines 耗时:{}", TimeUtils.getHMSTime(System.currentTimeMillis() - mils));
        return realTimeKLineMap;
    }


    public List<Dividend> getDividendsByCode(String code) {
        try {
            Map<String, Object> requestMap = new HashMap<>();
            requestMap.put("seccode", StockUtils.codeToSymbol(code));
            JsonObject response = postRequest(marketConfig.qhDomain + marketConfig.qhStockDividendList, JSONUtils.toExcJson(requestMap));
            List<Dividend> dividends = hqMarketParser.parseDividends(response, false);
            dividends.forEach(i -> i.setCode(code));
            return dividends;
        }
        catch (Exception e) {
            log.error("getDividendsByCode Exception code:{}  e:{}", code, e);
        }
        return Collections.emptyList();
    }


    /**
     * restTemplate post
     *
     * @param url  地址
     * @param bodyParam 参数
     * @return
     */
    protected JsonObject postRequest(String url, String bodyParam) {
        long startTime = System.currentTimeMillis();
        try {
            HttpEntity httpEntity = buildHttpEntity(bodyParam);
            String response = restTemplate.postForObject(url, httpEntity, String.class);
            JsonObject result = JSONUtils.fromJson(response, JsonObject.class);
            if(!isSuccess(result)){
                throw new BusinessException(BusinessExceptionEnums.RESPONSE_DATA_WRONG);
            }
            log.info("postRequest success cost{}ms, reqUrl:{}, reqParams:{}, response:{}", System.currentTimeMillis() - startTime, url, bodyParam, response);
            return result;
        } catch (BusinessException e) {
            log.info("postRequest 接口失败 时间{}ms 请求地址:{} 请求参数:{} 返回数据处理失败:{}",
                    System.currentTimeMillis() - startTime,
                    url,
                    bodyParam,
                    e.getMessage());
            throw e;
        } catch (Exception e) {
            log.info("postRequest 接口失败 时间{}ms 请求地址:{} 请求参数:{}  异常:{}",
                    System.currentTimeMillis() - startTime,
                    url,
                    bodyParam,
                    e.getMessage());
            throw new BusinessException(ResponseCode.INTERFACE_TIME_OUT.getCode(), ResponseCode.INTERFACE_TIME_OUT.getMessage());
        }
    }

    private HttpEntity buildHttpEntity(String json) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity httpEntity = new HttpEntity(json, httpHeaders);
        return httpEntity;
    }

    private boolean isSuccess(JsonObject result) {
        if (result.isJsonNull()) {
            return false;
        }
        boolean hasCode = result.has("code");
        if (hasCode) {
            Integer resCode = result.get("code").getAsInt();
            if (0 == resCode) {
                return true;
            }
            else {
                String resMsg = result.get("message").getAsString();
                log.info("isSuccess resCode:{} resMsg:{}", resCode, resMsg);
            }
        }
        else {
            boolean hasReturn = result.has("return");
            if (hasReturn) {
                Integer resCode = result.get("return").getAsInt();
                if (0 == resCode) {
                    return true;
                }
                else {
                    log.info("isSuccess resCode:{}", resCode);
                }
            }
        }
        return false;
    }

}
