package problems;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    final static int NUMBER = 5;
    static Map<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        System.out.printf("----Calculate the fibonacci of %d----%n", NUMBER);
        System.out.println("************************");

        System.out.println("Head Recursion fibonacci:");
        System.out.println(headRecursion(NUMBER));
        System.out.println("************************");

        System.out.println("Tail Recursion fibonacci:");
        System.out.println(tailRecursion(NUMBER, 0 ,1));
        System.out.println("************************");


        System.out.println("Memoization fibonacci:");
        System.out.println(memoization(NUMBER));
        System.out.println("************************");

        System.out.println("Tabulation fibonacci:");
        System.out.println(tabulation(NUMBER));
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

    private static int memoization(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(cache.containsKey(n)) return cache.get(n);

        cache.put(n, memoization(n - 1) + memoization(n - 2));
        return cache.get(n);
    }

    private static int tabulation(int n){
        if (n < 2) return n;
        int first = 0;
        int second = 1;
        for (int i = 2; i <= n; i++){
            int temp = first + second;
            first = second;
            second = temp;
        }
        return second;
    }
}