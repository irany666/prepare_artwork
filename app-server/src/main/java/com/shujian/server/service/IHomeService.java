package com.shujian.server.service;

import com.shujian.server.model.req.ReqAddQuestion;
import com.shujian.server.model.res.ResQuestion;

/**
 * Created by shujian.ou 2022/6/6 16:17
 */
public interface IHomeService {

    ResQuestion randomQuestion();

    Boolean addQuestion(ReqAddQuestion req);
}
