import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        ArrayList sayilar = new ArrayList();
        sayilar.add("A");
        sayilar.add("B");
        sayilar.add("C");
        sayilar.add("Ankara");
        //System.out.println(sayilar.size());
        //sayilar.set(2,100);
        //sayilar.remove(1);
        //sayilar.clear();
        //System.out.println(sayilar.get(0));

        for (Object i: sayilar ){
            System.out.println(i);
        }




    }
}