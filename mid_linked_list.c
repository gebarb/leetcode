/*
876. Middle of the Linked List
 */

#include <stddef.h>

// Definition for singly-linked list.
struct ListNode
{
    int val;
    struct ListNode *next;
};

struct ListNode *middleNode(struct ListNode *head)
{
    struct ListNode *ptr, *snail;
    ptr = snail = head;
    while (ptr != NULL && ptr->next != NULL)
    {
        ptr = ptr->next->next;
        snail = snail->next;
    }
    return snail;
}