//Exercise 4
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class Crash3 {
    public static void main(String[] args) throws FileNotFoundException {
        String inFileName = "LiamNeeson.txt";
        Scanner input;
        String line;
        input = new Scanner (new File(inFileName));

        while(input.hasNextLine()) {
            line = input.nextLine();
            System.out.println(line);
        }
        input.close();
    }
}
