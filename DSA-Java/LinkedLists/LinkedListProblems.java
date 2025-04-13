class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListProblems {
    
    // 1. Basic Operations
    
    // Create a linked list from array
    public static ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        
        return head;
    }
    
    // Print linked list
    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    // 2. Reverse Linked List
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
    
    // 3. Detect Cycle in Linked List
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) return true;
        }
        
        return false;
    }
    
    // 4. Find Middle of Linked List
    public static ListNode findMiddle(ListNode head) {
        if (head == null) return null;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    // 5. Merge Two Sorted Lists
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        
        current.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
    
    // 6. Remove Nth Node From End
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        // Move fast n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        // Move both pointers until fast reaches end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // Remove the nth node
        slow.next = slow.next.next;
        return dummy.next;
    }
    
    // 7. Add Two Numbers
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        
        return dummy.next;
    }
    
    // 8. Intersection of Two Linked Lists
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        ListNode a = headA;
        ListNode b = headB;
        
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        
        return a;
    }
    
    // 9. Palindrome Linked List
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        // Find middle
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse second half
        ListNode secondHalf = reverseList(slow);
        ListNode firstHalf = head;
        
        // Compare both halves
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        
        return true;
    }
    
    // 10. Remove Duplicates from Sorted List
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        
        return head;
    }
    
    public static void main(String[] args) {
        // Test cases
        
        // 1. Create and print linked list
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = createLinkedList(arr);
        System.out.println("Original List:");
        printLinkedList(head);
        
        // 2. Reverse linked list
        ListNode reversed = reverseList(head);
        System.out.println("\nReversed List:");
        printLinkedList(reversed);
        
        // 3. Create cycle and detect it
        ListNode cycleHead = createLinkedList(new int[]{1, 2, 3, 4, 5});
        cycleHead.next.next.next.next.next = cycleHead.next; // Create cycle
        System.out.println("\nHas Cycle: " + hasCycle(cycleHead));
        
        // 4. Find middle
        ListNode middleList = createLinkedList(new int[]{1, 2, 3, 4, 5});
        System.out.println("\nMiddle Node: " + findMiddle(middleList).val);
        
        // 5. Merge two sorted lists
        ListNode l1 = createLinkedList(new int[]{1, 3, 5});
        ListNode l2 = createLinkedList(new int[]{2, 4, 6});
        System.out.println("\nMerged List:");
        printLinkedList(mergeTwoLists(l1, l2));
        
        // 6. Remove nth from end
        ListNode removeNth = createLinkedList(new int[]{1, 2, 3, 4, 5});
        System.out.println("\nAfter removing 2nd from end:");
        printLinkedList(removeNthFromEnd(removeNth, 2));
        
        // 7. Add two numbers
        ListNode num1 = createLinkedList(new int[]{2, 4, 3});
        ListNode num2 = createLinkedList(new int[]{5, 6, 4});
        System.out.println("\nSum of two numbers:");
        printLinkedList(addTwoNumbers(num1, num2));
        
        // 8. Intersection of two lists
        ListNode common = createLinkedList(new int[]{8, 9, 10});
        ListNode listA = createLinkedList(new int[]{1, 2, 3});
        listA.next.next.next = common;
        ListNode listB = createLinkedList(new int[]{4, 5});
        listB.next.next = common;
        System.out.println("\nIntersection Node: " + getIntersectionNode(listA, listB).val);
        
        // 9. Check palindrome
        ListNode palindrome = createLinkedList(new int[]{1, 2, 3, 2, 1});
        System.out.println("\nIs Palindrome: " + isPalindrome(palindrome));
        
        // 10. Remove duplicates
        ListNode duplicates = createLinkedList(new int[]{1, 1, 2, 3, 3});
        System.out.println("\nAfter removing duplicates:");
        printLinkedList(deleteDuplicates(duplicates));
    }
} 