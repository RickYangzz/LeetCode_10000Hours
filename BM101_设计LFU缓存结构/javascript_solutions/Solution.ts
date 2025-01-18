class Node {
    key: number;
    val: number;
    freq: number;

    constructor(_key: number, _val: number) {
        this.key = _key;
        this.val = _val;
        this.freq = 1;
    }
}

let mainMap: Map<number, Node>;
let frequency: Map<number, Array<Node>>;
let minFrequency: number;
let capacity: number;

/**
 * 一个缓存结构需要实现如下功能。
 * set(key, value)：将记录(key, value)插入该结构
 * get(key)：返回key对应的value值
 * 但是缓存结构中最多放K条记录。
 * 如果新的第K+1条记录要加入，就需要根据策略删掉一条记录，然后才能把新记录加入。
 * 
 * 这个策略为：
 * 在缓存结构的K条记录中，哪一个key从进入缓存结构的时刻开始，被调用set或者get的次数最少，就删掉这个key的记录；
 * 如果调用次数最少的key有多个，上次调用发生最早的key被删除
 * 这就是LFU缓存替换算法。实现这个结构，K作为参数给出
 *
 * lfu design
 * @param operators int整型二维数组 ops
 * @param k int整型 the k
 * @return int整型一维数组
 */
export function LFU(operators: number[][], k: number): number[] {
    if(operators == null || operators.length == 0 || k == 0){
        return [];
    } 

    mainMap = new Map<number, Node>();
    frequency = new Map<number, Array<Node>>();
    minFrequency = 0;
    capacity = k;

    const result: number[] = [];
    for (const opt of operators) {
        if (opt[0] == 1) set(opt[1], opt[2]);
        if (opt[0] == 2) result.push(get(opt[1]));
    }
    return result;
}

export function set(key: number, value: number): void {
    if (!mainMap.has(key)) {
        // 第一次插入
        const target = new Node(key, value);
        insertMainMap(target);
        insertFrequency(target);
        minFrequency = 1;
    } else {
        // 第n次插入
        const target = mainMap.get(key);
        if (!target) throw new Error("mainMap data error");
        target.val = value;
        
        mainMap.set(target.key, target);
        updateFrequency(target);
    }
}

export function get(key: number): number {
    if (mainMap.has(key)) {
        const target = mainMap.get(key);
        if (!target) throw new Error("mainMap 数据异常");

        updateFrequency(target);
        return target.val;
    }

    return -1;
}

function insertMainMap(target: Node) {
    if (mainMap.size < capacity) {
        mainMap.set(target.key, target);
    } else {
        deleteLFU();
        mainMap.set(target.key, target);
    }
}

function deleteLFU() {
    const arr: Array<Node> = frequency.get(minFrequency);
    if (!arr) throw new Error("frequency data error");
    const target = arr.shift();

    if (arr.length == 0) {
        frequency.delete(minFrequency);
    }

    mainMap.delete(target.key);
}

function updateFrequency(target: Node) {
    // 移除旧的链接
    let arr: Array<Node> = frequency.get(target.freq);
    if (!arr) throw new Error("frequency 数据异常");
    const index = arr.indexOf(target);
    if (index > -1) {
        arr.splice(index, 1);
    }

    if (arr.length == 0 && target.freq == minFrequency) {
        minFrequency++;
    }

    target.freq++;

    // 建立新的链接
    insertFrequency(target);
}

function insertFrequency(target: Node): void {
    let newArr: Array<Node> | undefined;

    if (frequency.has(target.freq)) {
        newArr = frequency.get(target.freq);
        if (!newArr) throw new Error("frequency data error");
    } else {
        newArr = new Array<Node>();
    }

    newArr.push(target);
    frequency.set(target.freq, newArr);
}
