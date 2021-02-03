package com.feiyu.data.test.thread;

/**
 * Created by xzhou.James on 2020/11/29
 */
public class TaskJob implements Runnable{

    private String a = "";

    private static Integer count = 1;

    private Object ele1 = new Object();

    private Object ele2 = new Object();

    private Object ele3 = new Object();

    public TaskJob(String a) {
        this.a = a;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    @Override
    public void run() {
        while (true){
            synchronized (this){
                if(count > 10){
                    break;
                }
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                printInfo(Thread.currentThread().getName(),this.getA());
                count++;
                this.notifyAll();
            }
        }
        //System.exit(0);
    }

    private void printInfo(String name, String a) {
        System.out.println(name + ":" +a);
    }
}
