package StackUsingLinkedList;

import java.util.Scanner;

class Node{
    private int data;
    private Node next;

    public Node() {
        data = 0;
        next = null;
    }

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }
}

public class MyStack {
    Node top;

    public MyStack() {
        top = null;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void push(int val){
        Node n = new Node();
        n.setData(val);
        n.setNext(top);
        top = n;
    }

    public int pop(){
        int result;
        if(isEmpty()){
            System.out.println("Linked List is Empty");
            return 0;
        }
        else{
            result = top.getData();
            top = top.getNext();
            return result;
        }
    }

    public void display(){
        Node temp;
        temp = top;

        if(temp == null){
            System.out.println("Linked list is empty");
            return;
        }
        else{
            while(temp!=null){
                System.out.println(temp.getData()+" "+temp.getNext());
                temp = temp.getNext();
            }
        }
    }

    public int count(){
        int ctr = 0;
        Node temp;
        temp = top;

        while(temp!=null){
            ctr++;
            temp = temp.getNext();
        }
        return ctr;
    }

    public static void main(String[] args) {
        char ch ='y';
        int choice;
        Scanner sc = new Scanner(System.in);
        int n;
        MyStack st = new MyStack();
        while(ch=='y' || ch=='Y') {
            System.out.println("Select any operation:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Count");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter Data:");
                    n = sc.nextInt();
                    st.push(n);
                    break;
                case 2:
                    n = st.pop();
                    if (n!=0)
                        System.out.println("Removed data is "+n);
                    break;
                case 3:
                    st.display();
                    break;
                case 4:
                    n = st.count();
                    System.out.println("Total elements are "+n);
            }
            System.out.println("Want to continue(y/n)");
            ch = sc.next().charAt(0);
        }
    }
}
