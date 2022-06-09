package com.shujian.server.model.req;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shujian.server.model.res.ResQuestion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;

/**
 * Created by shujian.ou 2022/6/6 16:13
 */
@ApiModel("问题列表请求")
public class ReqQuestionList extends Page<ResQuestion> {


}
