/* Написать функцию, которая вычисляет минимум из трёх чисел.
Требования:
•	Программа должна выводить текст на экран.
•	Метод min не должен выводить текст на экран.
•	Метод main должен вызвать метод min четыре раза.
•	Метод main должен выводить на экран результат работы метода min. Каждый раз с новой строки.
•	Метод min должен возвращать минимальное значение из чисел a, b и с.
*/


public class Main {
    public static int min(int a, int b, int c) {
        //напишите тут ваш код
        int min1, min2;
        if (a<c) min1=a;
        else min1=c;

        if (b<c) min2=b;
        else min2=c;

        if (min1<min2) return min1;
        else return min2;


    }

    public static void main(String[] args) {
        System.out.println(min(1, 2, 3));
        System.out.println(min(-1, -2, -3));
        System.out.println(min(3, 5, 3));
        System.out.println(min(5, 5, 10));
    }
}
