/* 
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
-2
11
3
-5
2
10
Пример вывода:
-2
2
8
10
*/

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        ///Users/comp/task52.txt        
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите имя файла");
        String filename = scan.nextLine();
        FileReader reader = new FileReader(filename);
        int c;
        String task52 = "";
        while ((c=reader.read())!=-1) {
            task52 += (char) c;
        }
        String[] strArr = task52.split("\\n");
        int numArr[] = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);
        }
        Arrays.sort(numArr);

        for (int i = 0; i < numArr.length; i++) {

            if (numArr[i]%2==0)
            System.out.println(numArr[i]);
        }
    }
}
