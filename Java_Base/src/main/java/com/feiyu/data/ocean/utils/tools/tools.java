package com.feiyu.data.ocean.utils.tools;

import com.feiyu.data.ocean.model.Person;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @Author xzhou.James
 * @Date 2019/12/15  15:33
 */
public class tools {

    private static final String code = "1002502502";

    public static void main(String[] args) {
        boolean first = true;
        boolean second = true;
        List<String> list = new ArrayList<String>();
        Collections.addAll(list,"Java","C++","Python","Goto");
        List<Person> personList = new ArrayList<Person>();
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        while(first){
            if(personList.size() <= 0 || list.size() <= 0 ){
                first = false;
                break;
            }else{
                List<String> stringList = keyReflict(map,list);
                printList(stringList);
            }
        }

        while(second){
            //填装数据
            personList = createPersonData();
            if(CollectionUtils.isEmpty(personList)){
                second = false;
                break;
            }
            //划分时间
            byDateGroupData(personList);
        }
    }

    private static void byDateGroupData(List<Person> personList) {
        Map<String,List<Person>> map = new HashMap<String,List<Person>>();
        List<String> stringList = new ArrayList<String>();
        List<Person> personList1;
        Iterator<Person> iterator = personList.iterator();
        while(iterator.hasNext()){
            Person person = iterator.next();
            if(map.get(person.getBirthday())==null){
                personList1   = new ArrayList<Person>();
            }else{
                personList1 = map.get(person.getBirthday());
            }
            personList1.add(person);
            map.put(person.getBirthday(),personList1);
            if(!stringList.contains(person.getBirthday())){
                stringList.add(person.getBirthday());
            }
        }
        printPersonList(map,stringList);
    }

    private static void printPersonList(Map<String, List<Person>> map, List<String> stringList) {
        List<Person> beforePerson = new ArrayList<Person>();
        List<Person> afterPerson  = new ArrayList<Person>();
        if(stringList.size() > 1){
            for(int i = 0; i < stringList.size()-1;i++){
                List<Person> a = map.get(stringList.get(i));
                List<Person> b = map.get(stringList.get(i+1));
                beforePerson.addAll(a);
                afterPerson.addAll(b);
            }
        }
        for(Iterator<Person> iterator1 = beforePerson.iterator();iterator1.hasNext();){
            Person person1 = iterator1.next();
            System.out.println(person1);
        }
        for(Iterator<Person> iterator2 = afterPerson.iterator();iterator2.hasNext();){
            Person person2 = iterator2.next();
            System.out.println(person2);
        }
    }

    private static List<Person> createPersonData() {
        List<Person> personList = new ArrayList<Person>();
        Person person1 = new Person("张飞","男","19801205","上海");
        Person person2 = new Person("关羽","男","19801205","上海");
        Person person3 = new Person("刘备","男","19801206","上海");
        Person person4 = new Person("赵云","男","19801208","上海");
        Person person5 = new Person("马超","男","19801208","上海");
        Collections.addAll(personList,person1,person2,person3,person4,person5);
        return personList;

    }

    private static void printList(List<String> stringList) {
        for(Iterator<String> iterator = stringList.iterator();iterator.hasNext();){
            String string = iterator.next();
            if(StringUtils.isNotEmpty(string)){
                switch (string){
                    case "Java":
                        System.out.println("编程语言Java");
                        break;
                    case "C++":
                        System.out.println("编程语言C++");
                        break;
                    case "Python":
                        System.out.println("编程语言Python");
                        break;
                    case "Goto":
                        System.out.println("编程语言Goto");
                        break;
                    default:
                        System.out.println("Flight");
                        break;
                }
            }
        }
    }

    private static List<String> keyReflict(Map<String, List<String>> map,List<String> list ) {
        List<String> stringList = new ArrayList<String>();
        map.put("programmingLanguage",list);
        //第 =  = 一种
        Set<String> set = map.keySet();
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            stringList = map.get(key);
        }
        return stringList;
    }

    @Test
    public void TestUserInfo(){
        List<String> stringList = new ArrayList<String>();
        Collections.addAll(stringList,"ASD");
        for(Iterator its = stringList.iterator();its.hasNext();){
            String a = its.next().toString();
            if(a.equalsIgnoreCase("ASD")){
                its.remove();
                continue;
            }else {
                System.out.println("<><><>");
            }
        }
        System.out.println();
    }
}
