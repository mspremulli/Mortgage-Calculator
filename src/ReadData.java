import java.util.Scanner;

public class ReadData {
    public static float readData(String prompt){
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextFloat();
    }
}
