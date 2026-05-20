class Solution {

    private Map<Integer, List<Integer>> adjList = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();
    private Set<Integer> cycle = new HashSet<>();
    private List<Integer> output = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            adjList.get(prereq[0]).add(prereq[1]);
        }
        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c)) {
                return new int[0];
            }
        }
        int[] res = new int[output.size()];
        for (int i = 0; i < output.size(); i++) {
            res[i] = output.get(i);
        }
        return res;
    }

    public boolean dfs(int course) {
        if (cycle.contains(course)) {
            return false;
        }
        if (visited.contains(course)) {
            return true;
        }

        cycle.add(course);
        for (int prereq : adjList.get(course)) {
            if (!dfs(prereq)) {
                return false;
            }
        }
        cycle.remove(course);
        visited.add(course);
        output.add(course);
        return true;
    }
}
