#optimal way to solve rather than using sets
from typing import List

def subsetsWithDup(nums: List[int]) -> List[List[int]]:
    def findSubsets(ind):
        ans.append(ds[:])
        for i in range(ind, len(nums)):
            if i != ind and nums[i] == nums[i - 1]:
                continue
            ds.append(nums[i])
            findSubsets(i + 1)
            ds.pop()

    nums.sort()
    ans = []
    ds = []
    findSubsets(0)
    return ans

if __name__ == "__main__":
    nums = [1, 2, 2]
    result = subsetsWithDup(nums)
    print("Subsets with duplicates are:")
    print(result)
