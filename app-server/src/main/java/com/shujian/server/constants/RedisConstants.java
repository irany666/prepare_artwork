package com.shujian.server.constants;

/**
 * Created by shujian.ou 2022/6/6 23:28
 */
public interface RedisConstants {

    String PREFIX = "PA:";

    interface Question {
        String PREFIX = RedisConstants.PREFIX + "question:";
        String RANDOM_QUESTION_USED_COLLECTION = PREFIX + "randomQuestionUsedCollection";
    }
}
