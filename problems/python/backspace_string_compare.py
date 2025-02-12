"""Backspace s Compare"""


class Solution:
    def removeBackspace(self, s):
        ret = []
        for i in s:
            if i != "#":
                ret.append(i)
            else:
                if len(ret):
                    ret.pop()
        return "".join(ret)

    def backspaceCompare(self, s: str, t: str) -> bool:
        return self.removeBackspace(s) == self.removeBackspace(t)
