import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        
Scanner scanner = new Scanner(System.in); 
scanner.useDelimiter("\\Z");
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello " + name); // prints "Hello <name>"

    }
}
