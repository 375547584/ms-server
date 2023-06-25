package com.shenhai.tech.market.common.utils;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.shenhai.tech.market.project.service.entity.StockExRights;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;
/**
 * stream流操作工具类
 * @author Jozz
 */
public class StreamUtil {
    public static <T> List<T> selectList(List<T> srcList, Predicate<? super T> predicate) {
        if(StringUtils.isEmpty(srcList)) {
            return null;
        }
        if(predicate == null) {
            return srcList;
        }
        return srcList.stream().filter(predicate).collect(Collectors.toList());
    }

    public static <T> List<T> selectList(List<T> srcList, Predicate<? super T> predicate, Comparator<? super T> comparator, Integer beginNum, Integer finishNum) {
        if(StringUtils.isEmpty(srcList)) {
            return srcList;
        }
        if(beginNum == null) {
            beginNum = 0;
        }
        if(finishNum == null) {
            finishNum = 10;
        }
        int limit = finishNum - beginNum;
        if(limit < 0) {
            limit = 0;
        }
        if(comparator == null && predicate == null) {
            return srcList.stream().skip(beginNum).limit(limit).collect(Collectors.toList());
        }

        if(comparator == null) {
            return srcList.stream().filter(predicate).skip(beginNum).limit(limit).collect(Collectors.toList());
        }

        if(predicate == null) {
            return srcList.stream().sorted(comparator).skip(beginNum).limit(limit).collect(Collectors.toList());
        }

        return srcList.stream().filter(predicate).sorted(comparator).skip(beginNum).limit(limit).collect(Collectors.toList());
    }

    public static <T> List<T> selectList(List<T> srcList, Comparator<? super T> comparator, Integer beginNum, Integer finishNum) {
        if(StringUtils.isEmpty(srcList)) {
            return srcList;
        }
        if(beginNum == null) {
            beginNum = 0;
        }
        if(finishNum == null) {
            finishNum = 10;
        }
        int limit = finishNum - beginNum;
        if(limit < 0) {
            limit = 0;
        }
        if(comparator == null) {
            return srcList.stream().skip(beginNum).limit(limit).collect(Collectors.toList());
        }
        return srcList.stream().sorted(comparator).skip(beginNum).limit(limit).collect(Collectors.toList());
    }


    public static <T> List<T> selectPageList(List<T> srcList, Predicate<? super T> predicate, Integer pageBegin, Integer pageSize) {
        if(StringUtils.isEmpty(srcList)) {
            return srcList;
        }

        long skip = 0;
        if(pageBegin > 0) {
            skip = BigDecimalUtil.multiply((pageBegin-1), pageSize);
        }
        if(predicate == null) {
            return srcList.stream().skip(skip).limit(pageSize).collect(Collectors.toList());
        }
        return srcList.stream().filter(predicate).skip(skip).limit(pageSize).collect(Collectors.toList());
    }

    public static <T> T selectOne(List<T> srcList, Predicate<? super T> predicate) {
        if(StringUtils.isEmpty(srcList)) {
            return null;
        }
        List<T> resultList;
        if(predicate == null) {
            resultList = srcList.stream().collect(Collectors.toList());
        }
        else {
            resultList = srcList.stream().filter(predicate).collect(Collectors.toList());
        }

        if(StringUtils.isNotEmpty(resultList)) {
            return resultList.get(0);
        }
        return null;
    }


    public static <T> long count(List<T> srcList, Predicate<? super T> predicate) {
        if(predicate == null) {
            return srcList.size();
        }
        else {
            return srcList.stream().filter(predicate).count();
        }

    }

    public static <T> long sumInt(List<T> srcList, ToIntFunction<? super T> mapper) {
        IntSummaryStatistics collect = srcList.stream().collect(Collectors.summarizingInt(mapper));
        return collect.getSum();
    }

    /**
     * List通过Map映射成新List列表
     * @param srcList 原始List
     * @param mapper 元素映射器
     * @param <L>
     * @param <R>
     * @return
     */
    public static <L, R> List<R> castList(List<L> srcList, Function<L, R> mapper) {
        if (StringUtils.isEmpty(srcList)){
            return new ArrayList<>();
        }
        return srcList.stream().map(mapper).collect(Collectors.toList());
    }


    /**
     * List通过Map映射成新List列表
     * @param srcList 原始List
     * @param mapper 元素映射器
     * @param <L>
     * @param <R>
     * @return
     */
    public static <L, R> List<R> castDistinctList(List<L> srcList, Function<L, R> mapper) {
        if (StringUtils.isEmpty(srcList)){
            return new ArrayList<>();
        }
        return distinct(srcList.stream().map(mapper).collect(Collectors.toList()));
    }

