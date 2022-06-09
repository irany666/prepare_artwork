package com.shujian.server.job;

import cn.hutool.cron.CronUtil;
import cn.hutool.cron.task.Task;
import com.shujian.server.constants.RedisConstants;
import com.shujian.server.kits.QuestionUsedCache;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RQueue;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Set;

/**
 * Created by shujian.ou 2022/6/6 23:52
 */
@Component
@Slf4j
public class QuestionUsedCacheJob {

    @Resource
    private QuestionUsedCache questionUsedCache;

    @Resource
    private RedissonClient redissonClient;

    @PostConstruct
    public void job() {
        //0 0/5 * * * ?
        CronUtil.schedule("0/5 * * * * ?", (Task) () -> {
            log.info("执行已使用题目缓存更新");
            Set<Long> keySet = questionUsedCache.keySet();
            if (keySet.isEmpty()) {
                return;
            }
            RQueue<Long> queue = redissonClient.getQueue(RedisConstants.Question.RANDOM_QUESTION_USED_COLLECTION);
            queue.clear();
            for (Long key : keySet) {
                queue.offer(key);
            }
        });
    }
}
