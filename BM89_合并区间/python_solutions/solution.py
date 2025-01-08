from typing import List


class Interval:
    def __init__(self, a=0, b=0):
        self.start = a
        self.end = b

#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# 
# @param intervals Interval类一维数组 
# @return Interval类一维数组
#
class Solution:
    def merge(self , intervals: List[Interval]) -> List[Interval]:
        intervals.sort(key = lambda _: (_.start, _.end))

        result: List[Interval] = []
        start = -1
        end = -1

        for interval in intervals:
            if interval.start <= end:
                end = max(interval.end, end)
                continue

            if start>=0 and end >= 0: result.append(Interval(start,end))

            start = interval.start
            end = interval.end
        
        if start>=0 and end >= 0: result.append(Interval(start,end))
        
        return result

