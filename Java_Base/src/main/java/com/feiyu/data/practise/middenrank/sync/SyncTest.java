package com.feiyu.data.practise.middenrank.sync;

import java.util.Arrays;

/**
 * Created by xzhou.James on 2020/10/1
 */
public class SyncTest {

   static class Name implements Runnable{

        private String type;

        public Name(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public void run() {
            System.out.println("线程名称："+Thread.currentThread().getName()+" :: "+
                    Thread.currentThread().getId()+" :: => "+type);
        }
    }
    /**
     * 主方法测试
     *
     * @param args
     */
    public static void main(String[] args) {
        Name name1 = new Name("中文");
        Name name2 = new Name("英文");
        Name name3 = new Name("德文");
        Name name4 = new Name("法文");

        name1.run();
        name2.run();
        name3.run();
        name4.run();
    }
}
