/*
Вывести на экран произведение 10 чисел от 1 до 10.
Результат - это 1 число.
Подсказка:
будет три миллиона с хвостиком.
Требования:
•	Программа должна выводить целое число на экран.
•	Метод main должен вызывать функцию System.out.println.
•	Выведенное число должно быть больше трех миллионов.
•	Выведенное число должно соответствовать заданию.
*/

public class Main {
    public static void main(String[] args) {
        //напишите тут ваш код
        System.out.println(1*2*3*4*5*6*7*8*9*10);
    }
}
//Вариант с циклом
/*public class Main {
    public static void main(String[] args) {
        //напишите тут ваш код
        int mult = 1;
        for (int i=2; i<11; i++) {

            mult*=i;
        }
        System.out.println(mult);
    }
}
*/