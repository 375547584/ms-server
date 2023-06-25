package com.shenhai.tech.market.project.controller;

import com.shenhai.tech.market.common.response.APIResult;
import com.shenhai.tech.market.common.response.APIResultWrap;
import com.shenhai.tech.market.project.cache.ConstantCache;
import com.shenhai.tech.market.project.controller.param.HolidaysParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/config")
@Slf4j
public class StockConfigController {

    @ApiOperation(value = "心跳")
    @GetMapping("/heartbeat")
    public APIResult<String> heartbeat() {
        return APIResultWrap.ok();
    }

    @ApiOperation(value = "配置实时数据方式")
    @PostMapping("/setRealtime")
    public APIResult<String> setRealtime(@RequestParam("realtime") String realtime) {
        ConstantCache.setRealtime(realtime);
        return APIResultWrap.ok();
    }

    @ApiOperation(value = "更新节假日日期")
    @PostMapping("/updateHolidays")
    public APIResult<String> updateHolidays(@RequestBody HolidaysParam param) {
        ConstantCache.setHolidays(param.getHolidays());
        return APIResultWrap.ok();
    }

    @ApiOperation(value = "获取当前配置的节假日日期")
    @PostMapping("/getHolidays")
    public APIResult<String> getHolidays() {
        return APIResultWrap.ok(ConstantCache.getHolidays());
    }
}
