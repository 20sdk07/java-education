//public class Main {
//    public static void main(String[] args) {
//
//        int number = 17;
//        boolean isPrime = true;
//        for (int i = 2; i < number; i++) {
//            if(number % i ==0){
//                isPrime = false;
//            }
//        }
//        if (isPrime){
//            System.out.println("sayı asaldır ");
//        }else{
//            System.out.println("Sayı asal değildir ");
//        }
//
//    }
//}
public class Main {
    public static void main(String[] args) {

        boolean isPrime = false;
        int number = 70;
        for (int i = 1; i < number; i++) {

            if (number % 1 == 0 && number % number == 0) {
                isPrime = true;
                break;
            }
        }
        if (isPrime) {
            System.out.println("sayı asaldır ");
        } else {
            System.out.println("sayı asal değildir");
        }

    }
}