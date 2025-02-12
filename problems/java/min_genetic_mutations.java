/*
 * 433. Minimum Genetic Mutation
 */

class Solution {

  // Treat problem as BFS on graph where:
  //  Nodes = Genes
  //  Edges = Mutations
  public int minMutation(String start, String end, String[] bank) {
    Queue<String> genes = new LinkedList<>();
    Set<String> visited_genes = new HashSet<>();
    genes.add(start);
    visited_genes.add(start);

    int mutations = 0;

    while (!genes.isEmpty()) {
      int path_length = genes.size();
      for (int j = 0; j < path_length; j++) {
        String gene = genes.remove();
        if (gene.equals(end)) {
          return mutations;
        }

        for (char c : new char[] { 'A', 'C', 'G', 'T' }) {
          for (int i = 0; i < gene.length(); i++) {
            String next_gene = gene.substring(0, i) + c + gene.substring(i + 1);
            if (
              !visited_genes.contains(next_gene) &&
              Arrays.asList(bank).contains(next_gene)
            ) {
              genes.add(next_gene);
              visited_genes.add(next_gene);
            }
          }
        }
      }

      mutations++;
    }

    return -1;
  }
}
