/*
 * 841. Keys and Rooms
 */

class Solution {

  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    boolean[] visited = new boolean[rooms.size()];
    visited[0] = true;
    Stack<Integer> keys = new Stack();
    keys.push(0);

    while (!keys.isEmpty()) {
      int curr_room_keys = keys.pop();
      for (int curr_key : rooms.get(curr_room_keys)) {
        if (!visited[curr_key]) {
          visited[curr_key] = true;
          keys.push(curr_key);
        }
      }
    }

    for (boolean v : visited) {
      if (!v) {
        return false;
      }
    }
    return true;
  }
}
