class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        m = len(nums1)
        n = len(nums2)

        if m > n: return self.findMedianSortedArrays(nums2, nums1)

        partitionSize = (m+n+1) // 2
        left = 0
        right = m

        while left <= right:
            middle_1 = (left + right) // 2
            middle_2 = partitionSize - middle_1

            left_1 = nums1[middle_1 - 1] if middle_1 - 1 >= 0 else float('-inf')
            right_1 = nums1[middle_1] if middle_1 < m else float('inf')
            left_2 = nums2[middle_2 - 1] if middle_2 - 1 >= 0 else float('-inf')
            right_2 = nums2[middle_2] if middle_2 < n else float('inf')

            if left_1 <= right_2 and left_2 <= right_1:
                if (m+n) % 2 == 1:
                    return max(left_1, left_2)
                else:
                    return (max(left_1, left_2) + min(right_1, right_2)) / 2
            elif left_1 > right_2:
                right = middle_1 - 1
            else:
                left = middle_1 + 1
