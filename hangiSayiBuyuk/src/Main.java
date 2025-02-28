public class Main {
    public static void main(String[]args){
        int sayi1 = 300;
        int sayi2 = 26;
        int sayi3 = 24;
        int enBuyuk = sayi1;
        if (enBuyuk < sayi2) {
            enBuyuk = sayi2;
        }

        if (enBuyuk < sayi3) {
            enBuyuk = sayi3;
        }
        System.out.println("en büyük sayi = "+enBuyuk);
    }
}