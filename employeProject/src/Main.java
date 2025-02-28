
public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee(2000, 45, 2000, "Ali");
        System.out.println("Tax : "+ e1.tax());
        System.out.println("Bonus : "+ e1.bonus());
        System.out.println("Increase : "+ e1.increase());
        double totalSalary = e1.salary + e1.bonus() + e1.tax() + e1.increase();
        System.out.println("Total Salary with bonus and tax: "+ totalSalary);





    }
}