package com.shujian.common.enums;

/**
 * 业务异常信息
 *
 * @author Charlie
 * @version V1.0
 * @date 2019/2/15 14:51
 */
public enum ErrorEnum {

    /**
     * 无权限
     */
    NO_PERMISSION(403, "无权限"),
    REQUEST_PARAM_IS_EMPTY(1001, "请求参数不能为空"),

    TOKEN_INVALID(203, "token无效"),

    ACCOUNT_SQUEEZE_UP(204, "账号被挤下线"),

    ACCOUNT_KICK_DOWN(205, "账号被踢下线"),

    /**
     * 系统繁忙
     */
    SYSTEM_ERROR(ErrorEnum.DEFAULT_ERROR_CODE, "网络开小差啦~~请稍后再试"),
    ;

    private final int code;
    private final String description;

    public static final int DEFAULT_ERROR_CODE = 201;

    ErrorEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    ErrorEnum(String description) {
        this.code = ErrorEnum.DEFAULT_ERROR_CODE;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

}
