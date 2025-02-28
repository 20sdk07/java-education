
public class Main {
    public static void main(String[] args) {

        int number =-2 ;
        int toplam = 0;

        if (number <= 0) {
            System.out.println("lütfen pozitif bir sayı giriniz");
            return;
        }
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                toplam = toplam + i;
                System.out.println(toplam);
            }
        }
        if (toplam == number) {
            System.out.println("sayı mükemmel sayıdır ");
        } else {
            System.out.println("sayı mükemmel sayı değildir ");
        }


    }
}