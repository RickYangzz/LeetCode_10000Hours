export function maxLength(arr: number[]): number {
    let maxLength = 0;

    const deque = new Array();

    for (const value of arr) {
        while(deque.includes(value)) {
            deque.shift();
        }
        
        deque.push(value);

        maxLength = Math.max(maxLength, deque.length);
    }

    return maxLength;
}
