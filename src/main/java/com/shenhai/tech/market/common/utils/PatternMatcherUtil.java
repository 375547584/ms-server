package com.shenhai.tech.market.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PatternMatcherUtil {
    /**
     * @param reg
     * @param content
     * @return
     * @description 获取匹配的字符串
     */
    public static List<String> getMatcher(String reg, String content) {
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(content);
        List<String> result = new ArrayList<String>();
        while (matcher.find()) {
            result.add(matcher.group(0));
        }
        return result;
    }

    public static String getMatcherString(String reg, String content) {
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            return matcher.group(0);
        }
        return "";
    }

    public static List<String> getMatcher(String reg, List<String> content) {
        return content.stream().map(item -> getMatcherString(reg, item)).collect(Collectors.toList());
    }

//    public static void main(String[] args) {
//        String result = PatternMatcherUtil.getMatcherString("派\\d+\\.?\\d*", "10派0.30(含税)").replace("派", "");
//        System.out.println(result);
//        result = PatternMatcherUtil.getMatcherString("增\\d+", "10转增7").replace("增", "");
//        System.out.println(result);
//        result = PatternMatcherUtil.getMatcherString("送\\d+", "10送7").replace("送", "");
//        System.out.println(result);
//    }
}
