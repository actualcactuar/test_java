import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UselessCLI {

    private ArrayList<String> getLinesAsArray() {
        ArrayList<String> lines = new ArrayList<String>();
        try {
            File userLog = new File("log.txt");

            if (userLog.createNewFile()) {
                System.out.println("File created: " + userLog.getName());
            } else {
                System.out.println("Reading from file log.txt");
            }

            Scanner logReader = new Scanner(userLog);
            while (logReader.hasNextLine()) {
                String line = logReader.nextLine() + "\n";
                lines.add(line);
            }
            logReader.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return lines;
    }

    private String joinArrayList(ArrayList<String> list) {
        String text = "";
        for (int i = 0; i < list.size(); i++) {
            text = text.concat(list.get(i));
        }
        return text;
    }

    private void writeLogFile(String existingText, String name) {
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

    public static void main(String[] args) {
        UselessCLI cli = new UselessCLI();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Who are you?\n");
        String name = scanner.next();
        System.out.print("Received name: " + name + "\n");
        ArrayList<String> list = cli.getLinesAsArray();
        String existingLog = cli.joinArrayList(list);
        cli.writeLogFile(existingLog, name);

        System.out.print("Who do you want to find?\n");
        String search = scanner.next();
        scanner.close();

        ArrayList<String> searchList = cli.getLinesAsArray();
        searchList.removeIf(line -> !line.contains(search));
        System.out.print(search + " has ran this java code " + searchList.size() + " times\n");

    }
}