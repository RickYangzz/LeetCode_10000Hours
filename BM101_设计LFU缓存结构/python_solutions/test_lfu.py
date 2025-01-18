import unittest
from solution import Solution

# 测试用例
class TestLFUCache(unittest.TestCase):

    def setUp(self):
        """每个测试用例运行之前都调用一次，设置初始状态"""
        self.solution = Solution()

    def test_basic_operations(self):
        operators = [
            [1, 1, 1],  # set(1, 1)
            [1, 2, 2],  # set(2, 2)
            [2, 1],     # get(1) → 1
            [2, 2],     # get(2) → 2
        ]
        k = 2
        result = self.solution.LFU(operators, k)
        self.assertEqual(result, [1, 2])

    def test_cache_capacity_exceeded(self):
        operators = [
            [1, 1, 1],  # set(1, 1)
            [1, 2, 2],  # set(2, 2)
            [1, 3, 3],  # set(3, 3) → Cache is full, remove least used (1)
            [2, 1],     # get(1) → -1 (removed)
            [2, 2],     # get(2) → 2
            [2, 3],     # get(3) → 3
        ]
        k = 2
        result = self.solution.LFU(operators, k)
        self.assertEqual(result, [-1, 2, 3])

    def test_multiple_get_set_same_key(self):
        operators = [
            [1, 1, 1],  # set(1, 1)
            [1, 2, 2],  # set(2, 2)
            [2, 1],     # get(1) → 1
            [1, 1, 10], # set(1, 10)
            [2, 1],     # get(1) → 10
        ]
        k = 2
        result = self.solution.LFU(operators, k)
        self.assertEqual(result, [1, 10])

    def test_single_entry_cache(self):
        operators = [
            [1, 1, 1],  # set(1, 1)
            [2, 1],     # get(1) → 1
            [1, 2, 2],  # set(2, 2) → Cache is full, remove 1
            [2, 1],     # get(1) → -1 (removed)
            [2, 2],     # get(2) → 2
        ]
        k = 1
        result = self.solution.LFU(operators, k)
        self.assertEqual(result, [1, -1, 2])

    def test_handling_multiple_lfu_keys(self):
        operators = [
            [1, 1, 1],  # set(1, 1)
            [1, 2, 2],  # set(2, 2)
            [1, 3, 3],  # set(3, 3)
            [2, 1],     # get(1) → 1
            [2, 2],     # get(2) → 2
            [1, 4, 4],  # set(4, 4) → Cache is full, remove 3 (LFU)
            [2, 3],     # get(3) → -1 (removed)
            [2, 4],     # get(4) → 4
        ]
        k = 3
        result = self.solution.LFU(operators, k)
        self.assertEqual(result, [1, 2, -1, 4])

    def test_empty_cache(self):
        operators = []
        k = 2
        result = self.solution.LFU(operators, k)
        self.assertEqual(result, [])

    def test_repeated_get_without_set(self):
        operators = [
            [1, 1, 1],  # set(1, 1)
            [2, 2],     # get(2) → -1 (not in cache)
            [2, 1],     # get(1) → 1
            [2, 3],     # get(3) → -1 (not in cache)
        ]
        k = 2
        result = self.solution.LFU(operators, k)
        self.assertEqual(result, [-1, 1, -1])

    def test_large_capacity(self):
        operators = [
            [1, 1, 1],  # set(1, 1)
            [1, 2, 2],  # set(2, 2)
            [1, 3, 3],  # set(3, 3)
            [1, 4, 4],  # set(4, 4)
            [2, 1],     # get(1) → 1
            [2, 2],     # get(2) → 2
            [2, 3],     # get(3) → 3
            [2, 4],     # get(4) → 4
        ]
        k = 5
        result = self.solution.LFU(operators, k)
        self.assertEqual(result, [1, 2, 3, 4])

if __name__ == '__main__':
    unittest.main()
