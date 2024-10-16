class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph
        for (int[] prereq : prerequisites) {
            graph.get(prereq[1]).add(prereq[0]);
        }

        // Create an array to track visited nodes and recursion stack
        boolean[] visited = new boolean[numCourses];
        boolean[] inRecStack = new boolean[numCourses];

        // Perform DFS for each course
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (hasCycle(graph, visited, inRecStack, i)) {
                    return false; // Cycle detected
                }
            }
        }
        
        return true; // No cycles detected
    }

    private boolean hasCycle(List<List<Integer>> graph, boolean[] visited, boolean[] inRecStack, int course) {
        visited[course] = true;
        inRecStack[course] = true;

        for (int neighbor : graph.get(course)) {
            if (!visited[neighbor]) {
                if (hasCycle(graph, visited, inRecStack, neighbor)) {
                    return true;
                }
            } else if (inRecStack[neighbor]) {
                return true; // Cycle detected
            }
        }

        inRecStack[course] = false; // Remove from recursion stack
        return false;
    }
}