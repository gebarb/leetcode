/*
* 1557. Minimum Number of Vertices to Reach All Nodes
*/

function findSmallestSetOfVertices(n: number, edges: number[][]): number[] {
    // Directed Acyclic Graph
    // --> Nodes with degree_in == 0 cannot be reach by any other nodes
    // ---> Hence result set of origin nodes
    const nodes: Set<number> = new Set([...Array(n)].map((_, i) => i));
    for (const edge of edges) {
        // Since Node's degree_in is now >0, remove it from result sert
        nodes.delete(edge[1]);
    }

    return Array.from(nodes);
};