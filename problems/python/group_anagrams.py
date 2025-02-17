"""

49. Group Anagrams

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

Constraints:

1 <= strs.length <= 10^4
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.

"""

from collections import defaultdict
from typing import List


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        groups = defaultdict(list)

        for s in strs:
            chars = str(sorted(s))
            groups[chars].append(s)

        return list(groups.values())
