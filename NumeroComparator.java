public class NumeroComparator {
    public static String comparar(double num1, double num2) {
        if (num1 > num2) {
            return num1 + " es mayor que " + num2;
        } else if (num1 < num2) {
            return num1 + " es menor que " + num2;
        } else {
            return num1 + " es igual a " + num2;
        }
    }
}