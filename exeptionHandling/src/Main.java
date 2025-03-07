 public class Main {
    public static void main(String[] args) {
        
        try {
            int[] sayilar = new int[]{1, 2, 3};
            System.out.println(sayilar[3]);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }finally {
            System.out.println("Her durumda çalışırım.");
        }
    }
}