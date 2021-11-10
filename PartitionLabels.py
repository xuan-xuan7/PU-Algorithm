from typing import List


class PartitionLabels:
    def partitionLabels(self, s: str) -> List[int]:
        endIndex = [0 for i in range(26)]
        count = 0
        for ch in s:
            endIndex[ord(ch) - ord('a')] = count
            count += 1
        ans = []
        count = 0
        end = 0
        start = 0
        for ch in s:
            end = max(end, endIndex[ord(ch) - ord('a')])
            if count == end:
                ans.append(end - start + 1)
                start = end + 1
            count += 1
        return ans

def main():
    s = input()
    re = PartitionLabels()
    ans = re.partitionLabels(s)
    print(*ans, end = ' ')

if __name__ == '__main__':
    main()