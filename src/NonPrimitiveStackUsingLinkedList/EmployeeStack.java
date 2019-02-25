package NonPrimitiveStackUsingLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Employee {
    int empid;
    String name;
    int sal;

    public Employee(int empid, String name, int sal) {
        this.empid = empid;
        this.name = name;
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empid=" + empid +
                ", name='" + name + '\'' +
                ", sal=" + sal +
                '}';
    }
}

class Node{
    private Employee data;
    private Node next;

    public Node() {
        data = null;
        next = null;
    }

    public Node(Employee data) {
        this.data = data;
    }

    public Node(Employee data, Node next) {
        this.data = data;
        this.next = next;
    }

    public void setData(Employee data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Employee getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }
}

public class EmployeeStack{
    Node top;

    public EmployeeStack() {
        top = null;
    }

    private boolean isEmpty(){
        return top == null;
    }

    public void push(Employee val){
        Node n = new Node();
        n.setData(val);
        n.setNext(top);
        top = n;
    }

    public Employee pop(){
        Employee result;
        if(isEmpty()){
            System.out.println("Linked List is Empty");
            return null;
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
                Employee tobj;
                tobj = temp.getData();
                System.out.println(tobj);
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

    public static void main(String[] args) throws IOException {
        char ch ='y';
        int choice;
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int id;
        String name;
        int n;
        int salary;
        EmployeeStack st = new EmployeeStack();
        Employee emp;
        while(ch=='y' || ch=='Y') {
            System.out.println("Select any operation:");
            System.out.println("1. Push ");
            System.out.println("2. Pop ");
            System.out.println("3. Display");
            System.out.println("4. Count");
            choice = Integer.parseInt(br.readLine());
            switch(choice){
                case 1:
                    System.out.println("Enter employee id, name and salary:");
                    id = Integer.parseInt(br.readLine());
                    name = br.readLine();
                    salary = Integer.parseInt(br.readLine());
                    emp = new Employee(id,name,salary);
                    st.push(emp);
                    break;
                case 2:
                    emp = st.pop();
                    if (emp!=null)
                        System.out.println("Removed data is "+emp);
                    break;
                case 3:
                    st.display();
                    break;
                case 4:
                    n = st.count();
                    System.out.println("Total elements are "+n);
            }
            System.out.println("Want to continue(y/n)");
            ch = br.readLine().charAt(0);
        }
    }
}