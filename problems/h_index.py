"""274. H-Index"""

from typing import List


class Solution:
    def hIndex(self, citations: List[int]) -> int:
        papers = len(citations)
        # Build count for each number of citations
        # counts = [0] * (papers + 1)
        # for c in citations:
        # Since H-Index is at least h papers cited h times, only need min
        # counts[min(c, papers)] +=  1

        # h = 0
        # Iterate in reverse to determine maximum
        # for i in range(papers, -1, -1):
        #     h += counts[i]
        #     if h >= i:
        #         return i

        citations.sort()
        for i, c in enumerate(citations):
            # Since citations is sorted,
            # papers - i is number of papers cited more than c times
            if c >= papers - i:
                return papers - i

        return 0
