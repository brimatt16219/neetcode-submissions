class Solution {

    private Map<Integer, List<Integer>> premap = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            premap.put(i, new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            premap.get(prereq[0]).add(prereq[1]);
        }
        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int course) {
        if (visited.contains(course)) {
            return false;
        }
        if (premap.get(course).isEmpty()) {
            return true;
        }

        visited.add(course);
        for (int pre : premap.get(course)) {
            if (!dfs(pre)) {
                return false;
            }
        }

        visited.remove(course);
        premap.put(course, new ArrayList<>());
        return true;
    }
}
