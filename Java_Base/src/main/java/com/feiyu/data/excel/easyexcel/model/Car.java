package com.feiyu.data.excel.easyexcel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @Author xzhou.James
 * @Date 2020/2/16  19:27
 */
public class Car extends BaseRowModel{

    @ExcelProperty(value = "name",index = 0)
    private String name;
    @ExcelProperty(value = "color",index = 1)
    private String color;
    @ExcelProperty(value = "product",index = 2)
    private String product;

    public Car() {
    }

    public Car(String name, String color, String product) {
        this.name = name;
        this.color = color;
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
