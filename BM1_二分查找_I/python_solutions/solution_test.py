from solution import Solution

def run_test(nums: list[int], target: int, expected: int) -> None:
    solution = Solution()
    result = solution.search(nums, target)
    print(f"Input array: {nums}")
    print(f"Target: {target}")
    print(f"Expected: {expected}, Got: {result}")
    print(f"Test {'PASSED' if result == expected else 'FAILED'}\n")

def main():
    # Test Case 1: Normal case - element exists
    run_test([1, 2, 4, 4, 5], 4, 2)

    # Test Case 2: Element not found
    run_test([1, 2, 4, 4, 5], 3, -1)

    # Test Case 3: Empty array
    run_test([], 5, -1)

    # Test Case 4: Single element - found
    run_test([1], 1, 0)

    # Test Case 5: Single element - not found
    run_test([1], 2, -1)

if __name__ == "__main__":
    main() 