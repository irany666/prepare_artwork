package com.shujian.server.manager.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * <p>
 * 问题类别关联表
 * </p>
 *
 * @author shujian.ou
 * @since 2022-06-06
 */
@TableName("qb_question_category_union")
@ApiModel(value = "QuestionCategoryUnion对象", description = "问题类别关联表")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionCategoryUnion implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("类别ID")
    private Long categoryId;

    @ApiModelProperty("问题ID")
    private Long questionId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return "QuestionCategoryUnion{" +
            "id=" + id +
            ", categoryId=" + categoryId +
            ", questionId=" + questionId +
        "}";
    }
}
