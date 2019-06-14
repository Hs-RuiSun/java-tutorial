package com.ruby.sun.leetcode;

import org.junit.jupiter.api.*;

import java.util.*;

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
//        addTwoNumbers(head, l2);
//        fizzBuzz(15);
        String[] domains = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        subdomainVisits(domains);
    }

    //https://leetcode.com/problems/merge-k-sorted-lists/
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode output = null;
        return output;
    }

    //https://leetcode.com/problems/subdomain-visit-count/
    private Map<String, Integer> map;
    public List<String> subdomainVisits(String[] cpdomains) {
        map = new HashMap<>(cpdomains.length);
        for (String cpdomain : cpdomains){
            int indexOfSpace = cpdomain.indexOf(' ');
            int num = Integer.parseInt(cpdomain.substring(0, indexOfSpace));
            String domains = cpdomain.substring(indexOfSpace + 1);
            addToMap(domains, num);
            int indexOfPeriod;
            while ((indexOfPeriod = domains.indexOf('.')) > -1){
                domains = domains.substring(indexOfPeriod+1);
                addToMap(domains, num);
            }
        }
        List<String> list = new ArrayList<>(map.size());
        for (String domain : map.keySet()) {
            list.add(map.get(domain).toString() + " " + domain);
        }
        return list;
    }
    private void addToMap(String key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value + map.get(key));
        } else {
            map.put(key, value);
        }
    }

    //https://leetcode.com/problems/fizz-buzz/
    public List<String> fizzBuzz(int n) {
        List<String> list = new LinkedList<>();
        list.add("1");
        for(int i=2;i<=n;i++){
            if(i%3==0 && i%5==0){
                list.add("FizzBuzz");
            } else if(i%3 == 0){
                list.add("Fizz");
            } else if(i%5 == 0){
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
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
    //https://leetcode.com/problems/linked-list-cycle-ii/
    public ListNode detectCycle(ListNode head) {
    	ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null) {
        	slow = slow.next;
        	fast = fast.next.next;
        	if(slow == fast) {
        		break;
        	}
        }
        if(fast==null || fast.next==null) return null;
        slow = head;
        while(slow != fast) {
        	slow = slow.next;
        	fast = fast.next;
        }
        return slow;
    }
    //https://leetcode.com/problems/linked-list-cycle/
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null) {
        	slow = slow.next;
        	fast = fast.next.next;
        	if(slow == fast) {
        		return true;
        	}
        }
        return false;
    }
    //https://leetcode.com/problems/remove-duplicates-from-sorted-list/
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode root = head;
        while(root!=null && root.next!=null) {
        	while(root.next!=null && root.val==root.next.val) {
        		root.next = root.next.next;
        	}
        	root = root.next;
        }
        return head;
    }
    //https://leetcode.com/problems/delete-node-in-a-linked-list/
    public void deleteNode(ListNode node) {
    	node.val = node.next.val;
    	node.next = node.next.next;
    }
    //https://leetcode.com/problems/middle-of-the-linked-list/
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null) {
        	if(fast.next == null) {
        		return slow;
        	}
        	slow = slow.next;
        	fast = fast.next;
        	fast = fast.next;
        }
        return slow;
    }
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
