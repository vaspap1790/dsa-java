public class Theory {

    /**
     * Time Complexity
     * It is a programming term that quantifies the amount of time it takes a sequence of code or an algorithm
     * to process or execute in proportion to the size and cost of input.
     */

    /**
     * Space Complexity
     * Refers to the total amount of memory space used by an algorithm/program to store info at runtime,
     * as well as the disk space needed by the code for persistent storage
     * in proportion to the size and cost of input.
     */

    /**
     * Big O Notation
     * It is used to classify algorithms according to how their run Time and Space Complexity
     *   1  <=  logN  <=  sqr(N)  <=  N  <=  NlogN  <=  N^2  <=  N^3  <=  2^N  <=  <= N!
     */

    /**
     * Recursion
     * It is a method of solving a computational problem
     * where the solution depends on solutions to smaller instances of the same problem
     */

    /**
     * Head Recursion
     * If a recursive function calling itself and that recursive call is the first statement in the function then it’s known as Head Recursion.
     * There’s no statement, no operation before the call.
     * The function doesn’t have to process or perform any operation at the time of calling and all operations are done at returning time.
     */

    /**
     * Linear Recursion
     * It is when a function only makes a single call to itself each time the function runs,
     * as opposed to one that would call itself multiple times during its execution thus Non-Linear Recursion
     */

    /**
     * Tail recursion
     * It is a form of linear recursion. In tail recursion, the recursive call is the last thing the function does.
     * Often, the value of the recursive call is returned.
     * No calls are stored in the stack, thus it is more memory efficient than head recursion.
     * As such, tail recursive functions can often be easily implemented in an iterative manner;
     * by taking out the recursive call and replacing it with a loop, the same effect can generally be achieved.
     * In fact, a good compiler can recognize tail recursion and convert it to iteration
     * in order to optimize the performance of the code
     * Not all logics can be made tail-recursive. For example non-linear recursions must maintain a variable
     */

    /**
     * Tree Recursion
     * If a recursive function calling itself for more than one time then it’s known as Tree Recursion
     * Two-Branch Recursion is when a function calls itself twice with different arguments during its execution.
     */

    /**
     * Recursion vs Iterative Approach
     * Iteration is faster and more space-efficient than recursion.
     * So why do we even need recursion?
     * The reason is simple — it's easier to code a recursive approach for a given problem.
     */

}
