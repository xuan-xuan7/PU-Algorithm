from typing import List


class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        length = len(triangle)
        f = [[0] * length for _ in range(length)]
        f[0][0] = triangle[0][0]

        for i in range(1, length):
            f[i][0] = f[i - 1][0] + triangle[i][0]
            for j in range(1, i):
                f[i][j] = min(f[i - 1][j], f[i - 1][j - 1]) + triangle[i][j]
            f[i][i] = f[i - 1][i - 1] + triangle[i][i]

        return min(f[length - 1])


def main():
    temp = input()
    n = int(temp)
    temp = input().split(" ")
    count = 0
    triangle = [[0] * n for _ in range(n)]
    for i in range(n):
        for j in range(i + 1):
            triangle[i][j] = int(temp[count])
            count += 1
    re = Solution()
    ans = re.minimumTotal(triangle)
    print(ans)


if __name__ == '__main__':
    main()
