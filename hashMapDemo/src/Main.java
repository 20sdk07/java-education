import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        
        HashMap<String, String> sozluk = new HashMap<String, String>();
        sozluk.put("book", "kitap");
        sozluk.put("pencil", "kalem");
        sozluk.put("computer", "bilgisayar");
        sozluk.put("mouse", "fare");
        
        System.out.println(sozluk.get("book"));
        sozluk.remove("book");
        System.out.println(sozluk);
    }
}