# 贪心算法
# 维护未匹配左括号可能的最大最小值，遇到左括号两者加一，遇到右括号两者减一，遇到*分别加一减一

class ValidParentthesisString:
    def checkValidString(self, s: str) -> bool:
        minCount = 0
        maxCount = 0
        for ch in s:
            if ch == '(':
                minCount += 1
                maxCount += 1
            elif ch == ')':
                minCount = max(minCount - 1, 0)
                maxCount -= 1
                if maxCount < 0:
                    return False
            else:
                minCount = max(minCount - 1, 0)
                maxCount += 1
        return minCount == 0

def main():
    s = input()
    re = ValidParentthesisString
    ans = re.checkValidString(re, s)
    if ans:
        print("True")
    else:
        print("NO")

if __name__ == '__main__':
    main()