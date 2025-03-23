public class HW2 {
    public static void main(String[] args) {

        System.out.println("Можно ли идти гулять,");
        // ПУНКТ 3
        System.out.println("1) " + permission(34, -16));
        System.out.println("2) " + permission(26, 46));
        System.out.println("3) " + permission(75, -12));
        System.out.println("4) " + permission(15, 15));
        System.out.println("5) " + permission(32, 0));
        // ПУНКТ 5
        System.out.println(permission(generateRandomAge(), 15));
    }

    public static String permission(int age, int temperature) { // ПУНКТ 1
        //  ПУНКТ 2
        if (age >= 20 && age <= 45 && temperature >= -20 && temperature <= 30) {
            return "Можно идти гулять";
        }
        else if (age < 20 && temperature >= 0 && temperature <= 28) {
            return "Можно идти гулять";
        }
        else if (age > 45 && temperature >= -10 && temperature <= 25) {
            return "Можно идти гулять";
        } else return "Оставайтесь дома";
    }
    // ПУНКТ 4
    public static int generateRandomAge() {
        return (int) (Math.random() * 120);
    }


}
