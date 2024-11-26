
package DSASE;

import java.util.Scanner;

    

class Node{
    private int data;
    private Node next;
    private Node prev;

    public Node getPrev() {
        return prev;
    }
    
    public void setPrev(Node prev){
        this.prev = prev;
    }
    
    public Node(int data){
        this.data = data;
    }
    
    public int getData(){
        return data;
    }
    
    public void setNext(Node next){
        this.next = next;
    }
    
    public Node getNext(){
        return next;
    }
}


public class DoubleLinkedList {
    private Node head;
    
    public DoubleLinkedList(){}
    
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public void addFirst(int item){
        Node temp = new Node(item);
        temp.setNext(head);
        head.setPrev(temp);
        head = temp; 
    }
    
    public void deleteFirst(){
        if(isEmpty()){
            System.out.println("Linked is empty");
            return;
        }
        head = head.getNext();
        head.setPrev(null);
    }
    
    public void addLast(int item){
        Node temp = new Node(item);
        if(head == null)
            head = temp;
        else {
            Node wh = head;
            while(wh.getNext() != null)
                wh = wh.getNext();
            wh.setNext(temp);
            temp.setPrev(wh);
        }
    }
    
    public void deleteLast(){
        if(isEmpty()){
            System.out.println("Linked is empty");
            return;
        }
        Node temp = head;
        if(temp.getNext() == null)
            head = null;
        while(temp.getNext() != null){
            temp = temp.getNext();
        }
        temp.getPrev().setNext(null);
    }
    
    public void addMiddle(int item, int index){
        if(index < 1){
            System.out.println("out of range");
            return;
        }
        Node temp = new Node(item);
        if(index == 1){
            temp.setNext(head);
            head.setPrev(temp);
            head = temp;
            return;
        }
        Node wh = head;
        for (int i = 1; i < index; i++) {
            if(wh == null)
                return;
            wh = wh.getNext();
        }
        if(wh.getNext() == null){
            wh.setNext(temp);
            temp.setPrev(wh);
        }
        else{
            temp.setNext(wh.getNext());
            wh.getNext().setPrev(temp);
            wh.setNext(temp);
            temp.setPrev(wh);
        }
    }
    
    public void deleteMiddle(int index){
        if(index < 1){ 
            System.out.println("out of range");
            return;
        }
        if(isEmpty()){
            System.out.println("empty linked list");
            return;
        }
        if(index == 1){
            head = head.getNext();
            head.setPrev(null);
            return;
        }
        Node wh = head;
        for (int i = 1; i < index; i++) {
            if(wh == null){
                System.out.println("out of range");
                return;
            }
            wh = wh.getNext();
        }
        if(wh.getNext() != null){
            wh.setNext(wh.getNext().getNext());
            wh.getNext().setPrev(wh);
        }
    }
    
    public int getLength(){
        int length = 0 ;
        if(head == null)
            return 0;
        Node temp = head;
        while(temp.getNext() != null){
            temp = temp.getNext();
            length++;
        }
        return length;
    }
    
    
    public String toString(){
        String text = "";
        if(head == null)
            return "[]";
        Node temp = head;
        while(temp.getNext() != null){
            text += "[ " + temp.getData() + " ]";
            temp = temp.getNext();
        }
        return text;
    }
    
    public boolean search(int val){
        if(head == null)
            return false;
        Node temp = head;
        while(temp.getNext() != null){
            if(temp.getData() == val)
                return true;
            temp = temp.getNext();
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DoubleLinkedList ar = new DoubleLinkedList();
        
        do{
            System.out.println("|| Double Linked List ||");
            System.out.println("1. add first");
            System.out.println("2. delete first");
            System.out.println("3. add middle");
            System.out.println("4. delete middle");
            System.out.println("5. add last");
            System.out.println("6. delete last");
            System.out.println("7. to String");
            System.out.println("8. search");
            System.out.println("9. exit");
            System.out.print("enter value: ");
            int choose = in.nextInt();
            if(choose == 9)
                return ;
            switch(choose){
                case 1 : {
                    System.out.print("enter value: ");
                    ar.addFirst(in.nextInt());
                }break;
                case 2 : {
                    ar.deleteFirst();
                    System.out.print("item deleted");
                }break;
                case 3 : {
                    System.out.print("enter value: ");
                    int value = in.nextInt();
                    System.out.print("enter index: ");
                    ar.addMiddle(value, in.nextInt());
                }break;
                case 4 : {
                    System.out.print("enter index to delete: ");
                    ar.deleteMiddle(in.nextInt());
                }break;
                case 5 : {
                    System.out.print("enter value: ");
                    ar.addLast(in.nextInt());
                }break;
                case 6 : {
                    ar.deleteLast();
                    System.out.print("value deleted");
                }break;
                
                case 7 : {
                    System.out.println(ar);
                }break;
                
                case 8 : {
                    System.out.print("enter value to search: ");
                    if(ar.search(in.nextInt()))
                        System.out.println("not found");
                    else
                        System.out.println("found ");
                }break;
                
                default : 
                    System.out.println("invalid choose");
            }
            
        }while(true);
    }
    

}
