package techniques;

/**
 * Used to find an element in a ordered/sorted collection
 * Time Complexity: O(logN)
 * Space Complexity: O(1)
 */
public class BinarySearch {
    public int binarySearch(int[] nums, int target) {
        int pivot;
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            pivot = left + (right - left) / 2;
            if(target < nums[pivot]) right = pivot - 1;
            else if (target > nums[pivot]) left = pivot + 1;
            else return pivot;
        }

        return -1;
    }

    // Ends up nums[left] = nums[right] = target
    public int binarySearchFirstOfDuplicates(int[] nums, int target) {
        int pivot;
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            pivot = left + (right - left) / 2;
            if(target < nums[pivot]) right = pivot;
            else if (target > nums[pivot]) left = pivot + 1;
        }

        return nums[left] == target ? left : -1;
    }

    public int binarySearchLastOfDuplicates(int[] nums, int target) {
        int pivot;
        int left = 0;
        int right = nums.length - 1;

        while(left + 1 < right){
            pivot = left + (right - left) / 2;
            if(nums[pivot] == target) return pivot;
            else if (nums[pivot] > target) right = pivot - 1;
            else left = pivot;
        }

        if (nums[right] == target) return right;
        return nums[left] == target ? left : -1;
    }
}
