package problems;

public class Factorial {

    final static int NUMBER = 5;
    public static void main(String[] args) {
        System.out.printf("----Calculate the factorial of %d----%n", NUMBER);
        System.out.println("************************");

        System.out.println("Head Recursion factorial:");
        System.out.println(headRecursion(NUMBER));
        System.out.println("************************");

        System.out.println("Tail Recursion factorial:");
        System.out.println(tailRecursion(NUMBER, 1));
        System.out.println("************************");

        System.out.println("Iterative factorial:");
        System.out.println(iterative(NUMBER));
        System.out.println("************************");
    }

    private static int headRecursion(int n) {
        if (n == 1) return 1;
        return n * headRecursion(n - 1);
    }

    private static int tailRecursion(int n, int accumulator) {
        if (n == 1) return accumulator;
        return tailRecursion(n - 1, n * accumulator);
    }

    private static int iterative(int n) {
        int res = 1;
        while(n > 1){
            res *= n;
            n--;
        }
        return res;
    }
}
