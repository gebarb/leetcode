/*
* 509. Fibonacci Number
*/

function fib(n: number): number {
    // use Binet's Formula
    return (((1 + Math.sqrt(5)) / 2) ** n - ((1 - Math.sqrt(5)) / 2) ** n) / Math.sqrt(5);
};