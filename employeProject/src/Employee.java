public class Employee {
    private String name;
    public double salary;
    private int workHours, hireYear;

    Employee(int hireYear, int workHours, double salary, String name) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;

    }

    public double tax() {
        if (this.salary >= 1000) {
            return salary * 0.03;

        } else return 0.0;
    }

    public double bonus() {
        int extraHours = this.workHours - 40;
        if (this.workHours > extraHours) {
            return extraHours * 30;
        } else {
            return 0.0;
        }
    }

    public double increase() {
        int year = 2025 - this.hireYear;
        if(year <= 10 ){
            return this.salary * 0.05;
    }else if(year > 10 && year <= 20){
            return this.salary * 0.10;
        }else{
            return this.salary * 0.15;
        }
}
}
