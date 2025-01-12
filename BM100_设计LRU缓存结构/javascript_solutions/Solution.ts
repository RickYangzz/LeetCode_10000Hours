export class Solution {
    size: number;
    map: Object;
    head: Node;
    trail: Node;

    constructor(capacity: number) {
        this.size = capacity;
        this.map = new Object();
        this.head = new Node(-1, -1);
        this.trail = new Node(-1,-1);

        this.head.next = this.trail;
        this.trail.pre = this.head;
    }

    get(key: number): number {
        if(this.map.hasOwnProperty(key)){
            const target = this.map[key];
            this.moveToHead(target);
            return target.value;
        }

        return -1;
    }

    set(key: number, value: number) {
        if(this.map.hasOwnProperty(key)){
            const target = this.map[key];
            target.value = value;
            // 将targetNode移动到链表头部
            this.moveToHead(target);
        }else{
            if(this.size == 0) {
                // 移除掉尾节点
                this.removeTrail();
            }else{
                this.size--;
            }

            const target = new Node(key, value);
            this.map[key] = target;
            // 将target node插入到链表头部
            this.insertToHead(target);
        }
    }

    moveToHead(target: Node): void{
        if(!target.pre || !target.next) throw new Error("链表数据异常");
        // 切断左右连接
        target.pre.next = target.next;
        target.next.pre = target.pre;

        this.insertToHead(target);
    }

    insertToHead(target: Node): void{
        target.pre = this.head;
        target.next = this.head.next;

        if(!this.head.next) throw new Error("链表数据异常");
        this.head.next.pre = target;
        this.head.next = target;
    }

    removeTrail():void{
        const lastNode = this.trail.pre;
        if(!lastNode || !lastNode.pre) throw new Error("链表数据异常");
        lastNode.pre.next = this.trail;
        this.trail.pre = lastNode.pre;

        delete this.map[lastNode.key];
    }
}

class Node {
    key: number;
    value: number;
    pre: Node | null;
    next: Node | null;
    
    constructor(key: number, value: number){
        this.key = key;
        this.value = value;
        this.pre = null;
        this.next = null;
    }
}