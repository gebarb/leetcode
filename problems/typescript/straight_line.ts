/*
 * 1232. Check If It Is a Straight Line
 */

function checkStraightLine(coordinates: number[][]): boolean {
    // For three Points (x0, y0), (x1, y1), (x, y) to be Co-Linear:
    // --> (x - x0) * (y1 - y0) == (y - y0) * (x1 - x0)
    let dx: number = coordinates[1][0] - coordinates[0][0];
    let dy: number = coordinates[1][1] - coordinates[0][1];


    for (const point of coordinates) {
        if ((point[1] - coordinates[1][1]) * dx != (point[0] - coordinates[1][0]) * dy) {
            return false;
        }
    }
    return true;
};