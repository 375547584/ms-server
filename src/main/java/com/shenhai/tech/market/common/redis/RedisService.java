package com.shenhai.tech.market.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * spring redis 工具类
 *
 * @author capital
 **/
@SuppressWarnings(value = {"unchecked", "rawtypes"})
@Configuration
public class RedisService {

    @Autowired
    public RedisTemplate redisTemplate;

    @Value("${spring.profiles.active}")
    protected String env;

    public final static long DAY_SECOND = 24 * 3600;

    /**
     * 缓存基本的对象，Integer、String、实体类等
     *
     * @param key   缓存的键值
     * @param value 缓存的值
     */
    public <T> void setCacheObject(final String key, final T value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 缓存基本的对象，Integer、String、实体类等
     *
     * @param key      缓存的键值
     * @param value    缓存的值
     * @param timeout  时间
     * @param timeUnit 时间颗粒度
     */
    public <T> void setCacheObject(final String key, final T value, final Long timeout, final TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
    }

    /**
     * 设置有效时间
     *
     * @param key     Redis键
     * @param timeout 超时时间
     * @return true=设置成功；false=设置失败
     */
    public boolean expire(final String key, final long timeout) {
        return expire(key, timeout, TimeUnit.SECONDS);
    }

    /**
     * 设置有效时间
     *
     * @param key     Redis键
     * @param timeout 超时时间
     * @param unit    时间单位
     * @return true=设置成功；false=设置失败
     */
    public boolean expire(final String key, final long timeout, final TimeUnit unit) {
        return redisTemplate.expire(key, timeout, unit);
    }

    /**
     * 获取有效时间
     *
     * @param key Redis键
     * @return 有效时间
     */
    public long getExpire(final String key) {
        return redisTemplate.getExpire(key);
    }

    /**
     * 判断 key是否存在
     *
     * @param key 键
     * @return true 存在 false不存在
     */
    public Boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 获得缓存的基本对象。
     *
     * @param key 缓存键值
     * @return 缓存键值对应的数据
     */
    public <T> T getCacheObject(final String key) {
        ValueOperations<String, T> operation = redisTemplate.opsForValue();
        return operation.get(key);
    }

    /**
     * 删除单个对象
     *
     * @param key
     */
    public boolean deleteObject(final String key) {
        return redisTemplate.delete(key);
    }

    /**
     * 删除集合对象
     *
     * @param collection 多个对象
     * @return
     */
    public long deleteObject(final Collection collection) {
        return redisTemplate.delete(collection);
    }

    public void batchDel(String... pattern) {
        for (String kp : pattern) {
            redisTemplate.delete(redisTemplate.keys(kp + "*"));
        }
    }

    /**
     * 缓存List数据
     *
     * @param key      缓存的键值
     * @param dataList 待缓存的List数据
     * @return 缓存的对象
     */
    public <T> long setCacheList(final String key, final List<T> dataList, final long timeout, final TimeUnit unit) {
        if(dataList == null || dataList.isEmpty()) {
            return 0;
        }
        Long count = redisTemplate.opsForList().rightPushAll(key, dataList);
        expire(key, timeout, unit);
        return count == null ? 0 : count;
    }

    /**
     * 缓存List数据
     *
     * @param key      缓存的键值
     * @param dataList 待缓存的List数据
     * @return 缓存的对象
     */
    public <T> long setCacheList(final String key, final List<T> dataList) {
        if(dataList == null || dataList.isEmpty()) {
            return 0;
        }
        Long count = redisTemplate.opsForList().rightPushAll(key, dataList);
        return count == null ? 0 : count;
    }

    /**
     * 获得缓存的list对象
     *
     * @param key 缓存的键值
     * @return 缓存键值对应的数据
     */
    public <T> List<T> getCacheList(final String key) {
        return redisTemplate.opsForList().range(key, 0, -1);
    }


    /**
     * 获得缓存的list对象
     *
     * @param key 缓存的键值
     * @return 缓存键值对应的数据
     */
    public <T> List<T> getCacheLinkedList(final String key) {
        return  redisTemplate.opsForList().range(key, 0, -1);
    }

    /**
     * 缓存Set
     *
     * @param key     缓存键值
     * @param dataSet 缓存的数据
     * @return 缓存数据的对象
     */
    public <T> BoundSetOperations<String, T> setCacheSet(final String key, final Set<T> dataSet) {
        BoundSetOperations<String, T> setOperation = redisTemplate.boundSetOps(key);
        Iterator<T> it = dataSet.iterator();
        while (it.hasNext()) {
            setOperation.add(it.next());
        }
        return setOperation;
    }

    /**
     * 获得缓存的set
     *
     * @param key
     * @return
     */
    public <T> Set<T> getCacheSet(final String key) {
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * 检测set里面是否有该元素
     *
     * @param key
     * @param member
     * @return
     */
    public Boolean checkSetMember(final String key, final Object member) {
        return redisTemplate.opsForSet().isMember(key, member);
    }

    /**
     * 缓存Map
     *
     * @param key
     * @param dataMap
     */
    public <T> void setCacheMap(final String key, final Map<String, T> dataMap) {
        if (dataMap != null) {
            redisTemplate.opsForHash().putAll(key, dataMap);
        }
    }

    /**
     * 缓存Map
     *
     * @param key
     * @param dataMap
     */
    public <T> void setCacheMap(final String key, final Map<String, T> dataMap, final long timeout, final TimeUnit unit) {
        if (dataMap != null) {
            redisTemplate.opsForHash().putAll(key, dataMap);
            expire(key, timeout, unit);
        }
    }

    /**
     * 获得缓存的Map
     *
     * @param key
     * @return
     */
    public <T> Map<String, T> getCacheMap(final String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 往Hash中存入数据
     *
     * @param key   Redis键
     * @param hKey  Hash键
     * @param value 值
     */
    public <T> void setCacheMapValue(final String key, final String hKey, final T value) {
        redisTemplate.opsForHash().put(key, hKey, value);
    }

    /**
     * 获取Hash中的数据
     *
     * @param key  Redis键
     * @param hKey Hash键
     * @return Hash中的对象
     */
    public <T> T getCacheMapValue(final String key, final String hKey) {
        HashOperations<String, String, T> opsForHash = redisTemplate.opsForHash();
        return opsForHash.get(key, hKey);
    }

    /**
     * 获取多个Hash中的数据
     *
     * @param key   Redis键
     * @param hKeys Hash键集合
     * @return Hash对象集合
     */
    public <T> List<T> getMultiCacheMapValue(final String key, final Collection<Object> hKeys) {
        return redisTemplate.opsForHash().multiGet(key, hKeys);
    }

    /**
     * 获得缓存的基本对象列表
     *
     * @param pattern 字符串前缀
     * @return 对象列表
     */
    public Collection<String> keys(final String pattern) {
        return redisTemplate.keys(pattern);
    }








    public boolean tryLock(String key, int second) {
        //如果 key 不存在，设置 key 以保存字符串值和过期超时,// 对应setnx命令, true - key不存在 false-kay已存在
        Boolean state = redisTemplate.opsForValue().setIfAbsent(key, UUID.randomUUID().toString(), Duration.of(second, ChronoUnit.SECONDS));
        if (Boolean.FALSE.equals(state)) {
            return false;
        }
        return true;
    }

    public void tryLock(String key, Supplier<Boolean> supplier) {
        tryLock(key, 10, supplier);
    }

    public void tryLock(String key, int second, Supplier<Boolean> supplier) {
        //如果 key 不存在，设置 key 以保存字符串值和过期超时,// 对应setnx命令, true - key不存在 false-kay已存在
        Boolean state = redisTemplate.opsForValue().setIfAbsent(key, UUID.randomUUID().toString(), Duration.of(second, ChronoUnit.SECONDS));
        if (Boolean.FALSE.equals(state)) {
            return;
        }
        try {
            supplier.get();
        } finally {
            redisTemplate.delete(key);
        }
    }

    public void tryLock(String key, int second, String uniqueId, Supplier<Boolean> supplier) {
        //如果 key 不存在，设置 key 以保存字符串值和过期超时,// 对应setnx命令, true - key不存在 false-kay已存在
        Boolean state = redisTemplate.opsForValue().setIfAbsent(key, uniqueId, Duration.of(second, ChronoUnit.SECONDS));
        if (Boolean.FALSE.equals(state)) {
            return;
        }
        try {
            supplier.get();
        }
        finally {
            redisTemplate.delete(key);
        }
    }

    public <T> List<T> getList(String key, Supplier<List<T>> supplier) {
        return getList(key, DAY_SECOND, supplier);
    }

    public <T> List<T> getList(String key, long second, Supplier<List<T>> supplier) {
        //TODO 缓存数据
        List<T> data = this.getCacheList(key);
        if (data == null || data.size() == 0) {
            data = supplier.get();
            if (data != null && data.size() > 0) {
                this.setCacheList(key, data);
                expire(key, second);
            }
        }
        return data;
    }

    public <T> List<T> getList(String key, Supplier<List<T>> supplier, final long timeout, final TimeUnit unit) {
        //TODO 缓存数据
        List<T> data = this.getCacheList(key);
        if (data == null || data.size() == 0) {
            data = supplier.get();
            if (data != null && data.size() > 0) {
                this.setCacheList(key, data);
                expire(key, timeout, unit);
            }
        }
        return data;
    }

    public <T> T get(String key, Supplier<T> supplier) {
        //TODO 读缓存数据
        T data = this.getCacheObject(key);
        if (data == null) {
            data = supplier.get();
            if (data != null) {
                this.setCacheObject(key, data);
            }
        }
        return data;
    }

    public <T> T get(String key, Supplier<T> supplier, final long timeout, final TimeUnit unit) {
        //TODO 读缓存数据
        T data = this.getCacheObject(key);
        if (data == null) {
            data = supplier.get();
            if (data != null) {
                this.setCacheObject(key, data);
                expire(key, timeout, unit);
            }
        }
        return data;
    }

    public <T> T get(String key, Supplier<T> supplier, T empty) {
        //TODO 读缓存数据
        T data = this.getCacheObject(key);
        if (data == null) {
            data = supplier.get();
            if (data == null) {
                data = empty;
            }
            this.setCacheObject(key, data);
        }
        return data;
    }
}
