import java.util.Scanner;

public class HW1 {
    public static void main(String[] args) {

    String aFewWords ; // ПУНКТ 1

    int NUM = 165 ;  // ПУНКТ 2

    String word = "SomeWords" ; // ПУНКТ 3

    aFewWords = NUM +" "+ word ; // ПУНКТ 4

    System.out.println(aFewWords); // ПУНКТ 5
    System.out.println(NUM);
    System.out.println(word);

    if (NUM < 0) {
        System.out.println("Вы сохронили отрицательное число"); // ПУНКТ 6
    } else if (NUM > 0){
        System.out.println("Вы сохранили положительное число");
    } else{
        System.out.println("В сохронили ноль");}

    Scanner scanner = new Scanner(System.in);
    System.out.println("Введите ваше имя:"); // ПУНКТ 7
    String name = scanner.nextLine(); // ПУНКТ 8
    System.out.println("Здравствуйте " + name); // ПУНКТ 9

    }
}