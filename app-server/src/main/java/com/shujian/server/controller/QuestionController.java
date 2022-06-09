package com.shujian.server.controller;

import com.shujian.common.bean.R;
import com.shujian.server.manager.service.IQuestionService;
import com.shujian.server.model.req.ReqAddQuestion;
import com.shujian.server.model.res.ResQuestion;
import com.shujian.server.service.IHomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by shujian.ou 2022/6/6 15:58
 */
@RequestMapping("question")
@RestController
@Api(tags = "问题相关")
public class QuestionController {

    @Resource
    private IHomeService homeService;

    @PostMapping("list")
    public R<List<ResQuestion>> list() {
        return R.ok();
    }


    @GetMapping("randomQuestion")
    @ApiOperation("随机一个问题")
    public R<ResQuestion> randomQuestion() {
        ResQuestion resQuestion = homeService.randomQuestion();
        if (resQuestion == null) {
            return R.fail("暂时没有题目，请稍后再试。", null);
        }
        return R.ok(resQuestion);
    }

    @PostMapping("addQuestion")
    @ApiOperation("添加问题")
    public R<Boolean> addQuestion(@RequestBody ReqAddQuestion req) {
        return R.ok(homeService.addQuestion(req));
    }
}
