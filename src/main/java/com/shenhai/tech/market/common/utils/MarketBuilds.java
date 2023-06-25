package com.shenhai.tech.market.common.utils;

import com.shenhai.tech.market.project.service.entity.StockDay;
import com.shenhai.tech.market.project.strategy.cache.StockCache;
import com.shenhai.tech.market.project.strategy.cache.SuspensionCache;
import com.shenhai.tech.market.project.strategy.entity.*;
import com.shenhai.tech.market.project.strategy.zlhq.entity.QHStock;
import com.shenhai.tech.market.project.strategy.zlhq.entity.ZLRTKLine;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MarketBuilds {

    public static StockQuota castStockQuota(QHStock qhStock) {
        StockQuota stockQuota = new StockQuota();
        stockQuota.setCode(StockUtils.symbolToCode(qhStock.getSymbol()));

        stockQuota.setAvprice(qhStock.getAvprice());

        stockQuota.setVolin(qhStock.getVolin());
        stockQuota.setVolout(qhStock.getVolout());
        stockQuota.setFlowin(qhStock.getFlowin());
        stockQuota.setFlowout(qhStock.getFlowout());

        stockQuota.setSuperin(qhStock.getSuperin());
        stockQuota.setSuperout(qhStock.getSuperout());
        stockQuota.setBigin(qhStock.getBigin());
        stockQuota.setBigout(qhStock.getBigout());
        stockQuota.setMidin(qhStock.getMidin());
        stockQuota.setMidout(qhStock.getMidout());
        stockQuota.setSmallin(qhStock.getSmallin());
        stockQuota.setSmallout(qhStock.getSmallout());

        stockQuota.setAmplitude(qhStock.getAmplitude());
        stockQuota.setBookrate(qhStock.getBookrate());
        stockQuota.setVolratio(qhStock.getVolratio());
        stockQuota.setBookdiffer(qhStock.getBookdiffer());

        stockQuota.setIncreaseweek1(qhStock.getIncreaseweek1());
        stockQuota.setIncreaseweek4(qhStock.getIncreaseweek4());
        stockQuota.setIncreaseweek13(qhStock.getIncreaseweek13());
        stockQuota.setIncreaseweek26(qhStock.getIncreaseweek26());
        stockQuota.setIncreaseweek52(qhStock.getIncreaseweek52());
        stockQuota.setIncreasethisyear(qhStock.getIncreasethisyear());


        stockQuota.setExchangeRate(qhStock.getExchangerate());
        stockQuota.setPe(qhStock.getPe());
        stockQuota.setPe2(qhStock.getPe2());
        stockQuota.setPe3(qhStock.getPe3());
        stockQuota.setEps(qhStock.getEps());
        stockQuota.setEps2(qhStock.getEps2());
        stockQuota.setEps3(qhStock.getEps3());
        stockQuota.setBv(qhStock.getBv());
        stockQuota.setPb(qhStock.getPb());
        stockQuota.setRoe(qhStock.getRoe());
        stockQuota.setNetprofit(qhStock.getNetprofit());
        stockQuota.setSalesrevenue(qhStock.getSalesrevenue());

        stockQuota.setTotaleQuity(qhStock.getTotalequity());
        stockQuota.setFolweQuity(qhStock.getFolwequity());
        stockQuota.setTotaleValue(qhStock.getMarketvalue());
        stockQuota.setFolweValue(qhStock.getFlowmarketvalue());

        return stockQuota;
    }

    public static Stock castStock(QHStock qhStock, String holidays) {
        Stock stock = new Stock();
        stock.setSymbol(qhStock.getSymbol());
        stock.setCode(StockUtils.symbolToCode(qhStock.getSymbol()));
        stock.setBlock(StockUtils.symbolToBlock(qhStock.getSymbol()));
        stock.setName(qhStock.getName());

        stock.setDate(qhStock.getDate());
        stock.setTime(qhStock.getTime());
        stock.setDecimal(qhStock.getDecimal());

        stock.setOpenPrice(qhStock.getOpen());
        stock.setyClose(qhStock.getYclose());
        stock.setPrice(qhStock.getPrice());
        stock.setHighPrice(qhStock.getHigh());
        stock.setLowPrice(qhStock.getLow());
        stock.setAvprice(qhStock.getAvprice());

        stock.setFallStopPrice(qhStock.getDnlimit());
        stock.setRiseStopPrice(qhStock.getUplimit());

        stock.setVol(qhStock.getVol());
        stock.setAmount(qhStock.getAmount());
        stock.setVolin(qhStock.getVolin());
        stock.setVolout(qhStock.getVolout());
        stock.setFlowin(qhStock.getFlowin());
        stock.setFlowout(qhStock.getFlowout());

        stock.setSuperin(qhStock.getSuperin());
        stock.setSuperout(qhStock.getSuperout());
        stock.setBigin(qhStock.getBigin());
        stock.setBigout(qhStock.getBigout());
        stock.setMidin(qhStock.getMidin());
        stock.setMidout(qhStock.getMidout());
        stock.setSmallin(qhStock.getSmallin());
        stock.setSmallout(qhStock.getSmallout());

        stock.setRisefall(qhStock.getRisefall());
        stock.setIncrease(qhStock.getIncrease());
        stock.setAmplitude(qhStock.getAmplitude());
        stock.setBookrate(qhStock.getBookrate());
        stock.setVolratio(qhStock.getVolratio());
        stock.setBookdiffer(qhStock.getBookdiffer());

        stock.setIncreaseweek1(qhStock.getIncreaseweek1());
        stock.setIncreaseweek4(qhStock.getIncreaseweek4());
        stock.setIncreaseweek13(qhStock.getIncreaseweek13());
        stock.setIncreaseweek26(qhStock.getIncreaseweek26());
        stock.setIncreaseweek52(qhStock.getIncreaseweek52());
        stock.setIncreasethisyear(qhStock.getIncreasethisyear());

        stock.setFirstday(qhStock.getFirstday());

        stock.setExchangeRate(qhStock.getExchangerate());
        stock.setPe(qhStock.getPe());
        stock.setPe2(qhStock.getPe2());
        stock.setPe3(qhStock.getPe3());
        stock.setEps(qhStock.getEps());
        stock.setEps2(qhStock.getEps2());
        stock.setEps3(qhStock.getEps3());
        stock.setBv(qhStock.getBv());
        stock.setPb(qhStock.getPb());
        stock.setRoe(qhStock.getRoe());
        stock.setNetprofit(qhStock.getNetprofit());
        stock.setSalesrevenue(qhStock.getSalesrevenue());


        stock.setTotaleQuity(qhStock.getTotalequity());
        stock.setFolweQuity(qhStock.getFolwequity());
        stock.setTotaleValue(qhStock.getMarketvalue());
        stock.setFolweValue(qhStock.getFlowmarketvalue());

        stock.setBuypx1(qhStock.getBuypx1());
        stock.setBuypx2(qhStock.getBuypx2());
        stock.setBuypx3(qhStock.getBuypx3());
        stock.setBuypx4(qhStock.getBuypx4());
        stock.setBuypx5(qhStock.getBuypx5());

        stock.setBuyvol1(qhStock.getBuyvol1());
        stock.setBuyvol2(qhStock.getBuyvol2());
        stock.setBuyvol3(qhStock.getBuyvol3());
        stock.setBuyvol4(qhStock.getBuyvol4());
        stock.setBuyvol5(qhStock.getBuyvol5());

        stock.setSellpx1(qhStock.getSellpx1());
        stock.setSellpx2(qhStock.getSellpx2());
        stock.setSellpx3(qhStock.getSellpx3());
        stock.setSellpx4(qhStock.getSellpx4());
        stock.setSellpx5(qhStock.getSellpx5());

        stock.setSellvol1(qhStock.getSellvol1());
        stock.setSellvol2(qhStock.getSellvol2());
        stock.setSellvol3(qhStock.getSellvol3());
        stock.setSellvol4(qhStock.getSellvol4());
        stock.setSellvol5(qhStock.getSellvol5());

        stock.setIsSH(StockUtils.isSHFromBlock(stock.getBlock()));
        stock.setIsSZ(StockUtils.isSZFromBlock(stock.getBlock()));
        stock.setIsCY(StockUtils.isCYB(stock.getCode()));
        stock.setIsKC(StockUtils.isKCB(stock.getCode()));
        stock.setIsZX(StockUtils.isZXB(stock.getCode()));
        // 一月以内次新股
        stock.setIsNew(StockUtils.isNew(stock.getFirstday()));
        // 一年以内次新股
        stock.setIsSubNew(StockUtils.isSubNew(stock.getFirstday()));



        String state = StockStateUtils.genereateState(holidays, SuspensionCache.isSuspension(stock.getCode()));
        stock.setState(state);
        stock.setIsindex(0);

        return stock;
    }

    public static List<StockDay> castStockDays(Map<String, Stock> allMap) {
        if(StringUtils.isEmpty(allMap)) {
            return null;
        }
        List<StockDay> stockDays = new ArrayList<>();
        for (Stock stock : allMap.values()) {
            StockDay stockDay = new StockDay();
            BeanUtil.copyProperties(stock, stockDay);
            stockDay.setId(String.format("%s%s", stock.getCode(),stock.getDate()));
            stockDay.setDayDate(LocalDateUtils.string2LocalDate(stock.getDate(), LocalDateUtils.formatterDD3));
            stockDay.setUpdateDate(LocalDateTime.now());
            stockDays.add(stockDay);
        }
        return stockDays;
    }


    public static void updateCount(Stock index) {
        if(index == null) {
            return;
        }

        if(!StockCache.isEmpty()) {
            long unchanged = 0;
            long down = 0;
            long up = 0;
            long stop = 0;
            if(index.getIsSH()) {
                unchanged = StockCache.getAllMap().values().stream().filter(o -> BigDecimalUtil.eqZero(o.getIncrease()) && o.getIsSH() && o.getIsindex() == 0).count();
                down = StockCache.getAllMap().values().stream().filter(o -> BigDecimalUtil.ltZero(o.getIncrease()) && o.getIsSH() && o.getIsindex() == 0).count();
                up = StockCache.getAllMap().values().stream().filter(o -> BigDecimalUtil.gtZero(o.getIncrease()) && o.getIsSH() && o.getIsindex() == 0).count();
                stop = StockCache.getAllMap().values().stream().filter(o -> o.getIsSuspension() && o.getIsCY() && o.getIsindex() == 0).count();
            }

            if(index.getIsSZ()) {
                unchanged = StockCache.getAllMap().values().stream().filter(o -> BigDecimalUtil.eqZero(o.getIncrease()) && o.getIsSZ() && o.getIsindex() == 0).count();
                down = StockCache.getAllMap().values().stream().filter(o -> BigDecimalUtil.ltZero(o.getIncrease()) && o.getIsSZ() && o.getIsindex() == 0).count();
                up = StockCache.getAllMap().values().stream().filter(o -> BigDecimalUtil.gtZero(o.getIncrease()) && o.getIsSZ() && o.getIsindex() == 0).count();
                stop = StockCache.getAllMap().values().stream().filter(o -> o.getIsSuspension() && o.getIsCY() && o.getIsindex() == 0).count();
            }

            if(index.getIsCY()) {
                unchanged = StockCache.getAllMap().values().stream().filter(o -> BigDecimalUtil.eqZero(o.getIncrease()) && o.getIsCY() && o.getIsindex() == 0).count();
                down = StockCache.getAllMap().values().stream().filter(o -> BigDecimalUtil.ltZero(o.getIncrease()) && o.getIsCY() && o.getIsindex() == 0).count();
                up = StockCache.getAllMap().values().stream().filter(o -> BigDecimalUtil.gtZero(o.getIncrease()) && o.getIsCY() && o.getIsindex() == 0).count();
                stop = StockCache.getAllMap().values().stream().filter(o -> o.getIsSuspension() && o.getIsCY() && o.getIsindex() == 0).count();
            }
            index.setUp((int) up);
            index.setDown((int) down);
            index.setUnchanged((int) unchanged);
            index.setStop((int) stop);
        }
    }

    public static List<RTKLine> castRTKLineVOS(QHStock qhStock) {
        if (qhStock == null) {
            return null;
        }

        List<ZLRTKLine> zlrtkLines = qhStock.getMinute();
        if (zlrtkLines == null) {
            return null;
        }
        List<RTKLine> rtkLineVOS = new ArrayList<>();
        for (ZLRTKLine zlrtkLine : zlrtkLines) {
            RTKLine rtkLine = new RTKLine();
            rtkLine.setDate(qhStock.getDate());
            rtkLine.setOpen(qhStock.getOpen());
            rtkLine.setHigh(qhStock.getHigh());
            rtkLine.setLow(qhStock.getLow());
            rtkLine.setTime(zlrtkLine.getTime());
            rtkLine.setPrice(zlrtkLine.getPrice());
            rtkLine.setAvPrice(zlrtkLine.getAvPrice());
            rtkLine.setVol(zlrtkLine.getVol());
            rtkLine.setAmount(zlrtkLine.getAmount());
            rtkLine.setIncrease(zlrtkLine.getIncrease());
            rtkLine.setRiseFall(zlrtkLine.getRiseFall());
            rtkLineVOS.add(rtkLine);
        }

        return rtkLineVOS;
    }
}
