package com.feiyu.data.excel.easyexcel.lister;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.feiyu.data.excel.easyexcel.model.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xzhou.James
 * @Date 2020/2/16  19:27
 */
public class ExcelLister extends AnalysisEventListener<Car> {

    //添加传入值的n对象
    private List<Car> datas = new ArrayList<Car>();

    public List<Car> getDatas() {
        return datas;
    }

    public void setDatas(List<Car> datas) {
        this.datas = datas;
    }
    /**
       其中， invoke() 和 doAfterAllAnalysed() 是必须实现的方法。
       在 invoke() 中，我们将数据封装到 list 中，再在控制器中，通过 getter()
       方法获取数据，这样我们就可以获取到 easyexcel 帮我们解析好的数据，
       再将数据进行类型转化，这样，我们就可以对数据进行写入操作。
       链接：https://www.jianshu.com/p/78cc1729fbd1
     */
    @Override
    public void invoke(Car car, AnalysisContext analysisContext) {
        datas.add(car);
        System.out.println("解析到一条数据:{}"+JSON.toJSONString(car));
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println(JSON.toJSONString(datas));
    }
}
