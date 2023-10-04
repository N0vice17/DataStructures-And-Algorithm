from typing import List

def combinationSum2(arr: List[int], n: int, target: int) -> List[List[int]]:
    def solve(ind, target):
        if target == 0:
            ans.append(ds[:])
            return
        for i in range(ind, len(arr)):
            if i > ind and arr[i - 1] == arr[i]:
                continue
            if arr[i] > target:
                break
            ds.append(arr[i])
            solve(i + 1, target - arr[i])
            ds.pop()

    arr.sort()
    ans = []
    ds = []
    solve(0, target)
    return ans

if __name__ == "__main__":
    arr = [10, 1, 2, 7, 6, 5]
    target = 8
    result = combinationSum2(arr, len(arr), target)
    print("Combinations that sum to", target, "are:")
    print(result)
