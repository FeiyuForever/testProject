package com.feiyu.data.excel.easyexcel.controller;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.feiyu.data.excel.easyexcel.lister.ExcelLister;
import com.feiyu.data.excel.easyexcel.model.Car;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author xzhou.James
 * @Date 2020/2/16  19:27
 */
@RestController
@RequestMapping("/excel")
public class ExcelController extends BaseRowModel{

    /*@RequestMapping("/expor")
    public String exporExcel(HttpServletResponse response) throws IOException {
        ExcelWriter writer = null;
        OutputStream outputStream = response.getOutputStream();
        try {
            //添加响应头信息
            response.setHeader("Content-disposition", "attachment; filename=" + "car.xls");
            response.setContentType("application/msexcel;charset=UTF-8");//设置类型
            response.setHeader("Pragma", "No-cache");//设置头
            response.setHeader("Cache-Control", "no-cache");//设置头
            response.setDateHeader("Expires", 0);//设置日期头
            //实例化 ExcelWriter
            writer = new ExcelWriter(outputStream, ExcelTypeEnum.XLS, true);
            //实例化表单
            Sheet sheet = new Sheet(1, 0, Car.class);
            sheet.setSheetName("目录");
            //获取数据
            List<Car> catagoryList = excleService.findAll();
            //输出
            writer.write(catagoryList, sheet);
            writer.finish();
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.getOutputStream().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "index";
    }

    @RequestMapping("/import")
    public String importExcel(@RequestParam("file") MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        //实例化实现了AnalysisEventListener接口的类
        ExcelLister listener = new ExcelLister();
        //传入参数
        ExcelReader excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLS, null, listener);
        //读取信息
        excelReader.read(new Sheet(1, 1, Car.class));
        //获取数据
        List<Object> list = listener.getDatas();
        List<Car> catagoryList = new ArrayList<Car>();
        Car catagory = new Car();
        //转换数据类型,并插入到数据库
        for (int i = 0; i < list.size(); i++) {
            catagory = (Car) list.get(i);
            catagoryMapper.insertCategory(catagory);
        }
        return "index";
    }*/

}
