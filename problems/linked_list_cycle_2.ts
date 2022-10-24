/*
* 142. Linked List Cycle II
*/

// Definition for singly-linked list.
class ListNode {
    val: number
    next: ListNode | null
    constructor(val?: number, next?: ListNode | null) {
        this.val = (val === undefined ? 0 : val)
        this.next = (next === undefined ? null : next)
    }
}


function detectCycle(head: ListNode | null): ListNode | null {
    let ptr: ListNode | null, snail: ListNode | null | undefined;
    ptr = snail = head;

    while (ptr != null && ptr.next != null) {
        ptr = ptr.next.next;
        snail = snail?.next;

        if (ptr == snail) {
            let cycle: ListNode | null | undefined = head;
            while (cycle != snail) {
                snail = snail?.next;
                cycle = cycle?.next;
            }
            if (snail != undefined)
                return snail;
        }
    }
    return null;

};


