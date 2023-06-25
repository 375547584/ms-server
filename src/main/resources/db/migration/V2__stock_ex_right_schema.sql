DROP TABLE IF EXISTS `stock_ex_rights`;
CREATE TABLE `stock_ex_rights` (
    `id` varchar(64) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'id',
    `stock_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '股票代码',
    `stock_name` varchar(64) DEFAULT NULL,
    `rebate` decimal(10,2) DEFAULT '0.00' COMMENT '10股转增',
    `bonus` decimal(10,2) DEFAULT '0.00' COMMENT '10股送股',
    `dividend` decimal(10,2) DEFAULT '0.00' COMMENT '10股分红',
    `ann_date` date NOT NULL COMMENT '公告日',
    `register_date` date NOT NULL COMMENT '登记日',
    `dividend_date` date NOT NULL COMMENT '除权除息日',
    `payable_date` date DEFAULT NULL COMMENT '派息日',
    `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
    `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_date` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `uq_key` (`stock_code`,`dividend_date`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='股票除权除息';