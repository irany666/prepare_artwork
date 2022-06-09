package com.shujian.server.kits;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.FIFOCache;
import cn.hutool.cache.impl.LFUCache;
import com.shujian.server.constants.RedisConstants;
import com.shujian.server.manager.service.IQuestionService;
import org.redisson.api.RQueue;
import org.redisson.api.RSet;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * 已使用问题缓存
 * 本地版
 * Created by shujian.ou 2022/6/6 23:37
 */
@Component
public class QuestionUsedCache {

    @Resource
    private RedissonClient redissonClient;

    @Resource
    private IQuestionService questionService;

    private FIFOCache<Long, Object> cache;

    @PostConstruct
    public void init() {
        long count = questionService.count();
        cache = CacheUtil.newFIFOCache((int) (count - 1));

        RQueue<Long> queue = redissonClient.getQueue(RedisConstants.Question.RANDOM_QUESTION_USED_COLLECTION);

        List<Long> objects = queue.readAll();

        for (Long key : objects) {
            cache.put(key, null);
        }

    }

    public void put(Long key) {
        cache.put(key, null);
    }

    public boolean exist(Long key) {
        return cache.containsKey(key);
    }

    public Set<Long> keySet() {
        return cache.keySet();
    }
}
