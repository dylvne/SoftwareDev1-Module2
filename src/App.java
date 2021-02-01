import java.io.File;

public class App {

    public static String fileName = "";
    public static void main(String[] args) throws Exception {
        System.out.println("Please enter the name of the file to scan");
        fileName = System.console().readLine();

        File file = new File(fileName);

        if (file.exists()){
            System.out.println("this file exists");
        }
        else{
            System.out.println("this file not found");
        }
    }
}
