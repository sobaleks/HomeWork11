import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Data {
    String numberCard;
    int schet;
    String date;
    String IBAN;
    int telNumber;
    int sum;
    int balanse;
    String poluchatel;

    // try- catch
    String popolneniePhone(int telNumber) {
        this.telNumber = telNumber;
        try {
            Scanner scacner = new Scanner(System.in);
            System.out.println("Введите сумму которую хотите положить ");
            sum = scacner.nextInt();
            balanse += sum;
            System.out.println("Баланс успешно пополнен");
        } catch (Exception e) {
            System.out.println("Неправильный ввод данных, попробуйте ещё раз");
            return popolneniePhone(telNumber);
        }
        return "Операция завершена";

    }

    //try-catch, где catch будет несколько
    void popolneniePoIBAN() {
        try (FileReader reader = new FileReader("/home/aleksandr/Документы/IBAN")) {
            System.out.println("Счёт получателя :");
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
            Scanner scaner = new Scanner(System.in);
            System.out.println("Введите сумму которую желаете положить");
            sum = scaner.nextInt();
            balanse += sum;
            System.out.println("Счёт пополнен");
        } catch (NumberFormatException a) {
            System.out.println("Неверная сумма ");
        } catch (IOException e) {
            System.out.println("Не найден IBAN  ");
        }
        System.out.println("Операция завершена");
    }

    //try -catch, с использованием multi-catch
    void as() {
        try {
            int mounth[] = new int[13];
            int n = 0;
            for (int i = 0; i < mounth.length; i++) {
                mounth[i] = n;
                n++;
            }
            Scanner scaner = new Scanner(System.in);
            System.out.println("Введите номер карты ");
            numberCard = scaner.nextLine();
            System.out.println("Введите дату ");
            date = scaner.nextLine();
            System.out.println("Введите сумму которую желаете положить");
            schet = scaner.nextInt();
            String lines[] = date.split("/");
            int m = Integer.parseInt(lines[0]);
            int y = Integer.parseInt(lines[1]);
            int p = mounth[m];
            System.out.println("Операция выполнена ");
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Неправильно введены данные");
        }
    }

    //try-catch-finally
    void ad() {
        Scanner scaner = new Scanner(System.in);
        try (FileReader reader = new FileReader("/home/aleksandr/Документы/IBAN");
             FileReader reader_1 = new FileReader("/home/aleksandr/Документы/ФИО")) {
            System.out.println("Счёт получателя :");
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
            System.out.println("Данные получателя ");
            int f;
            while ((f = reader_1.read()) != -1) {
                System.out.print((char) f);
            }
        } catch (IOException e) {
            System.out.println("Неполучилось найти данных на компьютере, попробуйте ввести в ручную ");
            System.out.println("Введите IBAN ");
            IBAN = scaner.nextLine();
            System.out.println("Введите данные получателя ");
            poluchatel = scaner.nextLine();
        } finally {
            System.out.println("Какую сумму желаете положить на счёт ");
            balanse += scaner.nextInt();
            System.out.println("Операция завершена успешно ");
        }
    }

    //Написать try/catch/finally, в котором finally вызван не будет
    void calculator() {
        Scanner scaner = new Scanner(System.in);
        try {
            System.out.println("Введите первое число ");
            int number1 = scaner.nextInt();
            System.out.println("Введиет второе число ");
            int number2 = scaner.nextInt();
            System.out.println("выберите операцию ");
            String x = scaner.next();
            switch (x) {
                case "+":
                    System.out.println(number1 + number2);
                    break;
                case "-":
                    System.out.println(number1 - number2);
                    break;
                case "*":
                    System.out.println(number1 * number2);
                    break;
                case "/":
                    System.out.println(number1 / number2);
                    break;
            }
            System.exit(0);
        } catch (ArithmeticException e) {
            System.out.println("Недопустимая операция");
            System.exit(0);
        } finally {
            System.out.println("Всё хорошо");
        }
    }
}
