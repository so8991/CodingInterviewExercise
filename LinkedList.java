/* package whatever; // don't place package name! */

import java.util.*;
class Node {
    int val;
    Node next;
    public Node (int value) {
        val = value;
        next = null;
    }
}
class LinkedList {
    public Node add(Node head, int val) {
        Node n = head;
        while(n.next != null) {
            n = n.next;
        }
        n.next = new Node(val);
        return head;
    }
    public Node delete(Node head, int val) {
        Node n = head;
        if(head.val == val) {
            return head.next;
        }
        while(n.next != null) {
            if(n.next.val==val) {
                n.next = n.next.next;
            }
            n = n.next;
        }
        return head;
    }
    public void print(Node head) {
        Node n = head;
        while(n != null) {
            System.out.print(n.val+"->");
            n = n.next;
        }
        System.out.println("null");
    }
    public Node removeDuplicatesWithBuffer(Node head) {
        HashSet<Integer> set = new HashSet<>();
        Node n = head;
        if(n!=null)    
           set.add(n.val);
        while(n!=null && n.next != null) {
            if(set.contains(n.next.val)) {
                n.next = n.next.next;
            } else {
                set.add(n.next.val);
            }
            n = n.next;
        }
        return head;
    }
    public Node removeDuplicateWithoutBuffer(Node head) {
        Node n = head;
        Node runner = null;
        while(n != null) {
            runner = n;
            while(runner != null && runner.next != null) {
                if(n.val == runner.next.val) {
                    runner.next = runner.next.next;
                }
                runner = runner.next;
            }
            n = n.next;
        }
        return head;
    }
    public Node returnKthToLast1(Node head, int k) {
        int count = 0;
        Node n = head;
        while(n!=null) {
            count++;
            n = n.next;
        }
        if(count <= k) {
            return null;
        }
        n = head;
        for(int i=0; i<count-k; i++) {
            n = n.next;
        }
        return n;
    }
    public void returnKthToLast2(Node head, int k) {
        System.out.println(returnKthToLast2(head, k, k+1).val);
    }
    //int idx=0;
    public Node returnKthToLast2(Node n, int k, int count) {
        if(n==null) return null;
        //if(count==k) return n;
        
        Node back = returnKthToLast2(n.next, k, count-1);
        //System.out.println(n.val+" "+count);
        if(count+1==k) return n;
        return back;
        //return back;
    }
    public Node returnKthToLast3(Node head, int k) {
        Node n = head;
        Node runner = head;
        while(n != null) {
            runner = n;
            for(int i=0; i<k; i++) {
                if(runner==null) return null;
                runner = runner.next;
            }
            if(runner==null) {
                return n;
            }
            n = n.next;
        }
        return n;
    }
    public Node deleteMiddleNode(Node head) {
        Node n = head;
        Node runner = n;
        while(runner.next!=null &&runner.next.next != null && runner.next.next.next != null) {
            n = n.next;
            runner = runner.next.next;
        }
        n.next= n.next.next;
        return head;
    }
    public Node reverse(Node head) {
        Node rev = null;
        Node current = head;
        //Node n = head;
        while(current!= null) {
            Node n = new Node(current.val);
            //Node next = n.next;
            //n.next = rev;
            n.next = rev;
            rev = n;
            current = current.next;
            //n = next;
        }
        return rev;
    }
    public boolean isPalindrome(Node head) {
        Node n = head;
        print(head);
        Node rev = reverse(n);
        print(head);
        print(rev);
        while(n != null) {
            if(rev.val != n.val) return false;
            n = n.next;
            rev = rev.next;
        }
        return true;
    }
    public boolean isPalindromeWithStack(Node head) {
        Node n = head;
        Node fast = head;
        Stack<Node> stack = new Stack<>();
        while(fast.next != null && fast.next.next != null) {
            stack.push(n);
            n = n.next;
            fast = fast.next.next;
        }
        if(fast.next ==null) n = n.next;
        else {
            stack.push(n);
            n = n.next;
        }
        
        while(n!=null) {
            Node first = stack.pop();
            System.out.println(n.val + " " + first.val);
            if(first.val != n.val) return false;
            n = n.next;
        }
        return true;
        
    }
    
    public int length(Node head) {
        Node n = head;
        int len = 0;
        while(n!=null) {
            len++;
            n = n.next;
        }
        return len;
    }
    
}

class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Node head = new Node(3);
        LinkedList ll = new LinkedList();
        head = ll.add(head, 4);
        head = ll.add(head, 6);
        head = ll.add(head, 4);
        head = ll.add(head, 6);
        head = ll.add(head, 4);
        head = ll.add(head, 3);
        //ll.print(head);
        //head = ll.removeDuplicateWithoutBuffer(head);
        //head = ll.deleteMiddleNode(head);
        ll.print(head);
        
    }
}
