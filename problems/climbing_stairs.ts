/*
* 70. Climbing Stairs
*/

function climbStairs(n: number): number {
    // Can only climb 1 OR 2 steps each time
    // -> f(n) = (n - 1) + (n - 2)
    // --> Fibonacci Sequence, use Binet's Formula (+1)
    return Math.floor((((1 + Math.sqrt(5)) / 2) ** (n + 1) - ((1 - Math.sqrt(5)) / 2) ** (n + 1)) / Math.sqrt(5));
};