"""50. Pow(x, n)"""


class Solution:
    def myPow(self, x: float, n: int) -> float:
        power = self.calcPower(x, abs(n))

        if n >= 0:
            return power

        return 1 / power

    def calcPower(self, x, n):
        """ 
            Using properties of exponents
            x^n = (x^(n/2))^2
            reduces the total number of iterations
        """
        if x == 0:
            return 0
        if n == 0:
            return 1

        power = self.calcPower(x, n // 2)
        power = power * power

        if n % 2 == 1:
            return power * x

        return power
