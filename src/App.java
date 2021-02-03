
//import java.io.Console;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class App {

    public static String fileName = "";
    public static ArrayList<Word> wordList = new ArrayList<Word>();
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
            String[] wordArr = text.split("\\s+|-|—|\\.|\"|\\?|!|;|,|'s|\\r?\\n|:|\\s|'");
            for (String string : wordArr) {
                
                //System.out.println(string);

                if(string == ""|| string == " "){

                }
                else{
                    if(inWordList(string,wordList)){
                        increaseWordFreq(string, wordList);
                    }
                    else{
                        wordList.add(new Word(string));
                    }
                }

            }
        }
        else{
            System.out.println("this file not found");
        }

        Collections.sort(wordList);

        for (int i = 0; i < 20; i++) {
            String string = wordList.get(i).getWord();
            int frequency = wordList.get(i).getFrequency();
            System.out.println(string + " : " + frequency);
        }
    }

    public static boolean inWordList(String string, ArrayList<Word> wordList){

        for (Word word : wordList) {
            if(string.toLowerCase().equalsIgnoreCase(word.getWord())){
                return true;
            }
        }

        return false;
    }

    public static void increaseWordFreq(String string, ArrayList<Word> wordList){
        for (Word word : wordList) {
            if(string.toLowerCase().equalsIgnoreCase(word.getWord())){
                word.increase();
            }
        }
    }
}
