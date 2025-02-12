/*
 * 62. Unique Paths
 */

int uniquePaths(int m, int n)
{
    int *ptr = malloc(n);
    ptr[0] = 1;
    for (int i = 0; i < m; i++)
    {
        for (int j = 1; j < n; j++)
        {
            ptr[j] += ptr[j - 1];
        }
    }
    return ptr[n - 1];
}