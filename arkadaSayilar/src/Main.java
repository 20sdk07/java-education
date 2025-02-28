//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        arkadaş sayılar kendi pzitif bölenlerinin toplamı arkadışı yapmasıdır[220-284  1184 ve 1210, 2620 ve 2924, 5020 ve 5564 ]
        int number1 = 1184;
        int number2 = 1210;
        int total1 = 0;
        int total2 = 0;

        for(int i = 1; i < number1;i++)
            if(number1 % i == 0){
                total1 += i;
            }
        for(int j = 1; j < number2;j++){
            if(number2 % j == 0){
                total2 += j;
            }
        }
        if(total1 == number2 && total2 == number1){
            System.out.println("sayılar arkadaş sayıdır ");
        }else{
            System.out.println("sayılar arkdaş sayı değildir");
        }

    }
}