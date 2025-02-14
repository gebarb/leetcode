"""290. Word Pattern"""

from itertools import zip_longest


class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        words = s.split(' ')
        # Bijection approach -> both ONTO and ONE-TO-ONE
        # This checks that pattern, unique words, and mapping
        # all have the same count, which guarantees validity
        return len(set(pattern)) == len(set(words)) == len(set(zip_longest(pattern, words)))

        # Iterative approach
        # if not pattern or not s:
        #     return False

        # char_map = {}

        # if len(pattern) != len(words):
        #     return False

        # # Using a set may result in random ordering, must maintain
        # unique = list(dict.fromkeys(words))
        # l = len(unique)
        # mapped = 0
        # for i, c in enumerate(pattern):
        #     if c in char_map:
        #         word = char_map[c]
        #     else:
        #         if mapped > l - 1:
        #             return False
        #         word = unique[mapped]
        #         char_map[c] = word
        #         mapped += 1
        #     if words[i] != word:
        #         return False

        # return True
