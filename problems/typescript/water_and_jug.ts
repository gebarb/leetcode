/*
* 365. Water and Jug Problem
*/

// Number Theory!!!
function canMeasureWater(jug1Capacity: number, jug2Capacity: number, targetCapacity: number): boolean {
    // Bézout's identity — Let a and b be integers with greatest common divisor d
    // -> Then there exist integers x and y such that ax + by = d
    // --> Moreover, the integers of the form az + bt are exactly the multiples of d

    if (jug1Capacity + jug2Capacity < targetCapacity) {
        return false;
    }

    else if ((jug1Capacity == targetCapacity) || (jug2Capacity == targetCapacity) || (jug1Capacity + jug2Capacity == targetCapacity)) {
        return true;
    }

    return (targetCapacity % gcd(jug1Capacity, jug2Capacity)) == 0;
};

function gcd(a: number, b: number): number {
    let tmp: number;
    while (b != 0) {
        tmp = b;
        b = a % b;
        a = tmp;
    }
    return a;
};