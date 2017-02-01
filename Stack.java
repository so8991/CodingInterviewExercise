/* package whatever; // don't place package name! */

import java.util.*;
class MyStack<T> {
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;
        public StackNode(T data) {
            this.data = data;
        }
    }
    private StackNode<T> top;
    // pop
    public T pop(){
        if(top==null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        return item;
    }
    // push (item)
    public void push(T data) {
        StackNode<T> newTop = new StackNode<T>(data);
        newTop.next = top;
        top = newTop;
    }
    // peek
    public T peek() {
        if(top==null) throw new EmptyStackException();
        return top.data;
    }
    // isEmpty
    public boolean isEmpty() {
        return top==null;
    }
}
class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(3);
        stack.push(5);
        System.out.println(stack.pop());
        //System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }
    
}
