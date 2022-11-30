/*
 * 1376. Time Needed to Inform All Employees
 */

class Solution {

  public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    // Bottom-Up DFS
    Map<Integer, Integer> times = new HashMap<>();
    int max_time = 0;
    for (int i = 0; i < n; i++) {
      max_time = Math.max(max_time, dfs(i, manager, informTime, times));
    }

    return max_time;
  }

  private int dfs(
    int employee_id,
    int[] manager,
    int[] informTime,
    Map<Integer, Integer> times
  ) {
    if (manager[employee_id] == -1) {
      return 0;
    } else if (times.containsKey(employee_id)) {
      return times.get(employee_id);
    } else {
      times.put(
        employee_id,
        informTime[manager[employee_id]] +
        dfs(manager[employee_id], manager, informTime, times)
      );

      return times.get(employee_id);
    }
  }
}
