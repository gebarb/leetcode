/*
 * 1491. Average Salary Excluding the Minimum and Maximum Salary
 */

function average(salary: number[]): number {
    let min: number = salary[0] > salary[1] ? salary[1] : salary[0];
    let max: number = salary[0] > salary[1] ? salary[0] : salary[1];
    let sum: number = 0;

    // Assume all vals in salary are unique
    for (const sal of salary) {
        min = Math.min(min, sal);
        max = Math.max(max, sal);
        sum += sal;
    }
    return (sum - min - max) / (salary.length - 2);
};