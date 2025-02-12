"""20. Valid Parentheses"""


import collections


class Solution:
    def isValid(self, s: str) -> bool:
        if (len(s) % 2 != 0):
            return False
        else:
            stack = collections.deque([])
            for i in range(len(s)):
                if s[i] == "(" or s[i] == "{" or s[i] == "[":
                    stack.append(s[i])
                else:
                    if stack:
                        last = stack.pop()
                        if (last == "(" and s[i] == ")") or (last == "{" and s[i] == "}") or (last == "[" and s[i] == "]"):
                            continue
                        else:
                            return False
                    else:
                        return False
            return len(stack) == 0
