import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите Фамилию Имя Отчество, \n" +
                "дату рождения в формате dd.mm.yyyy\n" +
                "номер телефона \n" +
                "и пол в формате буквы 'm' или 'f'");
        String input = scanner.nextLine();

        String [] inputData = input.split(" ");
        if(inputData.length != 6){
            System.err.println("Неверное количество данных. Попробуйте снова...");
            return;
        }

        String surname = inputData[0];
        String name = inputData[1];
        String middleName = inputData[2];
        String dateOfBirth = inputData[3];
        long phoneNumber = 0;
        try{
            phoneNumber = Long.parseLong(inputData[4]);
        }catch (NumberFormatException e){
            System.err.println("Ошибка. Неверно введен номер. Порпобуйте снова...");
        }
        char gender = inputData[5].charAt(0);

        try{
            String fileName = surname + ".txt";
            BufferedWriter write = new BufferedWriter(new FileWriter(fileName, true));
            write.write(surname + " " + name + " " + middleName + " " + dateOfBirth + " " + phoneNumber + " " + gender);
            write.newLine();

            write.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}