"""76. Minimum Window Substring"""


import collections


class Solution:

    def minWindow(self, s, t):
        char_map = collections.Counter(t)
        num_chars = len(t)
        start, end = 0, 0
        curr_char = 0
        for i, char in enumerate(s, 1):
            if char_map[char] > 0:
                num_chars -= 1
            char_map[char] -= 1
            if num_chars == 0:
                while curr_char < i and char_map[s[curr_char]] < 0:
                    char_map[s[curr_char]] += 1
                    curr_char += 1
                char_map[s[curr_char]] += 1
                num_chars += 1
                if end == 0 or i-curr_char < end-start:
                    start, end = curr_char, i
                curr_char += 1
        return s[start:end]
