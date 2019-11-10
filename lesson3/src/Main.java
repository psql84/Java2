
import java.util.*;

public class Main {


    public static void main(String[] args) {
        task1();
        task2();
    }

    private static void task2() {
        Directory tel =new Directory();
        tel.add(new People("Вася","98765433","we@hjhf.ru"));
        tel.add(new People("Вася","26221211","ауав@hjhf.ru"));
        tel.add(new People("Петя","25252525","сммим@hjhf.ru"));
        tel.add(new People("Вова","25242425","иепа@hjhf.ru"));
        tel.add(new People("Саша","87257255","паиапи@hjhf.ru"));
        tel.add(new People("Коля","52575252","dsfsd@hjhf.ru"));
        tel.add(new People("Петя","52552755","sdfsdsd@hjhf.ru"));
        tel.add(new People("Вова","52275252","dsfsdf@hjhf.ru"));
        tel.get("Вася");
        tel.get("Петя");
    }

    private static void task1() {
        String [] strings ={"a","s","d","f","g","h","j","k","l","f","z","d","f","e","a","d","e","w","r","s"};
        List<String> list= Arrays.asList(strings);
        HashMap<String,Integer> hashMap  =new HashMap<String,Integer>();

        HashSet<String> stringSet = new HashSet<>(list);
        System.out.println(stringSet);

        for (String u: list){
            hashMap.put(u, Collections.frequency(list,u));
        }
        System.out.println(hashMap);
    }


}
