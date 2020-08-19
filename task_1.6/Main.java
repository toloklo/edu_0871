/*
Пользователь вводит число, необходимо увеличить это число на 15% и вывести результат на экран
*/


import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Ваш код
        System.out.println("Введите число");
        Scanner scan = new Scanner(System.in);
        float number = scan.nextFloat();
        System.out.println(number*115/100);
    }
}
