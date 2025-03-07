
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader =null;
        int total = 0;
        try {
            reader = new BufferedReader(new FileReader("C:\\javademos\\readingFileDemo\\src\\test.txt."));
            String line = null;
            while((line = reader.readLine()) != null){
                total += Integer.valueOf(line);
        }    
        System.out.println("Total: " + total);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }catch (IOException e) {
            System.out.println("File not found");
        }
        finally {
            try {
                reader.close();
            } catch ( IOException e) {
                System.out.println("File not found");
            }
        }
        
    }
}