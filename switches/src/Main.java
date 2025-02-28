public class Main {
    public static void main(String[] args) {

        char grade = 'C';

        switch (grade) {
            case 'A':
                System.out.println("mük");
                break;
            case 'B':
                System.out.println("iyi");
                break;
            case 'C':
                System.out.println("hoj");
                break;
            default:
                System.out.println("geçersiz harf");
                break;
        }

    }
}