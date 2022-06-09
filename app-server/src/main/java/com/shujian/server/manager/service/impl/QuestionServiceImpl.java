package com.shujian.server.manager.service.impl;

import com.shujian.server.manager.entity.Question;
import com.shujian.server.manager.mapper.QuestionMapper;
import com.shujian.server.manager.service.IQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 题库问题 服务实现类
 * </p>
 *
 * @author shujian.ou
 * @since 2022-06-06
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements IQuestionService {

}
