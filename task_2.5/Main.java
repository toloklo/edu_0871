/*Вывести на экран все возможные комбинации слов "Мама", "Мыла", "Раму".
Подсказка: их 6 штук.
Каждую комбинацию вывести с новой строки. Слова не разделять.
Пример:
МылаРамуМама
РамуМамаМыла
...
Требования:
•	Программа должна выводить текст.
•	Выведенный текст должен содержать 6 строк.
•	Текст в каждой строке должен быть уникален.
•	Должны быть выведены все возможные комбинации. */

public class Main {
    public static void main(String[] args) {
        //напишите тут ваш код
        System.out.println("МылаРамуМама");
        System.out.println("РамуМамаМыла");
        System.out.println("МамаМылаРаму");
        System.out.println("РамуМылаМама");
        System.out.println("МылаМамаРаму");
        System.out.println("МамаРамуМыла");
    }
}


/*public class Main {
    public static void main(String[] args) {
        //напишите тут ваш код
        String[] word = new String [] {"Мама", "Мыла", "Раму"};

        for ( int i=0; i<6; i++) {
            int word1=i/2;
            System.out.print (word[word1]);
            int j=0;
            while (j<=word1) {
              if (j!=word1) System.out.print (word[j]);
            j++;

            }

            System.out.println(word [(5-i)/2]);


        }
            }



    }


