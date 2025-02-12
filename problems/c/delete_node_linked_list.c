/*
237. Delete Node in a Linked List
 */

// Definition for singly-linked list.
struct ListNode
{
    int val;
    struct ListNode *next;
};

void deleteNode(struct ListNode *node)
{
    *node = *node->next;
}