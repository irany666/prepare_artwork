package com.shujian.server.service.impl;

import cn.hutool.cache.impl.TimedCache;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.RandomUtil;
import com.shujian.common.bean.R;
import com.shujian.server.kits.QuestionUsedCache;
import com.shujian.server.manager.entity.Question;
import com.shujian.server.manager.entity.QuestionCategoryUnion;
import com.shujian.server.manager.service.IQuestionCategoryUnionService;
import com.shujian.server.manager.service.IQuestionService;
import com.shujian.server.model.req.ReqAddQuestion;
import com.shujian.server.model.res.ResQuestion;
import com.shujian.server.service.IHomeService;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Created by shujian.ou 2022/6/6 16:17
 */
@Service
public class HomeServiceImpl implements IHomeService {

    @Resource
    private IQuestionService questionService;

    @Resource
    private IQuestionCategoryUnionService questionCategoryUnionService;

    @Resource
    private RedissonClient redissonClient;

    @Resource
    private QuestionUsedCache questionUsedCache;


    @Override
    public ResQuestion randomQuestion() {
        List<Long> idList = questionService.lambdaQuery().eq(Question::getUserId, 1).select(Question::getId).list()
                .stream().map(Question::getId).collect(Collectors.toList());
        if (CollectionUtil.isEmpty(idList)) {
            return new ResQuestion();
        }
        long index = RandomUtil.randomLong(idList.size());
        Question question = null;

        int questionRandomMaxCount = 0;

        while (questionRandomMaxCount < 6) {
            question = questionService.getById(idList.get((int) index));
            if (question == null || !questionUsedCache.exist(question.getId())) {
                break;
            }
            index = RandomUtil.randomLong(idList.size());
            questionRandomMaxCount++;
        }

        if (question == null) {
            return null;
        }
        ResQuestion res = ResQuestion.builder().question(question.getQuestion()).answer(question.getAnswer()).build();
        questionUsedCache.put(question.getId());
        return res;
    }

    @Override
    public Boolean addQuestion(ReqAddQuestion req) {
        Question question = Question.builder().question(req.getQuestion()).answer(req.getAnswer())
                .userId(1L).createTime(LocalDateTime.now()).build();

        if (!questionService.save(question)) {
            return false;
        }

        return questionCategoryUnionService.save(QuestionCategoryUnion.builder().questionId(question.getId())
                .categoryId(req.getCategoryId()).build());
    }
}
