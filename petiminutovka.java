import java.util.Arrays;

public class petiminutovka{
    public static void main(String[] args) {
        printMultiplicationTable();
        int[] numbers = {7, 3, 2, 5, 6};
        System.out.println("Median: " + median(numbers));
        int number = 17;
        System.out.println("Is " + number + " prime? " + isPrime(number));
        printBumPrask();
    }
    public static void printMultiplicationTable() {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%3d ", i * j);
            }
            System.out.println();
        }
    }
    public static double median(int[] numbers) {
        Arrays.sort(numbers);
        int length = numbers.length;
        if (length % 2 == 0) {
            return (double) (numbers[length / 2 - 1] + numbers[length / 2]) / 2;
        } else {
            return numbers[length / 2];
        }
    }
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number <= 3) {
            return true;
        }
        return isPrimeRecursive(number, 2);
    }
    public static boolean isPrimeRecursive(int number, int divisor) {
        if (divisor * divisor > number) {
            return true;
        }
        if (number % divisor == 0) {
            return false;
        }
        return isPrimeRecursive(number, divisor + 1);
    }
    public static void printBumPrask() {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 || String.valueOf(i).contains("3")) {
                System.out.println("BUM");
            } else if (i % 5 == 0 || String.valueOf(i).contains("5")) {
                System.out.println("PRÁSK");
            } else {
                System.out.println(i);
            }
        }
    }
}
