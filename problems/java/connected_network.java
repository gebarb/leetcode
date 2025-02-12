/*
 * 1319. Number of Operations to Make Network Connected
 */

class Solution {

  public int makeConnected(int n, int[][] connections) {
    // To Find # Connection Ops is to Find Number of UN-Connected Components in Graph
    // Where Ops constrained by Number of Cycles in Graph
    // --> Use Disjoint Set Union (Union Find)
    int[] computers = new int[n];
    int unconnected = 0;
    int extra_wires = 0;
    for (int i = 0; i < n; i++) {
      computers[i] = i;
    }
    for (int[] connection : connections) {
      if (union(connection[0], connection[1], computers)) {
        extra_wires++;
      }
    }

    for (int i = 0; i < n; i++) {
      if (find_parent(i, computers) == i) {
        unconnected++;
      }
    }
    return extra_wires >= unconnected - 1 ? unconnected - 1 : -1;
  }

  boolean union(int a, int b, int[] c) {
    if (find_parent(a, c) != find_parent(b, c)) {
      c[c[a]] = c[b];
      return false;
    } else {
      return true;
    }
  }

  int find_parent(int a, int[] b) {
    if (b[a] != a) {
      b[a] = find_parent(b[a], b);
    }
    return b[a];
  }
}
