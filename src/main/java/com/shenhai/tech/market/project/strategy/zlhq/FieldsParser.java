package com.shenhai.tech.market.project.strategy.zlhq;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.shenhai.tech.market.project.strategy.constant.Fields;
import com.shenhai.tech.market.project.strategy.zlhq.entity.BlockItem;
import com.shenhai.tech.market.project.strategy.zlhq.entity.FolwStockHolderItem;
import com.shenhai.tech.market.project.strategy.zlhq.entity.StockHolderItem;
import com.shenhai.tech.market.project.strategy.zlhq.entity.ZLRTKLine;
import com.shenhai.tech.market.project.strategy.tu.entity.TuFields;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 股票常量信息
 *
 * @author capital
 */
public class FieldsParser {

    public static Object getValue(JsonElement jsonElement, String feild) {
        if (Fields.symbol.equalsIgnoreCase(feild)
                || Fields.name.equalsIgnoreCase(feild)
                || Fields.date.equalsIgnoreCase(feild)
                || Fields.time.equalsIgnoreCase(feild)
                || Fields.firstday.equalsIgnoreCase(feild)
                || Fields.companyname.equalsIgnoreCase(feild)
                || Fields.companynameen.equalsIgnoreCase(feild)
                || Fields.ename.equalsIgnoreCase(feild)
                || Fields.registeredaddress.equalsIgnoreCase(feild)
                || Fields.businessaddress.equalsIgnoreCase(feild)
                || Fields.zipcode.equalsIgnoreCase(feild)
                || Fields.homepage.equalsIgnoreCase(feild)
                || Fields.email.equalsIgnoreCase(feild)
                || Fields.companyphone.equalsIgnoreCase(feild)
                || Fields.companyfax.equalsIgnoreCase(feild)
                || Fields.chairman.equalsIgnoreCase(feild)
                || Fields.legalrepresentative.equalsIgnoreCase(feild)
                || Fields.ceo.equalsIgnoreCase(feild)
                || Fields.boardsecretary.equalsIgnoreCase(feild)
                || Fields.boardsecretaryphone.equalsIgnoreCase(feild)
                || Fields.boardsecretaryfax.equalsIgnoreCase(feild)
                || Fields.boardsecretaryemail.equalsIgnoreCase(feild)
                || Fields.sar.equalsIgnoreCase(feild)
                || Fields.sarphone.equalsIgnoreCase(feild)
                || Fields.sarfax.equalsIgnoreCase(feild)
                || Fields.saremail.equalsIgnoreCase(feild)
                || Fields.businesslicense.equalsIgnoreCase(feild)
                || Fields.ntrn.equalsIgnoreCase(feild)
                || Fields.ltrn.equalsIgnoreCase(feild)
                || Fields.idwebsite.equalsIgnoreCase(feild)
                || Fields.idmedia.equalsIgnoreCase(feild)
                || Fields.companyhistory.equalsIgnoreCase(feild)
                || Fields.mainbusiness.equalsIgnoreCase(feild)
                || Fields.businessscope.equalsIgnoreCase(feild)
                || Fields.rptdate.equalsIgnoreCase(feild)
                || Fields.upstock.equalsIgnoreCase(feild)
                || Fields.dnstock.equalsIgnoreCase(feild)
        ) {
            if (jsonElement.isJsonNull()) {
                return null;
            } else {
                return jsonElement.getAsString();
            }
        } else if (Fields.isindex.equalsIgnoreCase(feild)
                || Fields.advance.equalsIgnoreCase(feild)
                || Fields.decline.equalsIgnoreCase(feild)
                || Fields.unchanged.equalsIgnoreCase(feild)
                || Fields.stop.equalsIgnoreCase(feild)
                || Fields.cwip.equalsIgnoreCase(feild)
                || Fields.decimal.equalsIgnoreCase(feild)
        ) {
            if (jsonElement.isJsonNull()) {
                return 0;
            } else {
                return jsonElement.getAsInt();
            }
        } else if (Fields.volin.equalsIgnoreCase(feild)
                || Fields.volout.equalsIgnoreCase(feild)
                || Fields.totalequity.equalsIgnoreCase(feild)
                || Fields.folwequity.equalsIgnoreCase(feild)
                || Fields.vol.equalsIgnoreCase(feild)
                || Fields.buyvol1.equalsIgnoreCase(feild)
                || Fields.buyvol2.equalsIgnoreCase(feild)
                || Fields.buyvol3.equalsIgnoreCase(feild)
                || Fields.buyvol4.equalsIgnoreCase(feild)
                || Fields.buyvol5.equalsIgnoreCase(feild)
                || Fields.sellvol1.equalsIgnoreCase(feild)
                || Fields.sellvol2.equalsIgnoreCase(feild)
                || Fields.sellvol3.equalsIgnoreCase(feild)
                || Fields.sellvol4.equalsIgnoreCase(feild)
                || Fields.sellvol5.equalsIgnoreCase(feild)
                || Fields.capital.equalsIgnoreCase(feild)
                || Fields.folwequitya.equalsIgnoreCase(feild)
                || Fields.folwequityb.equalsIgnoreCase(feild)
                || Fields.folwequityh.equalsIgnoreCase(feild)
                || Fields.folwequityo.equalsIgnoreCase(feild)
                || Fields.uncirculatedquity.equalsIgnoreCase(feild)
                || Fields.restrictedquity.equalsIgnoreCase(feild)
                || Fields.managerialownership.equalsIgnoreCase(feild)
                || Fields.stateholding.equalsIgnoreCase(feild)
                || Fields.stateownedlegalholding.equalsIgnoreCase(feild)
                || Fields.domesticlegalholding.equalsIgnoreCase(feild)
                || Fields.overseaslegalholding.equalsIgnoreCase(feild)
                || Fields.preferredstock.equalsIgnoreCase(feild)
        ) {
            if (jsonElement.isJsonNull()) {
                return 0L;
            } else {
                return jsonElement.getAsLong();
            }
        } else if (Fields.stockholder1.equalsIgnoreCase(feild)
                || Fields.stockholder2.equalsIgnoreCase(feild)
                || Fields.stockholder3.equalsIgnoreCase(feild)
                || Fields.stockholder4.equalsIgnoreCase(feild)
                || Fields.stockholder5.equalsIgnoreCase(feild)
                || Fields.stockholder6.equalsIgnoreCase(feild)
                || Fields.stockholder7.equalsIgnoreCase(feild)
                || Fields.stockholder8.equalsIgnoreCase(feild)
                || Fields.stockholder9.equalsIgnoreCase(feild)
                || Fields.stockholder10.equalsIgnoreCase(feild)
        ) {
            List<StockHolderItem> stockHolderItems = new ArrayList<>();
            if (jsonElement.isJsonNull() || jsonElement.getAsJsonArray().isJsonNull()) {
                return stockHolderItems;
            } else {
                JsonArray arrays = jsonElement.getAsJsonArray();
                for (JsonElement element : arrays) {
                    JsonArray itemArrays = element.getAsJsonArray();
                    StockHolderItem stockHolderItem = new StockHolderItem();
                    stockHolderItem.setAnnDate(itemArrays.get(0).getAsString());
                    stockHolderItem.setHoldName(itemArrays.get(1).getAsString());
                    stockHolderItem.setHoldQuantity(itemArrays.get(2).getAsLong());
                    stockHolderItem.setHoldRatio(itemArrays.get(3).getAsBigDecimal());
                    stockHolderItem.setReduceHoldQuantity(itemArrays.get(4).getAsLong());
                    stockHolderItem.setReduceHoldRatio(itemArrays.get(5).getAsBigDecimal());
                    stockHolderItem.setHoldProperty(itemArrays.get(6).getAsString());
                    stockHolderItem.setStockProperty(itemArrays.get(7).getAsString());
                    stockHolderItems.add(stockHolderItem);
                }
                return stockHolderItems;
            }
        } else if (Fields.folwstockholder1.equalsIgnoreCase(feild)
                || Fields.folwstockholder2.equalsIgnoreCase(feild)
                || Fields.folwstockholder3.equalsIgnoreCase(feild)
                || Fields.folwstockholder4.equalsIgnoreCase(feild)
                || Fields.folwstockholder5.equalsIgnoreCase(feild)
                || Fields.folwstockholder6.equalsIgnoreCase(feild)
                || Fields.folwstockholder7.equalsIgnoreCase(feild)
                || Fields.folwstockholder8.equalsIgnoreCase(feild)
                || Fields.folwstockholder9.equalsIgnoreCase(feild)
                || Fields.folwstockholder10.equalsIgnoreCase(feild)
        ) {
            List<FolwStockHolderItem> folwStockHolderItems = new ArrayList<>();
            if (jsonElement.isJsonNull() || jsonElement.getAsJsonArray().isJsonNull()) {
                return folwStockHolderItems;
            } else {
                JsonArray arrays = jsonElement.getAsJsonArray();
                for (JsonElement element : arrays) {
                    JsonArray itemArrays = element.getAsJsonArray();
                    FolwStockHolderItem folwStockHolderItem = new FolwStockHolderItem();
                    folwStockHolderItem.setAnnDate(itemArrays.get(0).getAsString());
                    folwStockHolderItem.setHoldName(itemArrays.get(1).getAsString());
                    folwStockHolderItem.setHoldQuantity(itemArrays.get(2).getAsLong());
                    folwStockHolderItem.setHoldRatio(itemArrays.get(3).getAsBigDecimal());
                    folwStockHolderItem.setHoldFolwRatio(itemArrays.get(4).getAsBigDecimal());
                    folwStockHolderItem.setReduceHoldQuantity(itemArrays.get(5).getAsLong());
                    folwStockHolderItem.setHoldProperty(itemArrays.get(6).getAsString());
                    folwStockHolderItem.setStockProperty(itemArrays.get(7).getAsString());
                    folwStockHolderItems.add(folwStockHolderItem);
                }
                return folwStockHolderItems;
            }
        } else if (Fields.region.equalsIgnoreCase(feild)
                || Fields.industry.equalsIgnoreCase(feild)
                || Fields.concept.equalsIgnoreCase(feild)
        ) {
            List<BlockItem> blockItems = new ArrayList<>();
            if (jsonElement.isJsonNull() || jsonElement.getAsJsonArray().isJsonNull()) {
                return blockItems;
            } else {
                JsonArray arrays = jsonElement.getAsJsonArray();
                for (JsonElement element : arrays) {
                    JsonArray itemArrays = element.getAsJsonArray();
                    BlockItem blockItem = new BlockItem();
                    blockItem.setBlockCode(itemArrays.get(0).getAsString());
                    blockItem.setBlockName(itemArrays.get(1).getAsString());
                    blockItem.setBlockValue(itemArrays.get(2).getAsInt());
                    blockItems.add(blockItem);
                }
                return blockItems;
            }
        } else if (Fields.minute.equalsIgnoreCase(feild)) {
            List<ZLRTKLine> zlrtkLines = new ArrayList<>();
            if (jsonElement.isJsonNull() || jsonElement.getAsJsonArray().isJsonNull()) {
                return zlrtkLines;
            } else {
                JsonArray arrays = jsonElement.getAsJsonArray();
                for (JsonElement element : arrays) {
                    JsonArray itemArrays = element.getAsJsonArray();
                    String time = itemArrays.get(0).getAsString();
                    BigDecimal price = itemArrays.get(1).getAsBigDecimal();
                    BigDecimal avprice = itemArrays.get(2).getAsBigDecimal();
                    Long vol = itemArrays.get(3).getAsLong();
                    BigDecimal amount = itemArrays.get(4).getAsBigDecimal();
                    BigDecimal increase = itemArrays.get(5).getAsBigDecimal();
                    BigDecimal risefall = itemArrays.get(6).getAsBigDecimal();
                    ZLRTKLine zlrtkLine = new ZLRTKLine();
                    zlrtkLine.setTime(time);
                    zlrtkLine.setPrice(price);
                    zlrtkLine.setAvPrice(avprice);
                    zlrtkLine.setVol(vol);
                    zlrtkLine.setAmount(amount);
                    zlrtkLine.setIncrease(increase);
                    zlrtkLine.setRiseFall(risefall);
                    zlrtkLines.add(zlrtkLine);
                }
                return zlrtkLines;
            }
        } else {
            if (jsonElement.isJsonNull() || jsonElement.getAsBigDecimal() == null) {
                return BigDecimal.ZERO;
            } else {
                return jsonElement.getAsBigDecimal();
            }
        }
    }

