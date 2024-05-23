import java.util.List;

import static problems.Backtracking.subsets;

public class Main {

    public static void main(String[] args) {
        List<List<Integer>> result = subsets(new int[]{1, 2, 3});
        System.out.println(result);
    }

}
