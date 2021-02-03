package com.feiyu.data.practise.base.DuoTai;

/**
 * @Author xzhou.James
 * @Date 2020/5/20  11:06
 */
public class Son extends Person {

    @Override
    public void TestEat() {
        super.TestEat();
        long time = System.currentTimeMillis();
        System.out.println(time+":我是子吃方法");
    }

    public void TestRun(){
        long time = System.currentTimeMillis();
        System.out.println(time+":我是子类跑步的方法");
    }

    public static void main(String[] args) {
        /*Person person = new Son();
        person.TestEat();*/

        Son son = new Son();
        son.TestEat();
        son.TestRun();
    }
}
