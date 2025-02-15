class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        adjacencyList = [None] * numCourses
        indegree = [0] * numCourses
        ans = []

        for pair in prerequisites:
            course = pair[0]
            pre = pair[1]
            if adjacencyList[pre] == None:
                adjacencyList[pre] = []
            adjacencyList[pre].append(course)
            indegree[course] += 1

        queue = []
        for i in range(len(indegree)):
            if indegree[i] == 0:
                queue.append(i)
        
        while queue:
            current = queue.pop(0)
            ans.append(current)

            if not adjacencyList[current]: continue

            for node in adjacencyList[current]:
                indegree[node] -= 1
                if indegree[node] == 0:
                    queue.append(node)
        
        return len(ans) == numCourses
        

