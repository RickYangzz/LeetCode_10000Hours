class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        count = [0 for _ in range(n+1)]

        for arr in trust:
            count[arr[0]] -= 1
            count[arr[1]] += 1

        for i in range(1, n+1):
            if count[i] == n-1: return i

        return -1