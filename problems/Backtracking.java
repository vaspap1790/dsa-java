package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backtracking {

    /**
     * Subsets (Powerset)
     * Ex: [1,2,3] : [], [1], [2], [3], [1,2], [1,3], [2,3], [1,2,3] (Total: 2^n)
     * The idea is to have two conditions:
     * One in which we will take the element into consideration,
     * Second in which we won't take the element into consideration
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrackSubsets(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void backtrackSubsets(List<List<Integer>> result, List<Integer> tempList, int [] nums, int start){
        result.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrackSubsets(result, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    /**
     * Subsets II
     */
    public static List<List<Integer>> subsetsNoDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrackSubsetsNoDup(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void backtrackSubsetsNoDup(List<List<Integer>> result, List<Integer> tempList, int [] nums, int start){
        result.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i - 1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrackSubsetsNoDup(result, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    /**
     * Permutations - no repetition
     * Ex: [1,2,3] : [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] (Total: N!)
     * in permutations, the order of the elements matter, ex: [1, 2, 3] != [2, 1, 3]
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrackPermutations(result, new ArrayList<>(), nums);
        return result;
    }

    private static void backtrackPermutations(List<List<Integer>> result, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            result.add(new ArrayList<>(tempList));
        } else {
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrackPermutations(result, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    /**
     * Permutations II
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrackPermuteUnique(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private static void backtrackPermuteUnique(List<List<Integer>> result, List<Integer> tempList, int [] nums, boolean [] used){
        if(tempList.size() == nums.length){
            result.add(new ArrayList<>(tempList));
        } else {
            for(int i = 0; i < nums.length; i++){
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrackPermuteUnique(result, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    /**
     * Combinations - no repetition
     * Ex: [1,2,3] : [1,2,3]
     * in combinations, the order of the elements does not matter, ex: [1, 2, 3] = [2, 1, 3]
     * usually asked: combinations of k numbers chosen from [1, N]
     * ex: for N=4 and K=3 : [1, 2, 3], [1, 2, 4], [1, 3, 4], [2, 3, 4]
     */
    public static List<List<Integer>> combinations(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrackCombinations(result, new ArrayList<>(), n, k, 1);
        return result;
    }

    private static void backtrackCombinations(List<List<Integer>> result, List<Integer> tempList,
                                              int n, int k, int start){
        if(tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = start; i <= n; i++){
            tempList.add(i);
            backtrackCombinations(result, tempList, n, k, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    /**
     * Combination Sum
     */
    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrackCombinationSum(result, new ArrayList<>(), nums, target, 0);
        return result;
    }

    private static void backtrackCombinationSum(List<List<Integer>> result, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) result.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrackCombinationSum(result, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    /**
     * Combination Sum II
     */
    public static List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrackCombinationSum2(result, new ArrayList<>(), nums, target, 0);
        return result;

    }

    private static void backtrackCombinationSum2(List<List<Integer>> result, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) result.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
                tempList.add(nums[i]);
                backtrackCombinationSum2(result, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    /**
     * Palindrome Partitioning
     */
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrackPartition(result, new ArrayList<>(), s, 0);
        return result;
    }

    public static void backtrackPartition(List<List<String>> result, List<String> tempList, String s, int start){
        if(start == s.length())
            result.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < s.length(); i++){
                if(isPalindrome(s, start, i)){
                    tempList.add(s.substring(start, i + 1));
                    backtrackPartition(result, tempList, s, i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    public static boolean isPalindrome(String s, int low, int high){
        while(low < high)
            if(s.charAt(low++) != s.charAt(high--)) return false;
        return true;
    }
}
