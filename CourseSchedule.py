from typing import List

class CourseSchedule:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        adjList = []
        for i in range(numCourses):
            adjList.append([])
        for prerequisite in prerequisites:
            adjList[prerequisite[0]].append(prerequisite[1])
        return not self.dfs(adjList, numCourses)

    def dfs(self, adjList, numCourses):
        visited = []
        recStack = []
        for i in range(numCourses):
            visited.append(False)
            recStack.append(False)
        for i in range(numCourses):
            if not visited[i]:
                if self.dfsRec(adjList, i, visited, recStack):
                    return True
        return False
    
    def dfsRec(self, adjList, curr, visited, recStack):
        visited[curr] = True
        recStack[curr] = True
        for neighbour in adjList[curr]:
            if (not visited[neighbour]) and self.dfsRec(adjList, neighbour, visited, recStack):
                return True
            elif recStack[neighbour]:
                return True
        recStack[curr] = False
        return False