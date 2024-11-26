
package DSASE;


import java.util.Scanner;

public class Stack {
    private int top ;
    private Student[] array;
    
    public Stack(){
        this(10);
    }
    
    public Stack(int size){
        array = new Student[size];
        top = -1;
    }
    
    public boolean isFull(){
        return top == array.length -1;
    }
    
    public boolean isEmpty(){
        return top == -1;
    }
    
    public void push(Student val){
        if(isFull()){
            System.out.println("Stack is Full");
            return;
        }
        array[++top] = val;
    }
    
    public Student peek(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return null;
        }
        return array[top];
    }
    
    public Student pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return null;
        }
        Student topVal = peek();
        top--;
        return topVal;
    }
    
    public int search(Student val){
        if(isEmpty()){
            return -1;
        }
        Stack temp = new Stack(top + 1);
        int index = -1;
        for (int i = top; i >= 0; i--) {
            if(peek().equals(val)){
                index = i;
                break;
            }
            temp.push(pop());
        }
        while(!temp.isEmpty()){
            push(temp.pop());
        }
        return index;
    }
    
    
    public void delete(Student val){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return;
        }
        Stack temp = new Stack(top);
        for (int i = top; i >= 0; i--) {
            if(!peek().equals(val)){
                temp.push(pop());
            }else{
                pop();
            }
        }
        while(!temp.isEmpty()){
            push(temp.pop());
        }
    }
    
    public void print(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return;
        }
        Stack temp = new Stack(top);
        while (!isEmpty()) {
            temp.push(pop());
            System.out.println(temp.peek());
        }
        while(!temp.isEmpty()){
            push(temp.pop());
        }
    }
    
    
    public Stack transform(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return null;
        }
        Stack temp = new Stack(top);
        while(!isEmpty())
            temp.push(pop());
        
        Stack newStack = new Stack(top);
        while(!temp.isEmpty())
            newStack.push(temp.pop());
        return newStack;
    }
    
    public int getTop(){
        return top;
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("enter size: ");
        Stack ar = new Stack(in.nextInt());
        
        System.out.println();
        System.out.println("|| Stack ||");
        do {
            
            System.out.println("1. push");
            System.out.println("2. pop");
            System.out.println("3. peek");
            System.out.println("4. print");
            System.out.println("5. delete");
            System.out.println("6. isEmpty");
            System.out.println("7. isFull");
            System.out.println("8. exit");
            System.out.print("Enter option: ");
            int chois = in.nextInt();
            switch(chois){
                case 1 : {
                    System.out.print("enter student name: ");
                    Student st = new Student(in.nextLine(), 20, "SE", 1);
                    ar.push(st);
                }break; 
                case 2 : {
                    System.out.println(ar.pop());
                }break;
                case 3 : {
                    System.out.println(ar.peek());
                }break;
                case 4 : {
                    ar.print();
                }break;
                case 5 : {
                   // // /// /// /// /// /// //
                }break;
                case 6 : {
                    System.out.println("is Empty: " + ar.isEmpty()); 
                }break;
                case 7 : {
                    System.out.println("is Full" + ar.isFull());
                }break;
                case 8 : {
                    System.out.println("Stack Finished");
                    return; 
                }
                default : {
                    System.out.println("Valid choise");
                }
            }
        } while (true);
    }
}
