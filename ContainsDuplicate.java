\\Solved Contains Duplicate on LeetCode using HashSet (O(n) Time Complexity)
import java.util.HashSet;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> numbers = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if (!numbers.add(nums[i])) return true;
        }
        return false;
    }
}
