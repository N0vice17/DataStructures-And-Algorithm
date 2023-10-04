class Solution:
    def quickSort(self, arr, s, e):
        if s >= e:
            return
        p = self.partition(arr, s, e)
        self.quickSort(arr, s, p - 1)
        self.quickSort(arr, p + 1, e)

    def partition(self, arr, s, e):
        pivot = arr[s]
        count = 0

        for i in range(s + 1, e + 1):
            if arr[i] < pivot:
                count += 1

        pivot_index = s + count
        arr[s], arr[pivot_index] = arr[pivot_index], arr[s]

        i, j = s, e
        while i < pivot_index and j > pivot_index:
            while arr[i] < pivot:
                i += 1
            while arr[j] > pivot:
                j -= 1
            if i < pivot_index and j > pivot_index:
                arr[i], arr[j] = arr[j], arr[i]
                i += 1
                j -= 1

        return pivot_index


def printlist(arr):
    for num in arr:
        print(num, end=" ")
    print()




n = int(input())
arr = list(map(int, input().split()))
solution = Solution()
solution.quickSort(arr, 0, n - 1)
printlist(arr)
