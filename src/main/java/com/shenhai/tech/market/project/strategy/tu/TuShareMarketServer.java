package com.shenhai.tech.market.project.strategy.tu;

import com.google.gson.JsonObject;
import com.shenhai.tech.market.common.exception.BusinessException;
import com.shenhai.tech.market.common.exception.BusinessExceptionEnums;
import com.shenhai.tech.market.common.redis.RedisService;
import com.shenhai.tech.market.common.response.ResponseCode;
import com.shenhai.tech.market.common.utils.JSONUtils;
import com.shenhai.tech.market.common.utils.LocalDateUtils;
import com.shenhai.tech.market.common.utils.StockUtils;
import com.shenhai.tech.market.project.config.MarketConfig;
import com.shenhai.tech.market.project.strategy.entity.Dividend;
import com.shenhai.tech.market.project.strategy.entity.Stock;
import com.shenhai.tech.market.project.strategy.entity.Suspension;
import com.shenhai.tech.market.project.strategy.entity.DelistStock;
import com.shenhai.tech.market.project.strategy.tu.entity.TuFields;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class TuShareMarketServer {
    @Autowired
    private TuShareMarketParser tuShareMarketParser;
    @Autowired
    protected RestTemplate restTemplate;
    @Autowired
    protected RedisService redisService;
    @Autowired
    protected MarketConfig marketConfig;

    /**
     * 停盘股票-按日期查询
     * @param suspensionDate
     * @return
     */
    public List<Suspension> getSuspensionStocks(LocalDate suspensionDate) {
        Map<String, Object> params = new HashMap<>();
        params.put("suspend_date", LocalDateUtils.format(suspensionDate, LocalDateUtils.formatterDD3));

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("api_name", "suspend");
        requestMap.put("token", marketConfig.tushareToken);
        requestMap.put("params", params);
        requestMap.put("fields", TuFields.suspendFields);
        JsonObject response = postRequest(marketConfig.tushareUrl, JSONUtils.toExcJson(requestMap));
        return tuShareMarketParser.parseSuspensions(response, TuFields.suspendFields);
    }

    /**
     * 获取退市股票
     * @return
     */
    public List<DelistStock> getDelistStocks() {
        Map<String, Object> params = new HashMap<>();
        params.put("list_status", "D");

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("api_name", "stock_basic");
        requestMap.put("token", marketConfig.tushareToken);
        requestMap.put("params", params);
        requestMap.put("fields", TuFields.stopStockFields);
        JsonObject response = postRequest(marketConfig.tushareUrl, JSONUtils.toExcJson(requestMap));
        return tuShareMarketParser.parseStopStocks(response, TuFields.stopStockFields);
    }

    public List<Dividend> getDividendsByCode(String code) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("ts_code", StockUtils.codeToSymbol(code));
            Map<String, Object> requestMap = new HashMap<>();
            requestMap.put("api_name", "dividend");
            requestMap.put("token", marketConfig.tushareToken);
            requestMap.put("params", params);
            requestMap.put("fields", TuFields.dividenFields);
            JsonObject response = postRequest(marketConfig.tushareUrl, JSONUtils.toExcJson(requestMap));
            return tuShareMarketParser.parseDividends(response, TuFields.dividenFields);
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
            log.info("postRequest success cost{}ms, reqUrl:{}, reqParam:{},response:{}", System.currentTimeMillis() - startTime, url, bodyParam, response);
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
