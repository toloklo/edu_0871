/*
Используя цикл for вывести на экран прямоугольный треугольник из восьмёрок со сторонами 10 и 10.
Пример вывода на экран:
8
88
888
8888
88888
888888
8888888
88888888
888888888
8888888888
*/

public class Main {
    public static void main(String[] args) {
        //напишите тут ваш код
        int j;
        for (int i=1; i<11; i++){
            j=0;
            while (j<i) {
                System.out.print("8");
                j++;
            }
            System.out.println();
        }

    }
}

