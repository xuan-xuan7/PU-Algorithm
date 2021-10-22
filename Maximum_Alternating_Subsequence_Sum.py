# 数组中均为正数，所以子序列必为奇数
# 分别用两个序列记录当前状态下最大奇数子序列和最大偶数子序列
# 动态规划，状态转移方程

from typing import List


class Solution:
    def maxAlternatingSum(self, nums: List[int]) -> int:
        n = len(nums)
        odd = 0
        even = nums[0]
        for i in range(n):
            odd = max(even - nums[i], odd)
            even = max(odd + nums[i], even)
        return even

def main():
    temp = input().split(" ")
    num = [0 for i in range(len(temp))]
    for i in range(len(temp)):
        num[i] = int(temp[i])
    re = Solution()
    ans = re.maxAlternatingSum(num)
    print(ans)

if __name__ == '__main__':
    main()