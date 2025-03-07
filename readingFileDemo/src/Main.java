
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader =null;
        try {
        reader = new BufferedReader(new FileReader("C:\\javademos\\readingFileDemo\\src\\test.txt."));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("File not found");
            }
        }
        
    }
}