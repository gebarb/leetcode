/*
 * 797. All Paths From Source to Target
 */
class Solution {

  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    // Directed Acyclic Graph
    List<List<Integer>> paths = new ArrayList<>();
    List<Integer> curr_path = new ArrayList<>();
    curr_path.add(0);
    dfs(graph, paths, curr_path, 0);
    return paths;
  }

  public void dfs(
    int[][] graph,
    List<List<Integer>> paths,
    List<Integer> curr_path,
    int start
  ) {
    if (start == graph.length - 1) {
      paths.add(new ArrayList<>(curr_path));
      return;
    }

    for (int i : graph[start]) {
      curr_path.add(i);
      dfs(graph, paths, curr_path, i);
      curr_path.remove(curr_path.size() - 1);
    }
  }
}
