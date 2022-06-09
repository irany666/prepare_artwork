package com.shujian.server.model.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * Created by shujian.ou 2022/6/6 16:11
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("问题实体")
public class ResQuestion implements Serializable {

    @ApiModelProperty("问题描述")
    private String question;

    @ApiModelProperty("问题答案")
    private String answer;

}
