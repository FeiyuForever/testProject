package com.feiyu.data.ocean.utils;

/*
import com.wind.eagle.log4w.declare.ProcessInfo;
import com.wind.eagle.log4w.impl.AbstractPerfDataListener;
*/

/*public class CustomPerfDataListener extends AbstractPerfDataListener {

    public CustomPerfDataListener() {
        super();

        this.perfNameTable.put("VM memory used", "虚拟机内部内存使用");
        this.perfNameTable.put("request total", "当日累计请求");
        this.perfNameTable.put("request avg", "分钟平均请求");
        this.perfNameTable.put("net traffic", "当日累计流量");
        this.perfNameTable.put("traffic", "分钟平均流量");
        this.perfNameTable.put("Reserve01", "小强测试");
        this.perfNameTable.put("Reserve02", "内部保留");
        this.perfNameTable.put("Reserve03", "内部保留");
        this.perfNameTable.put("Reserve04", "内部保留");
        this.perfNameTable.put("Reserve05", "内部保留");
        this.perfNameTable.put("Reserve06", "内部保留");
        this.perfNameTable.put("Reserve07", "内部保留");
        this.perfNameTable.put("Reserve08", "内部保留");
        this.perfNameTable.put("Reserve09", "内部保留");
        this.perfNameTable.put("Reserve10", "内部保留");
    }

    @Override
    public String convertPerfName(String innerName) {
        String showName = (String) this.perfNameTable.get(innerName);
        if (showName == null) {
            return innerName;
        }
        return showName;
    }

    @Override
    public void fillAppPerfData(ProcessInfo perfData) {
        int usedMem = (int) ((Runtime.getRuntime().totalMemory() - Runtime
                .getRuntime().freeMemory()) / 1024L / 1024L);
        perfData.setUsedVMMemory(usedMem);

        // 对应小强测试
        perfData.setReserve01(1234);
    }
}*/

