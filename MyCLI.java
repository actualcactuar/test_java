import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MyCLI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Who are you?\n");
        String name = scanner.next();
        scanner.close();
        System.out.print("Received name: " + name + "\n");
        String existingText = "";

        try {
            File userLog = new File("log.txt");
            Scanner logReader = new Scanner(userLog);
            while (logReader.hasNextLine()) {
                String line = logReader.nextLine() + "\n";
                existingText = existingText.concat(line);
            }
            logReader.close();
            if (userLog.createNewFile()) {
                System.out.println("File created: " + userLog.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("log.txt");
            String allText = existingText + name + " ran this java code";
            myWriter.write(allText);
            myWriter.close();
            System.out.println(name + " added to user log");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}