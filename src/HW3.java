public class HW3 {
    public static void main(String[] args) {

        double[] arrayD = {123.15, 65.15, -5.94, 65.10, 2.90, // ПУНКТ 1
                -4.45, 14.87, 612.10, -56.24, 48.85,
                35.71, -1.24, 4.73, 312.10, -31.86};
        int kolvo=0;
        double sum = 0;
        boolean uslovie = false;
        for (double arrayf: arrayD) {
            if (arrayf < 0) {
                uslovie = true;
            }
            if (arrayf >0 && uslovie){
            kolvo++;
            sum += arrayf;}
        }
        System.out.println(" Среднеарифметическое =  " + (sum / kolvo)); // ПУНКТ 2
    }
}
