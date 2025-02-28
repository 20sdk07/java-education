public class DortIslem {

    public double topla(double a,double b){
        return a+b;
    }

    public double cikar (double a,double b){
        return a-b;
    }

    public double carp(double a, double b){
        return a*b;
    }

    public double bolme (double a, double b){
        if (b==0){
            System.out.println("sayı sdıra eşit olamaz tanımsızdır ");
        }
        return a/b;
    }
}
