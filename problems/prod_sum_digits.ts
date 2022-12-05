/*
* 1281. Subtract the Product and Sum of Digits of an Integer
*/

function subtractProductAndSum(n: number): number {
    let product: number = 1;
    let sum: number = 0;

    while (n > 0) {
        product *= n % 10;
        sum += n % 10;
        n = Math.floor(n / 10);
    }
    return product - sum;
};