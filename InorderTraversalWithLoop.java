/* 
Trees: Is This a Binary Search Tree?
Note: A binary tree is not a binary search if there are duplicate values.
Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
    boolean getInorderNode(Node root) {
        if(root==null) return true;
        Stack<Node> stack = new Stack<Node>();
        Node node = root;
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
        int current = Integer.MIN_VALUE;
        while(stack.size() > 0) {
            node = stack.pop();
            if(current>=node.data) return false;
            current = node.data;
            if(node.right !=null) {
                node = node.right;
                while(node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        return true;
    }
    boolean checkBST(Node root) {
        return getInorderNode(root);
    }
