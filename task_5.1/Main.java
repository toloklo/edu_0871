/*
Перед решением прочтите https://www.codeflow.site/ru/article/java-buffered-reader
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи
Лондон
Пример вывода:
Абрамовичи */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scan = new Scanner(System.in);
        List<String> listCity = new ArrayList<>();
        List<String> listFamily = new ArrayList<>();

        while (true) {
            System.out.println("Введите город");
            String city = reader.readLine();
            if (city.isEmpty()) {
                break;
            }


            System.out.println("Введите фамилию");
            String family = reader.readLine();
            if (family.isEmpty()) {
                break;
            }
            listCity.add(city);
            listFamily.add(family);
        }

        while (true) {

            System.out.println("Введите город для поиска");
            String findCity = scan.nextLine();
            System.out.println(listFamily.get(listCity.indexOf(findCity)));
            break;
        }


    }
}



