import java.util.*;

class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(0,nums,nums.length,temp,ans);
        return ans;
    }

    public static void solve(int i, int nums[], int n, List<Integer> temp, List<List<Integer>> ans){
        if(i==n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        solve(i+1,nums,n,temp,ans);
        temp.remove(temp.size()-1);
        solve(i+1,nums,n,temp,ans);
    }

}