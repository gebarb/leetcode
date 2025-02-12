/*
 * 746. Min Cost Climbing Stairs
 */

int minCostClimbingStairs(int *cost, int costSize)
{
    int *ptr = calloc(costSize, sizeof(int));

    ptr[0] = cost[0];
    ptr[1] = cost[1];
    for (int i = 2; i < costSize; i++)
    {
        ptr[i] = (ptr[i - 2] > ptr[i - 1]) ? ptr[i - 1] + cost[i] : ptr[i - 2] + cost[i];
    }
    int min_cost = (ptr[costSize - 2] > ptr[costSize - 1]) ? ptr[costSize - 1] : ptr[costSize - 2];
    free(ptr);
    return min_cost;
}