
import { findPeakElement } from './solution';

describe('findPeakElement', () => {
  test('Single Peak in the Middle', () => {
    expect(findPeakElement([1, 3, 2])).toBe(1); // Expected index of peak element 3
  });

  test('Peak at the Beginning', () => {
    expect(findPeakElement([3, 2, 1])).toBe(0); // Expected index of peak element 3
  });

  test('Peak at the End', () => {
    expect(findPeakElement([1,2,3,4,5,6,7,8,9])).toBe(8); // Expected index of peak element 3
  });

  test('Multiple Peaks', () => {
    const result = findPeakElement([1, 3, 2, 3, 1]);
    expect([1, 3]).toContain(result); // Expected index could be 1 or 3 (both are peaks)
  });

  test('Large Array', () => {
    expect(findPeakElement([1, 2, 3, 4, 5, 4, 3, 2, 1])).toBe(4); // Expected index of peak element 5
  });

  test('Array with Only One Element', () => {
    expect(findPeakElement([10])).toBe(0); // Expected index of the only element
  });

  test('Descending Array', () => {
    expect(findPeakElement([10, 9, 8, 7, 6])).toBe(0); // Expected index of peak element 10
  });

  test('Ascending Array', () => {
    expect(findPeakElement([1, 2, 3, 4, 5])).toBe(4); // Expected index of peak element 5
  });

  test('Array with Multiple Elements Having Same Value', () => {
    const result = findPeakElement([1, 1, 1, 1, 1]);
    expect([0, 1, 2, 3, 4]).toContain(result); // Any index can be returned as the peak
  });

  test('Complex Case', () => {
    const result = findPeakElement([1, 4, 3, 6, 5, 8, 7, 2, 10]);
    expect([1, 3, 5, 8]).toContain(result); // Expected index of possible peaks (4, 6, 8, 10)
  });
});
