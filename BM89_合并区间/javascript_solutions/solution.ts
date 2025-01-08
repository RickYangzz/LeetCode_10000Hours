class Interval {
    start: number
    end: number
    constructor(start: number, end: number) {
        this.start = start
        this.end = end
    }
}

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 
 * @param intervals Interval类一维数组 
 * @return Interval类一维数组
 */
export function merge(intervals: Interval[]): Interval[] {
    intervals.sort((a, b) => a.start == b.start ? a.end - b.end : a.start - b.start);

    const result: Interval[] = [];

    let start: number = -1;
    let end: number = -1;
    for (const interval of intervals) {
        if(interval.start <= end) {
            end = Math.max(end, interval.end);
            continue;
        }

        if(start >= 0 && end >= 0) result.push(new Interval(start, end));

        start = interval.start;
        end = interval.end;
    }

    if(start >= 0 && end >= 0) result.push(new Interval(start, end));

    return result;
}
