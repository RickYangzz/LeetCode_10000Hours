function canFinish(numCourses: number, prerequisites: number[][]): boolean {
    const adjacencyList: number[][] = new Array(numCourses);
    const indegree = new Array(numCourses).fill(0);
    const ans = new Array();

    for (const pair of prerequisites) {
        const course = pair[0];
        const pre = pair[1];
        if(adjacencyList[pre] == null){
            adjacencyList[pre] = new Array();
        }
        adjacencyList[pre].push(course);
        indegree[course] += 1;
    }

    const queue: number[] = [];
    for (let i = 0; i < indegree.length; i++) {
        if(indegree[i] == 0){
            queue.push(i);
        }
    }

    while(queue.length > 0){
        const current: number = queue.shift() || 0;
        ans.push(current);

        if(adjacencyList[current] == null) continue;
        for (const node of adjacencyList[current]) {
            indegree[node] -= 1;

            if(indegree[node] == 0){
                queue.push(node);
            }
        }
    }

    return ans.length == numCourses;
};