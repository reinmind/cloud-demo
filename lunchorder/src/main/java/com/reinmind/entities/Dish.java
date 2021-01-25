package com.reinmind.entities;

import lombok.Data;
import lombok.Generated;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author xiang.zhang
 */
@Data
public class Dish {
    @Id
    @Generated
    private String id;

    @Length(min = 3,max = 10,message = "名称长度在3-10之间")
    @NotNull(message = "名称不能为空")
    private String name;
    @Digits(integer = 10, fraction = 6,message = "数字不符合格式要求")
    @NotNull(message = "价格不能为空")
    private BigDecimal price;
}