    /**
     * List转Map
     * @param srcList 原始List
     * @param mapper 映射器：将List元素映射成Map的key
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> Map<R, T> castMap(List<T> srcList, Function<? super T, ? extends R> mapper) {
        if (StringUtils.isEmpty(srcList)) {
            return getEmptyMap();
        }
        return srcList.stream().distinct().collect(Collectors.toMap(mapper, v -> v));
    }

    /**
     * List通过Map映射成Set列表
     * @param srcList 原始list
     * @param mapper 元素映射器
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> Set<R> listMap2Set(List<T> srcList, Function<? super T, ? extends R> mapper) {
        if (StringUtils.isEmpty(srcList)) {
            return getEmptySet();
        }
        if(mapper == null) {
            return getEmptySet();
        }
        return srcList.stream().map(mapper).collect(Collectors.toSet());
    }

    /**
     * List通过Map映射成新List列表
     * @param srcList 原始List
     * @param mapper 元素映射器
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> List<R> listMap2List(List<T> srcList, Function<? super T, ? extends R> mapper) {
        if (StringUtils.isEmpty(srcList)) {
            return getEmptyList();
        }
        if(mapper == null) {
            return getEmptyList();
        }
        return srcList.stream().map(mapper).collect(Collectors.toList());
    }

    /**
     * List转Map，保持原始顺序
     * @param srcList 原始List
     * @param mapper 映射器：将List元素映射成Map的key
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> Map<R, T> list2MapKeepOrder(List<T> srcList, Function<? super T, ? extends R> mapper) {
        if (StringUtils.isEmpty(srcList)) {
            return getEmptyMap();
        }
        // 获取key
        List<? extends R> keys = listMap2List(srcList, mapper);
        Map<R, T> retMap = new LinkedHashMap<>(srcList.size());

        Map<? extends R, T> tmpMap = castMap(srcList, mapper);
        keys.forEach(k -> retMap.put(k, tmpMap.get(k)));

        return retMap;
    }

    /**
     * 过滤
     * @param list
     * @param pre
     * @param <T>
     * @return data为空返回data
     */
    public static <T> List<T> filter(List<T> list, Predicate<? super T> pre) {
        if (StringUtils.isEmpty(list)){
            return list;
        }
        if(pre == null) {
            return list;
        }
        return list.stream().filter(pre).collect(Collectors.toList());
    }


    /**
     * 排序
     * @param list
     * @param comparator
     * @param <T>
     * @return data为空返回data
     */
    public static <T> List<T> sorted(List<T> list, Comparator<T> comparator){
        if (StringUtils.isEmpty(list)){
            return list;
        }
        if(comparator == null) {
            return list;
        }

        return list.stream().sorted(comparator).collect(Collectors.toList());
    }

    /**
     * 去重
     * @param list
     * @param <T>
     * @return data为空返回data
     */
    public static <T> List<T> distinct(List<T> list){
        if (StringUtils.isEmpty(list)){
            return list;
        }
        return list.stream().distinct().collect(Collectors.toList());
    }

    /**
     * 判断是否包含匹配元素
     * @param list
     * @param pre
     * @param <T>
     * @return data为空返回false
     */
    public static <T> boolean anyMatch(List<T> list, Predicate<T> pre){
        if (StringUtils.isEmpty(list)){
            return false;
        }
        return list.parallelStream().anyMatch(pre);
    }

    /**
     * 将list进行join操作
     * @param list
     * @param join
     * @return 返回join之后的字符串,data为空返回null
     */
    public static String join(List<String> list, String join){
        if (StringUtils.isEmpty(list)){
            return null;
        }
        return list.stream().collect(Collectors.joining(join == null ? "" : join));
    }

    public static<T> Optional<T> findAny(List<T> list, Predicate<? super T> predicate) {
        return list.stream().filter(predicate).findAny();
    }




    /**
     * 获取列表的第一个满足条件的元素，第一个元素为空抛异常
     * @param list
     * @param <T>
     * @return
     */
    public static <T> Optional<T> first(List<T> list, Predicate<? super T> predicate) {
        return list.stream().filter(predicate).findFirst();
    }


    /**
     * 获取列表的第一个元素，第一个元素为空抛异常
     * @param list
     * @param <T>
     * @return
     */
    public static <T> Optional<T> first(List<T> list) {
        return list.stream().findFirst();
    }


