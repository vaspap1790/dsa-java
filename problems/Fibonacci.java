package problems;

public class Fibonacci {

    final static int NUMBER = 5;
    public static void main(String[] args) {
        System.out.printf("----Calculate the fibonacci of %d----%n", NUMBER);
        System.out.println("************************");

        System.out.println("Head Recursion fibonacci:");
        System.out.println(headRecursion(NUMBER));
        System.out.println("************************");

        System.out.println("Tail Recursion fibonacci:");
        System.out.println(tailRecursion(NUMBER, 0, 1));
        System.out.println("************************");

        System.out.println("Iterative fibonacci:");
        System.out.println(iterative(NUMBER));
        System.out.println("************************");
    }

    // 2^n
    private static int headRecursion(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        return headRecursion(n - 1) + headRecursion(n - 2);
    }
    private static int tailRecursion(int n, int a, int b){
        if(n == 0) return a;
        if(n == 1) return b;
        return tailRecursion(n - 1, b, a + b);
    }
    private static int iterative(int n){
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++){
            int temp = a;
            a = b;
            b = b + temp;
        }
        return b;
    }
}