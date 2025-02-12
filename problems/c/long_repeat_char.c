/*
 * 424. Longest Repeating Character Replacement
 */

int characterReplacement(char *s, int k)
{
    int char_map[26] = {0};
    int i, max, start, end;

    max = start = end = 0;

    while (s[end])
    {
        i = s[end++] - 'A';
        char_map[i]++;
        max = max > char_map[i] ? max : char_map[i];
        if (end - start > max + k)
        {
            i = s[start++] - 'A';
            char_map[i]--;
        }
    }

    return end - start;
}