    public static <T> T findMax(List<T> list, Comparator<T> comparator) {
        if(StringUtils.isEmpty(list)) {
            return null;
        }
        Optional<T> optional = list.stream().max(comparator);
        return optional.orElse(null);
    }

    /**
     * 根据过滤条件筛选，返回结果中有值的时候返回值；没有值的时候会抛出异常
     * @param list
     * @param predicate
     * @param <T>
     * @return
     */
    public static <T> T firstNotNull(List<T> list, Predicate<? super T> predicate) {
        /// orElseThrow 当 Optional 中有值的时候，返回值；没有值的时候会抛出异常
        return first(list, predicate).orElseThrow();
    }


    /**
     * 获取列表的第一个元素，Optional结果中有值的时候返回值；没有值的时候会抛出异常
     * @param list
     * @param <T>
     * @return
     */
    public static <T> T firstNotNull(List<T> list) {
        return first(list).orElseThrow();
    }



    public static <T, R> List<R> map(List<T> list, Function<? super T, ? extends R> mapper) {
        return list.stream().map(mapper).collect(Collectors.toList());
    }

    public static <T> T last(List<T> list) {
        return list.get(list.size() - 1);
    }


    private static <E> Set<E> getEmptySet() {
        return Sets.newHashSet();
    }

    private static <K, V> Map<K, V> getEmptyMap() {
        return Maps.newHashMap();
    }

    private static <E> List<E> getEmptyList() {
        return Lists.newArrayList();
    }

    public static void main(String[] args) {
//        List<String> tempList = new ArrayList<>();
//        tempList.add("a");
//        tempList.add("b");
//        tempList.add("c");
//        tempList.add("d");
//
//        Optional<String> optional =  StreamUtil.findAny(tempList, t -> {
//            if("e".equalsIgnoreCase(t)) {
//                return true;
//            }
//            return false;
//        });
//
//        if(optional.isPresent()) {
//            System.out.println("true");
//        }
//
//        // 1. 给定的对象为 null, 将会抛出异常
//        List<String> dataList = null;
//        try {
//            Optional.ofNullable(dataList).orElseThrow(() -> new RuntimeException("1 dataList 对象为空\r\n")).forEach(t -> System.out.println("1:" + t));
//        } catch (Exception e) {
//            System.out.print(e);
//        }
//
//        // 2. 给定的对象为 null, 将会抛出异常
//        dataList = new ArrayList<>();
//        try {
//            Optional.ofNullable(dataList).orElseThrow(() -> new RuntimeException("2 dataList 对象为空\r\n")).forEach(t -> System.out.println("2:" + t));
//        } catch (Exception e) {
//            System.out.print(e);
//        }
//
//        // 3. 给定的对象不为 null, 不会抛出异常
//        dataList = tempList;
//        Optional.ofNullable(dataList).orElseThrow(() -> new RuntimeException("3 dataList 对象为空\r\n")).forEach(t -> System.out.println("3:" + t));
//
//
//        List<String> dataListV = new ArrayList<>();
//        dataListV.add("a");
//        dataListV.add("b");
//        dataListV.add("ca");
//        dataListV.add("d");
//
//        List<String> finalDataList = tempList;
//        Set<String> vos = dataListV.stream().map(v -> {
//            System.out.println(v);
//            String aa = StreamUtil.firstNotNull(finalDataList, x -> v.equals(x));
//            return aa;
//        }).collect(Collectors.toSet());
//        System.out.print(vos.size());



//        List<String> tempList = new ArrayList<>();
//        tempList.add("a");
//        tempList.add("b");
//        tempList.add("c");
//        tempList.add("d");
//
//        // 1. 给定的对象为 null, 将会返回 orElse 方法提供的对象
//        List<String> dataList = null;
//        Optional.ofNullable(dataList).orElse(tempList).forEach(t -> System.out.println("1:" + t));
//
//        // 2. 给定的对象不为 null, 不会返回 orElse 方法提供的对象
//        dataList = new ArrayList<>();
//        dataList.add("aa");
//        dataList.add("ab");
//        dataList.add("ac");
//
//        Optional.ofNullable(dataList)
//                .orElse(tempList)
//                .forEach(t -> System.out.println("2:" + t));
//
//        // 3. 给定的对象不为 null 但是为 empty, 不会返回 orElse 方法提供的对象
//        dataList = new ArrayList<>();
//        Optional.ofNullable(dataList)
//                .orElse(tempList)
//                .forEach(t -> System.out.println("3:" + t));
    }
}