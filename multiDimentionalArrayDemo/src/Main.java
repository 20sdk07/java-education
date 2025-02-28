//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        char word ='u';
        char[] kalinSesli = {'a','o','u','ı'};
        char[] inceSesli = {'e','ö','ü','i'};
        
        boolean sesliMi = false;
        
        // Önce harfin sesli olup olmadığını kontrol edelim
        for (char harf : kalinSesli) {
            if (word == harf) {
                sesliMi = true;
                System.out.println(word + " kalın sesli harftir");
                break;
            }
        }
        
        for (char harf : inceSesli) {
            if (word == harf) {
                sesliMi = true;
                System.out.println(word + " ince sesli harftir");
                break;
            }
        }
        
        // Eğer sesli değilse, sessiz harftir
        if (!sesliMi) {
            System.out.println(word + " sessiz harftir");
        }
    }
}