    public static Object getTuValue(JsonElement jsonElement, String feild) {
        if (TuFields.ts_code.equalsIgnoreCase(feild)
                || TuFields.suspend_date.equalsIgnoreCase(feild)
                || TuFields.resume_date.equalsIgnoreCase(feild)
                || TuFields.suspend_reason.equalsIgnoreCase(feild)
                || TuFields.record_date.equalsIgnoreCase(feild)
                || TuFields.ex_date.equalsIgnoreCase(feild)
                || TuFields.pay_date.equalsIgnoreCase(feild)
                || TuFields.ann_date.equalsIgnoreCase(feild)
                || TuFields.holder_name.equalsIgnoreCase(feild)
                || TuFields.holder_type.equalsIgnoreCase(feild)
                || TuFields.in_de.equalsIgnoreCase(feild)
                || TuFields.begin_date.equalsIgnoreCase(feild)
                || TuFields.end_date.equalsIgnoreCase(feild)
                || TuFields.ipo_date.equalsIgnoreCase(feild)
                || TuFields.national.equalsIgnoreCase(feild)
                || TuFields.birthday.equalsIgnoreCase(feild)
                || TuFields.edu.equalsIgnoreCase(feild)
                || TuFields.title.equalsIgnoreCase(feild)
                || TuFields.lev.equalsIgnoreCase(feild)
                || TuFields.name.equalsIgnoreCase(feild)
                || TuFields.main_business.equalsIgnoreCase(feild)
                || TuFields.business_scope.equalsIgnoreCase(feild)
                || TuFields.introduction.equalsIgnoreCase(feild)
                || TuFields.city.equalsIgnoreCase(feild)
                || TuFields.province.equalsIgnoreCase(feild)
                || TuFields.setup_date.equalsIgnoreCase(feild)
                || TuFields.chairman.equalsIgnoreCase(feild)
                || TuFields.curr_type.equalsIgnoreCase(feild)
                || TuFields.bz_item.equalsIgnoreCase(feild)
                || TuFields.bz_code.equalsIgnoreCase(feild)
                || TuFields.delist_date.equalsIgnoreCase(feild)
                || TuFields.div_proc.equalsIgnoreCase(feild)
        ) {
            if (jsonElement == null || jsonElement.isJsonNull()) {
                return null;
            }
            else {
                return jsonElement.getAsString();
            }
        }
        else if (TuFields.change_vol.equalsIgnoreCase(feild)
                || TuFields.after_share.equalsIgnoreCase(feild)
                || TuFields.employees.equalsIgnoreCase(feild)
        ) {
            if (jsonElement == null || jsonElement.isJsonNull()) {
                return null;
            }
            else {
                return jsonElement.getAsLong();
            }
        }
        else if (TuFields.holder_num.equalsIgnoreCase(feild)
        ) {
            if (jsonElement == null || jsonElement.isJsonNull()) {
                return null;
            }
            else {
                return jsonElement.getAsInt();
            }
        }
        else {
            if (jsonElement == null || jsonElement.isJsonNull() || jsonElement.getAsBigDecimal() == null) {
                return BigDecimal.ZERO;
            } else {
                return jsonElement.getAsBigDecimal();
            }
        }
    }
}
