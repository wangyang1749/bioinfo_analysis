package com.wangyang.bioinfo.pojo.param;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

/**
 * @author wangyang
 * @date 2021/6/13
 */
@Data
public class CommentParam {
//    private int userId;
    private int projectId;
    @NotBlank(message = "评论内容不能为空!")
    private String content;
}
