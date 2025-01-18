import { LFU } from "./Solution";

describe('LFU Cache Tests', () => {

  test('Test Case 1: Basic Operations', () => {
    const operators = [
      [1, 1, 1],  // set(1, 1)
      [1, 2, 2],  // set(2, 2)
      [2, 1],     // get(1) → 1
      [2, 2],     // get(2) → 2
    ];
    const k = 2;
    const result = LFU(operators, k);
    expect(result).toEqual([1, 2]);
  });

  test('Test Case 2: Cache Capacity Exceeded', () => {
    const operators = [
      [1, 1, 1],  // set(1, 1)
      [1, 2, 2],  // set(2, 2)
      [1, 3, 3],  // set(3, 3) → Cache is full, remove least used (1)
      [2, 1],     // get(1) → -1 (removed)
      [2, 2],     // get(2) → 2
      [2, 3],     // get(3) → 3
    ];
    const k = 2;
    const result = LFU(operators, k);
    expect(result).toEqual([-1, 2, 3]);
  });

  test('Test Case 3: Multiple `get` and `set` Operations with Same Key', () => {
    const operators = [
      [1, 1, 1],  // set(1, 1)
      [1, 2, 2],  // set(2, 2)
      [2, 1],     // get(1) → 1
      [1, 1, 10], // set(1, 10)
      [2, 1],     // get(1) → 10
    ];
    const k = 2;
    const result = LFU(operators, k);
    expect(result).toEqual([1, 10]);
  });

  test('Test Case 4: Single Entry Cache', () => {
    const operators = [
      [1, 1, 1],  // set(1, 1)
      [2, 1],     // get(1) → 1
      [1, 2, 2],  // set(2, 2) → Cache is full, remove 1
      [2, 1],     // get(1) → -1 (removed)
      [2, 2],     // get(2) → 2
    ];
    const k = 1;
    const result = LFU(operators, k);
    expect(result).toEqual([1, -1, 2]);
  });

  test('Test Case 5: Handling Multiple LFU Keys', () => {
    const operators = [
      [1, 1, 1],  // set(1, 1)
      [1, 2, 2],  // set(2, 2)
      [1, 3, 3],  // set(3, 3)
      [2, 1],     // get(1) → 1
      [2, 2],     // get(2) → 2
      [1, 4, 4],  // set(4, 4) → Cache is full, remove 3 (LFU)
      [2, 3],     // get(3) → -1 (removed)
      [2, 4],     // get(4) → 4
    ];
    const k = 3;
    const result = LFU(operators, k);
    expect(result).toEqual([1, 2, -1, 4]);
  });

  test('Test Case 6: Empty Cache', () => {
    const operators: number[][] = [];
    const k = 2;
    const result = LFU(operators, k);
    expect(result).toEqual([]);
  });

  test('Test Case 7: Repeated `get` Without `set`', () => {
    const operators = [
      [1, 1, 1],  // set(1, 1)
      [2, 2],     // get(2) → -1 (not in cache)
      [2, 1],     // get(1) → 1
      [2, 3],     // get(3) → -1 (not in cache)
    ];
    const k = 2;
    const result = LFU(operators, k);
    expect(result).toEqual([-1, 1, -1]);
  });

  test('Test Case 8: Test Cache with Larger `k`', () => {
    const operators = [
      [1, 1, 1],  // set(1, 1)
      [1, 2, 2],  // set(2, 2)
      [1, 3, 3],  // set(3, 3)
      [1, 4, 4],  // set(4, 4)
      [2, 1],     // get(1) → 1
      [2, 2],     // get(2) → 2
      [2, 3],     // get(3) → 3
      [2, 4],     // get(4) → 4
    ];
    const k = 5;
    const result = LFU(operators, k);
    expect(result).toEqual([1, 2, 3, 4]);
  });

});

