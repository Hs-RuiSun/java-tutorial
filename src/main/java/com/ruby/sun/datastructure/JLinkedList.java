package com.ruby.sun.datastructure;

import org.junit.Test;

import java.util.List;

//https://leetcode.com/tag/linked-list/
public class JLinkedList {
    @Test
    public void test(){
        ListNode head = new ListNode(9);
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        ListNode l2 = new ListNode(9);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(9);
        head.next = node1;
        node1.next = node2;
        l2.next = node3;
        node3.next = node4;
        addTwoNumbers(head, l2);
    }

    //https://leetcode.com/problems/merge-k-sorted-lists/
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode output = null;
        return output;
    }

    //https://leetcode.com/problems/add-two-numbers/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode output = null;
        ListNode root = null;
        int sum = 0;
        while (l1!=null && l2!=null){
            sum = sum/10 + l1.val + l2.val;
            if(root == null){
                root = new ListNode(sum % 10);
                output = root;
            } else {
                root.next = new ListNode(sum % 10);
                root = root.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 != null){
            while (l1 != null){
                sum = sum/10 + l1.val;
                root.next = new ListNode(sum % 10);
                root = root.next;
                l1 = l1.next;
            }
        }
        if(l2 != null){
            while (l2 != null){
                sum = sum/10 + l2.val;
                root.next = new ListNode(sum % 10);
                root = root.next;
                l2 = l2.next;
            }
        }
        if(sum/10 != 0){
            root.next = new ListNode(sum/10);
        }
        return output;
    }

    /**
     * Input: 1->2->3->4->5->NULL, m = 2, n = 4
     * Output: 1->4->3->2->5->NULL*/
    //https://leetcode.com/problems/reverse-linked-list-ii/
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null || head.next == null) return head;
        ListNode root = head;
        int i = 0;
        ListNode start = null;
        while (i < m-1){
            start = root;
            root = root.next;
            i++;
        }
        ListNode last = root;
        root = root.next;
        ListNode next = root.next;
        while (i < n-1){
            root.next = last;
            if(next != null){
                last = root;
                root = next;
                next = root.next;
            }else {
                last.next = null;
            }
            i++;
        }
        if(start != null){
            start.next.next = next;
            start.next = root;
        }
        return head;
    }

    //https://leetcode.com/problems/reverse-linked-list/
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next == null) return head;
        ListNode last = head;
        head = head.next;
        ListNode next = head.next;
        last.next = null;
        while (next != null){
            head.next = last;
            last = head;
            head = next;
            next = head.next;
        }
        head.next = last;
        return head;
    }

    //https://leetcode.com/problems/palindrome-linked-list/
    public boolean isPalindrome(ListNode head) {
        return false;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
