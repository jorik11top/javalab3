import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {


        File file = new File("src\\test.txt");

        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8))
        {
            while (sc.hasNextLine()) {
                String name = sc.nextLine();
                People user1 = new People(name);
                System.out.println(user1.getUserInfoFormat());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите ФИО и дату рождения(дд.мм.гггг)");
//        String name = scanner.nextLine();
//        People user1 = new People(name);
//        System.out.println(user1.getUserInfoFormat());
    }
}
