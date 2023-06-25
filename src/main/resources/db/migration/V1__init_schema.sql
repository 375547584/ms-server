DROP TABLE IF EXISTS `stock_day`;
CREATE TABLE `stock_day` (
    `id` varchar(64) NOT NULL DEFAULT '' COMMENT 'id',
    `day_date` date NOT NULL COMMENT '日期',

    `symbol` varchar(24) NOT NULL DEFAULT '' COMMENT '股票symbol',
    `code` varchar(12) NOT NULL DEFAULT '' COMMENT '股票代码',
    `name` varchar(50) DEFAULT '' COMMENT '股票名称',
    `stock_jane_spell` varchar(50) DEFAULT '' COMMENT '股票简拼',
    `block` varchar(6)  DEFAULT NULL COMMENT '股票交易所，sh-上海 sz-深圳',

    `state` varchar(50) DEFAULT NULL COMMENT '股票状态',
    `date` varchar(50) DEFAULT '' COMMENT '交易日',
    `time` varchar(50) DEFAULT '' COMMENT '交易时间',

    `price` decimal(16,8) DEFAULT NULL COMMENT '当前价格',
    `increase` decimal(16,4) DEFAULT NULL COMMENT '涨跌幅',
    `risefall` decimal(16,4) DEFAULT NULL COMMENT '涨跌额',

    `open_price` decimal(16,8) DEFAULT NULL COMMENT '开盘价',
    `y_close` decimal(16,8) DEFAULT NULL COMMENT '昨日收盘价',
    `high_price` decimal(16,8) DEFAULT NULL COMMENT '最高股价',
    `low_price` decimal(16,8) DEFAULT NULL COMMENT '最低股价',
    `avprice` decimal(16,8) DEFAULT NULL COMMENT '均价股价',

    `amplitude` decimal(16,4) DEFAULT NULL COMMENT '振幅',
    `volratio` decimal(16,4) DEFAULT NULL COMMENT '量比',
    `bookrate` decimal(16,4) DEFAULT NULL COMMENT '委比',
    `bookdiffer` decimal(16,4) DEFAULT NULL COMMENT '委差',
    `increaseweek1` decimal(16,4) DEFAULT NULL COMMENT '1周涨幅',
    `increaseweek4` decimal(16,4) DEFAULT NULL COMMENT '4周涨幅',
    `increaseweek13` decimal(16,4) DEFAULT NULL COMMENT '23周涨幅',
    `increaseweek26` decimal(16,4) DEFAULT NULL COMMENT '26周涨幅',
    `increaseweek52` decimal(16,4) DEFAULT NULL COMMENT '52周涨幅',
    `increasethisyear` decimal(16,4) DEFAULT NULL COMMENT '今年以来涨幅',

    `firstday` decimal(16,4) DEFAULT NULL COMMENT '上市日期',

    `exchange_rate` decimal(16,4) DEFAULT NULL COMMENT '换手率',
    `pe` decimal(16,4) DEFAULT NULL COMMENT '市盈率（静） 当前的价格/上一年的EPS',
    `pe2` decimal(16,4) DEFAULT NULL COMMENT '市盈率（TTM） 当前的价格/滚动12个月的EPS',
    `pe3` decimal(16,4) DEFAULT NULL COMMENT '市盈率（动） 股票当前价格/预测12个月的eps',
    `eps` decimal(16,4) DEFAULT NULL COMMENT '每股收益 LYR',
    `eps2` decimal(16,4) DEFAULT NULL COMMENT '每股收益 TTM',
    `eps3` decimal(16,4) DEFAULT NULL COMMENT '预测EPS',
    `pb` decimal(16,4) DEFAULT NULL COMMENT '市净率',
    `bv` decimal(16,4) DEFAULT NULL COMMENT '每股净资产',
    `roe` decimal(16,4) DEFAULT NULL COMMENT 'ROE净资产收益率',
    `salesrevenue` decimal(30,4) DEFAULT NULL COMMENT '销售收入',
    `netprofit` decimal(30,4) DEFAULT NULL COMMENT '净利润',

    `stop` int DEFAULT '0' COMMENT '停牌股票数量',
    `up` int DEFAULT '0' COMMENT '涨停股票数量',
    `down` int DEFAULT '0' COMMENT '跌停股票数量',
    `unchanged` int DEFAULT '0' COMMENT '平盘的股票数量',

    `fall_stop_price` decimal(16,4) DEFAULT NULL COMMENT '跌停价',
    `rise_stop_price` decimal(16,4) DEFAULT NULL COMMENT '涨停价',

    `totale_quity`bigint(20) DEFAULT NULL COMMENT '总股本',
    `folwe_quity` bigint(20) DEFAULT NULL COMMENT '流通股本',
    `totale_value` decimal(30,4) DEFAULT NULL COMMENT '总市值',
    `folwe_value` decimal(30,4) DEFAULT NULL COMMENT '流通市值',

    `vol` bigint(20) NOT NULL DEFAULT '0' COMMENT '成交量',
    `amount` decimal(20,4) DEFAULT NULL COMMENT '成交额',
    `volin` bigint(20) NOT NULL DEFAULT '0' COMMENT '内盘总量',
    `volout` bigint(20) NOT NULL DEFAULT '0' COMMENT '外盘总量',

    `flowin` decimal(20,4) NOT NULL DEFAULT '0' COMMENT '资金流入',
    `flowout` decimal(20,4) NOT NULL DEFAULT '0' COMMENT '资金流出',

    `superin` decimal(20,4) DEFAULT NULL COMMENT '超大单流入',
    `superout` decimal(20,4) DEFAULT NULL COMMENT '超大单流出',
    `bigin` decimal(20,4) DEFAULT NULL COMMENT '大单流入',
    `bigout` decimal(20,4) DEFAULT NULL COMMENT '大单流出',
    `midin` decimal(20,4) DEFAULT NULL COMMENT '中单流入',
    `midout` decimal(20,4) DEFAULT NULL COMMENT '中单流出',
    `smallin` decimal(20,4) DEFAULT NULL COMMENT '小单流入',
    `smallout` decimal(20,4) DEFAULT NULL COMMENT '小单流出',

    `isindex` int DEFAULT '0' COMMENT '是否指数 0否，1是（默认0）',
    `is_delisting` tinyint unsigned DEFAULT '0' COMMENT '是否退市 0否，1是（默认0）',
    `is_suspension` tinyint NOT NULL DEFAULT '0' COMMENT '是否停牌 0否，1是（默认0）',
    `is_new` tinyint DEFAULT '0' COMMENT '是否为新股 0否，1是（默认0）',
    `is_sub_new` tinyint DEFAULT '0' COMMENT '是否为次新股 0否，1是（默认0）',
    `is_sh` tinyint DEFAULT '0' COMMENT '是否沪市 0否，1是（默认0）',
    `is_sz` tinyint DEFAULT '0' COMMENT '是否深市 0否，1是（默认0）',
    `is_kc` tinyint DEFAULT '0' COMMENT '是否科创板 0否，1是（默认0）',
    `is_cy` tinyint DEFAULT '0' COMMENT '是否创业板 0否，1是（默认0）',
    `is_zx` tinyint DEFAULT '0' COMMENT '是否中小板 0否，1是（默认0）',

    `update_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',

    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_code_date` (`day_date`,`code`),
    KEY `index_date` (`day_date`) USING BTREE,
    KEY `index_code` (`code`) USING BTREE
) ENGINE=InnoDB ROW_FORMAT=DYNAMIC DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci  COMMENT='股票快照日表';

