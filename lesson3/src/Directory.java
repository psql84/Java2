import java.util.ArrayList;

public class Directory {

    private ArrayList<People> list ;

    public Directory() {
        list = new ArrayList<>();
    }

    public void add(People people)
   {

       list.add(people);
   }

   public  void print(){
       System.out.println(list);

   }
   public void get(String name){
       for (People s: list
            ) { if (s.getFio().equals(name))
           System.out.println(s);

       }

   }
}
