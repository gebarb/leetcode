"""22. Generate Parentheses"""

from typing import List


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        combinations = []

        def dfs(opened, closed, s):
            # If this is a well-formed set of parentheses
            if opened == closed and opened + closed == n * 2:
                # include it
                combinations.append(s)

            # Try adding a new open paren
            if opened < n:
                dfs(opened + 1, closed, s + "(")
            # Try closing the previous paren
            if closed < opened:
                dfs(opened, closed + 1, s + ")")

        dfs(0, 0, "")

        return combinations