DROP TABLE IF EXISTS `block_relation`;
CREATE TABLE `block_relation` (
  `code` varchar(32) NOT NULL DEFAULT '' COMMENT '板块代码',
  `name` varchar(50) DEFAULT '' COMMENT '股票名称',
  `level` int DEFAULT '1' COMMENT '层级',
  `parent_code` varchar(32) DEFAULT '' COMMENT '上级板块Code',
  `code_path` varchar(4096) DEFAULT '' COMMENT '板块层级 cn/cna',
  `update_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB ROW_FORMAT=DYNAMIC DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci  COMMENT='板块关系表';

DROP TABLE IF EXISTS `stock_minute`;
CREATE TABLE `block_stock_relation` (
    `id` varchar(64) NOT NULL DEFAULT '' COMMENT 'id',
    `block_type` int DEFAULT '1' COMMENT '板块类型 0-region 1-industry 2-concept',
    `code` varchar(32) NOT NULL DEFAULT '' COMMENT '板块代码',
    `name` varchar(50) DEFAULT '' COMMENT '板块名称',
    `stock_code` varchar(32) DEFAULT '' COMMENT '股票代码',
    `update_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `index_code` (`code`) USING BTREE,
    KEY `index_stock_code` (`stock_code`) USING BTREE
) ENGINE=InnoDB ROW_FORMAT=DYNAMIC DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='板块股票关系表';