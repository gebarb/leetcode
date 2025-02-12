"""58. Length of Last Word"""


class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        # return len(s.split()[-1])

        l = 0
        counting = False

        # Iterate through string
        for c in s:
            # As find beginning of a new word
            if c != " ":
                # Start counting length
                if not counting:
                    counting = True
                    length = 1
                else:
                    length += 1
            else:
                counting = False

        # Most-recent length value is the last word's length
        return length
