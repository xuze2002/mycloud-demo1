package com.yiven.model.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.models.auth.In;
import lombok.Data;

@Data
@TableName("rs")
public class Rs {

    @TableField("uid")
    private Integer uid;

    @TableField("rid")
    private Integer rid;
}
