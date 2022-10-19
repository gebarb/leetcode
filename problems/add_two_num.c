/*
 * 2. Add Two Numbers
 */

#include <stddef.h>

// Definition for singly-linked list.
struct ListNode
{
    int val;
    struct ListNode *next;
};

struct ListNode *addTwoNumbers(struct ListNode *l1, struct ListNode *l2)
{
    struct ListNode *one = l1, *two = l2;
    struct ListNode *ret = NULL, *curr = NULL;
    int remainder = 0;
    while (one != NULL || two != NULL || remainder != 0)
    {
        struct ListNode *digit = malloc(sizeof(struct ListNode));
        int x = (one != NULL) ? one->val : 0;
        int y = (two != NULL) ? two->val : 0;
        int sum = (remainder + x + y) % 10;
        remainder = (remainder + x + y) / 10;
        digit->val = sum;
        digit->next = NULL;
        if (ret == NULL)
        {
            ret = curr = digit;
        }
        else
        {
            curr->next = digit;
            curr = digit;
        }
        if (one != NULL)
            one = one->next;
        if (two != NULL)
            two = two->next;
    }
    return ret;
}