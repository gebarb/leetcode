"""299. Bulls and Cows"""

from collections import defaultdict


class Solution:
    def getHint(self, secret: str, guess: str) -> str:
        secret_char_map, guess_char_map = defaultdict(int), defaultdict(int)
        bulls = cows = 0
        for s, g in zip(secret, guess):
            if s == g:
                bulls += 1
            else:
                secret_char_map[s] += 1
                guess_char_map[g] += 1
        for i in secret_char_map.keys():
            if i in guess_char_map:
                cows += min(secret_char_map[i], guess_char_map[i])
        return "%sA%sB" % (bulls, cows)
