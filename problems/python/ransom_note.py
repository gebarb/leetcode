"""LeetCode 383. Ransom Note"""

from collections import Counter


class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        freq_mag = Counter(magazine)
        freq_note = Counter(ransomNote)
        for key in freq_note:
            if freq_note[key] > freq_mag[key]:
                return False
        return True
