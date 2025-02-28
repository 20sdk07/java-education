public class Main {
    public static void main(String[] args) {

        int [] sayilar = {1,2,3,4,5};
        boolean varMi = false;
        int tuttum  = 1;
        for (int sayi : sayilar) {
            if(sayi == tuttum){
                varMi = true;
                break;
            }
        }
        if(varMi){
            System.out.println("Bulundu");
        }else{
            System.out.println("bulunamadı");
        }



    }
}