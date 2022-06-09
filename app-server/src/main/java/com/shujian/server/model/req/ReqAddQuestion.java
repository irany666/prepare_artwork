package com.shujian.server.model.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by shujian.ou 2022/6/6 17:59
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("添加问题请求")
public class ReqAddQuestion implements Serializable {

    @ApiModelProperty(value = "类别ID", required = true, example = "1")
    private Long categoryId;

    @ApiModelProperty(value = "问题", required = true)
    private String question;

    @ApiModelProperty(value = "答案", required = true)
    private String answer;
}
