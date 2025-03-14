
public class Main {
    public static void main(String[] args) {
        KronometreThread thread1 = new KronometreThread("KM1");
        KronometreThread thread2 = new KronometreThread("KM2");
        KronometreThread thread3 = new KronometreThread("KM3");
        thread1.start();
        thread2.start();
        thread3.start();

    }
}