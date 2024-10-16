class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Create an adjacency list and an array for in-degrees
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph and fill in-degrees
        for (int[] prereq : prerequisites) {
            graph.get(prereq[1]).add(prereq[0]);
            inDegree[prereq[0]]++;
        }

        // Step 2: Initialize the queue with all courses having zero in-degrees
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Step 3: Process the queue
        int count = 0; // Count of courses that have been processed
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;

            // Decrease the in-degree of neighboring courses
            for (int neighbor : graph.get(course)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Step 4: If count equals numCourses, return true; otherwise false
        return count == numCourses;
    }
}