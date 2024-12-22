from programming_exercise import Solution
from typing import List

def run_test(nums: List[int], target: int, expected: int) -> None:
    solution = Solution()
    result = solution.search(nums, target)
    print(f"Input array: {nums}")
    print(f"Target: {target}")
    print(f"Expected: {expected}, Got: {result}")
    print(f"Test {'PASSED' if result == expected else 'FAILED'}\n")

def main():
    # Test Case 1: Normal case - element exists in middle
    run_test([1, 2, 4, 5, 6], 4, 2)

    # Test Case 2: Element not found
    run_test([1, 2, 4, 5, 6], 3, -1)

    # Test Case 3: Empty array
    run_test([], 5, -1)

    # Test Case 4: Single element - found
    run_test([1], 1, 0)

    # Test Case 5: Single element - not found
    run_test([1], 2, -1)
    
    # Test Case 6: Element at beginning
    run_test([1, 3, 5, 7, 9], 1, 0)
    
    # Test Case 7: Element at end
    run_test([1, 3, 5, 7, 9], 9, 4)
    
    # Test Case 8: Larger sorted array
    run_test([1, 3, 5, 7, 9, 11, 13, 15, 17, 19], 13, 6)

    # Test Case 9: Element not found in larger array
    run_test([1, 3, 5, 7, 9, 11, 13, 15, 17, 19], 10, -1)

    # Test Case 10: Element in sparse array
    run_test([2, 8, 14, 20, 26], 14, 2)

if __name__ == "__main__":
    main()