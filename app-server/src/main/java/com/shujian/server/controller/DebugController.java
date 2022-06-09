package com.shujian.server.controller;

import com.shujian.common.bean.R;
import com.shujian.server.manager.entity.Question;
import com.shujian.server.manager.entity.QuestionCategoryUnion;
import com.shujian.server.manager.service.IQuestionCategoryService;
import com.shujian.server.manager.service.IQuestionCategoryUnionService;
import com.shujian.server.manager.service.IQuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by shujian.ou 2022/6/6 18:43
 */
@RestController
@RequestMapping("debug")
public class DebugController {

    @Resource
    private IQuestionService questionService;

    @Resource
    private IQuestionCategoryService questionCategoryService;

    @Resource
    private IQuestionCategoryUnionService questionCategoryUnionService;

    @GetMapping("test")
    public R<Boolean> test() {
        List<Question> questionList = questionService.lambdaQuery().select(Question::getId,Question::getQuestion,Question::getAnswer).list();

        for (Question question : questionList) {
            String tmpQuestion = question.getQuestion();
            question.setQuestion(question.getAnswer());
            question.setAnswer(tmpQuestion);
        }
        questionService.updateBatchById(questionList);
        return R.ok();
    }
}
