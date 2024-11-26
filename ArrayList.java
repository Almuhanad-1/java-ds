
package DSASE;


import java.util.Scanner;

public class ArrayList {

    private int currPosition;
    private int[] array;
    
    public ArrayList(){
        this(10);
    }
    
    public ArrayList(int size){
        array = new int[size];
        currPosition = 0;
    }
    
    public boolean isFull(){
        return currPosition == array.length;
    }
    
    public boolean isEmpty(){
        return currPosition == 0;
    }
    
    public void add(int val){
        if(isFull()){
            System.out.println("ArrayList is Full");
            return;
        }
        array[currPosition++] = val;
    }
    
    public void add(int[] array){
        if(array.length > (this.array.length - currPosition)){
            System.out.println("No space for all items");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            add(array[i]);
        }
    }
    
    public int search(int val){
        if(isEmpty()){
            System.out.println("ArrayList is Empty");
            return -1;
        }
        for (int i = 0; i < array.length; i++) {
            if(val == array[i])
                return i;
        }
        return -1;
    }
    
    public void delete(int item){
        if(isEmpty()){
            System.out.println("Empty Array");
            return ;
        }
        int index = search(item);
        if(index < 0){
            System.out.println("Not found");
            return ;
        }
        for (int i = index; i < array.length-1; i++) {
            array[i] = array[i+1];
        }
        array[--currPosition] = 0;
    }
    
    public void deleteAll(int item){
        if(isEmpty()){
            System.out.println("Empty Array");
            return ;
        }
        int position = 0;
        for (int i = 0; i < array.length; i++) {
            if(item == array[i])
                array[position++] = array[i];
        }
        while(position < array.length)
            array[position++] = 0;
    }
    
    public void print(){
        for (int i = 0; i < currPosition; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("enter size: ");
        ArrayList ar = new ArrayList(in.nextInt());
        
        do {
            System.out.println("|| Array List ||");
            System.out.println("1. add item");
            System.out.println("2. add array");
            System.out.println("3. search");
            System.out.println("4. delete");
            System.out.println("5. delete All");
            System.out.println("6. print");
            System.out.print("enter your choose: ");
            int choise = in.nextInt();
            if(choise == 7)
                return ;
            switch(choise){
                case 1 : {
                    System.out.print("enter value: ");
                    ar.add(in.nextInt());
                }break;
                
                case 2 : {
                    System.out.print("enter array size: ");
                    int array[] = new int[in.nextInt()];
                    System.out.println("enter " + array.length + " values: ");
                    for (int i = 0; i < array.length; i++) {
                        array[i] = in.nextInt();
                    }
                    ar.add(array);
                }break;
                
                case 3 : {
                    System.out.print("enter value to search: ");
                    int index;
                    if((index = ar.search(in.nextInt())) == -1){
                        System.out.println("not found");
                    }else{
                        System.out.println("found in " + index);
                    }
                }break;
                
                case 4 : {
                    System.out.print("enter value to delete: ");
                    ar.delete(in.nextInt());
                }break;
                
                case 5 : {
                    System.out.print("enter value to delete from all array: ");
                    ar.deleteAll(in.nextInt());
                }break;
                
                case 6 : {
                    ar.print();
                }break;
                
                default : 
                    System.out.println("invalid choose");
            }
        } while (true);
    }
}
