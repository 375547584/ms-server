package com.shenhai.tech.market.project.strategy.constant;

import java.util.Arrays;
import java.util.List;

/**
 * 股票常量信息
 *
 * @author capital
 */
public class Symbols {

    /**
     * 所有沪市主板
     */
    public static String BlockSH = "SHA.ci";
    /**
     * 所有深市主板
     */
    public static String BlockSZ = "SZA.ci";
    /**
     * 所有中小主板
     */
    public static String BlockZX = "SME.ci";
    /**
     * 所有创业主板
     */
    public static String BlockCY = "GEM.ci";
    /**
     * 所有沪深A股
     */
    public static String CNASymbol = "CNA.ci";

    /**
     * 所有沪深A股
     */
    public static String CNACode = "CNA";
    /**
     * 上证指数
     */
    public static String sh_index = "000001.sh";
    /**
     * 深证指数
     */
    public static String sz_index = "399001.sz";
    /**
     * 创业板指数
     */
    public static String cy_index = "399006.sz";


    /**
     * 上证指数
     */
    public static String sh_code = "000001";
    /**
     * 深证指数
     */
    public static String sz_code = "399001";
    /**
     * 创业板指数
     */
    public static String cy_code = "399006";


    /**
     * 上证、深证、创业三大指数代码
     */
    public static List<String> indexSymbols = Arrays.asList("000001.sh", "399001.sz", "399006.sz");

    /**
     * 上证、深证、创业三大指数代码
     */
    public static List<String> indexCodes = Arrays.asList("000001", "399001", "399006");
}
