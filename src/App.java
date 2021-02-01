//import java.io.Console;
import java.io.File;
import java.util.Scanner;

public class App {

    public static String fileName = "";
    public static void main(String[] args) throws Exception {
        String text = "";
        System.out.println(new File(".").getAbsoluteFile());
        System.out.println("Please enter the name of the file to scan");
        fileName = System.console().readLine();

        File file = new File(fileName);

        if (file.exists()){
            System.out.println("this file exists");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                text = text + " " + scanner.nextLine();
            }
            scanner.close();
            //System.out.println(text);
            String[] wordArr = text.split("\\s+|-|—|\\.|\"|\\?|!|;|,|'s|\\r?\\n|:|\\s");
            for (String string : wordArr) {
                
                System.out.println(string );
            }
        }
        else{
            System.out.println("this file not found");
        }
    }
}
