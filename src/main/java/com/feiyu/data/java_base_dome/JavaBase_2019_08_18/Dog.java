package com.feiyu.data.java_base_dome.JavaBase_2019_08_18;

/**
 * @Author xzhou.James
 * @Date 2019/8/18  21:18
 */
public class Dog {

    private String name;
    private String says;

    public Dog() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSays() {
        return says;
    }

    public void setSays(String says) {
        this.says = says;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", says='" + says + '\'' +
                '}';
    }

    public static void main(String[] args) {

        Dog spot = new Dog();

        Dog scruffy = new Dog();

        spot.setName("daxiong");
        scruffy.setName("daxiong");

        spot.setSays("Ruff");
        scruffy.setSays("Wurf");

        System.out.println(spot);
        System.out.println(scruffy);
        System.out.println(spot.name == scruffy.name);
        System.out.println(spot.name.equals(scruffy.name));

        System.out.println(spot.says == scruffy.says);
        System.out.println(spot.says.equals(scruffy.says));
    }
}
