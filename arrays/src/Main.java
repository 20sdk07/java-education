public class Main {
    public static void main(String[] args) {

        double[] myList = {1.2, 1.4, 2.2, 5.6};
        double total = 0;
        double max = myList[0];
        for (double number : myList) {
            if (max < number) {
                max = number;

            }
            total += number;
            System.out.println(number);
        }

        System.out.println("TOPLAM = " + total);
        System.out.println("MAX = " + max);

    }
}