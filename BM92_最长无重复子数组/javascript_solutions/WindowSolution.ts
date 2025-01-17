export function maxLength(arr: number[]): number {
    let maxLength = 0;

    const map = new Object();

    for (let left =0, right = 0; right < arr.length; right++) {
        const element = arr[right];
        
        if(map[element]){
            map[element]++
        }else{
            map[element] = 1
        }

        while(map[element] > 1) {
            const leftValue = arr[left];
            map[leftValue]--;
            left++;
        }

        const currentLength = right - left + 1;

        maxLength = maxLength > currentLength ?  maxLength : currentLength;
    }

    return maxLength;
}
