/*
1342. Number of Steps to Reduce a Number to Zero
*/
    
function numberOfSteps(num: number): number {
    if (num < 1) {
        return num;
    }
    else if (num % 2 == 0) {
        return 1 + numberOfSteps(num / 2);
    }
    else {
        return 1 + numberOfSteps(num - 1);
    }
};