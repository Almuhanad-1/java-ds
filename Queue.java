package DSASE;


import java.util.Scanner;

public class Queue {
    private int front, rear;
    private Student array[];
    
    public Queue(){
        this(10);
    }
    
    public Queue(int size){
        array = new Student[size];
        front = rear = 0;
    }
    
    public boolean isFull(){
        return (rear+1) % array.length == front;
    }
    
    public boolean isEmpty(){
        return front == rear;
    }
    
    public void enqueue(Student item){
        if(isFull()){
            System.out.println("Queue is Full");
            return ;
        }
        array[(rear = (rear + 1) % array.length)] = item;
    }
    
    public Student dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return null;
        }
        return array[(front = (front + 1) % array.length)];
    }
    
    public Student getFront(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return null;
        }
        return array[front];
    }
    
    public Student getRear(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return null;
        }
        return array[rear];
    }
    
    public int getLength(){
        if(front < rear)
            return front - rear;
        if(front > rear)
            return array.length - (front - rear);
        return 0;
    }
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        System.out.print("enter size: ");
        Queue ar = new Queue(in.nextInt());
        
        do{
            System.out.println("|| Circle Queue ||");
            System.out.println("1. enqueu");
            System.out.println("2. dequeue");
            System.out.println("3. getFront");
            System.out.println("4. getRear");
            System.out.println("5. getLength");
            System.out.println("6. exit");
            System.out.print("enter value: ");
            int choose = in.nextInt();
            if(choose == 6)
                return ;
            switch(choose){
                case 1 : {
                    System.out.print("enter student name: ");
                    Student st = new Student(in.nextLine(), 20, "SE", 1);
                    ar.enqueue(st);
                }break;
                
                case 2 : {
                    System.out.print(ar.dequeue());
                }break;
                
                case 3 : {
                    System.out.print("front: " + ar.getFront());
                }break;
                
                case 4 : {
                   System.out.print("Rear: " + ar.getRear());
                }break;
                
                case 5 : {
                    System.out.print("length: " + ar.getLength());
                }break;
                
                default : 
                    System.out.println("invalid choose");
            }
            
        }while(true);
    }
}
