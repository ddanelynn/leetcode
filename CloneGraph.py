
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

class CloneGraph:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return None
        
        visited = {node: Node(node.val)}
        q = [node]
        
        while q:
            currNode = q.pop()
            for neighbor in currNode.neighbors:
                if neighbor not in visited:
                    visited[neighbor] = Node(neighbor.val)
                    q.append(neighbor)
                visited[currNode].neighbors.append(visited[neighbor])
        
        return visited.get(node)