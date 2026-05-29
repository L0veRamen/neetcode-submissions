# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        size = 0
        cur = head
        while cur:
            size += 1
            cur = cur.next
        
        slow = dummy
        for _ in range(size - n):
            slow = slow.next
        slow.next = slow.next.next
        return dummy.next
