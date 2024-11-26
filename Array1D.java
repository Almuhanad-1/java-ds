

package DSASE;

import java.util.Scanner;

public class Array1D {
    private int size ;
    private int array[];
    private static Scanner in = new Scanner(System.in);
    
    public Array1D(){
        this(10);
    }
    
    public Array1D(int size){
        if(size < 1)
            size = 10;
        this.size = size;
        array = new int[this.size];
    }
    
    public void insertArray(){
        System.out.println("Enter (" + array.length + ") elements: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = in.nextInt();
        }
    }
    
    public int search(int item){
        for (int i = 0; i < array.length; i++) 
            if(item == array[i])
                return i;
        return -1;
    }
    
    public void delete(int item){
        int i = search(item);
        if(i == -1)
            return;
        for (int j = i; j < array.length-1; j++) 
            array[j] = array[j+1];
        array[array.length-1] = 0;
    }
    
    public void deleteAll(int item){
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] != item)
                array[index++] = array[i];
        }
        while(index < array.length)
            array[index++] = 0;
    }
    
    
    public void print(){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    public int sum(){
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
    
    public int avg(){
        int sum = sum();
        return sum / array.length;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("enter size: ");
        Array1D ar = new Array1D(in.nextInt());
        
        do {
            System.out.println("|| 1D Array ||");
            System.out.println("1. insert");
            System.out.println("2. delete");
            System.out.println("3. search");
            System.out.println("4. delete all");
            System.out.println("5. sum");
            System.out.println("6. avg");
            System.out.println("7. print");
            System.out.println("8. exit");
            System.out.print("enter your choose: ");
            int choise = in.nextInt();
            if(choise == 8)
                return ;
            switch(choise){
                case 1 : {
                    ar.insertArray();
                }break;

                case 2 : {
                    System.out.print("enter value to delete: ");
                    ar.delete(in.nextInt());
                }break;

                case 3 : {
                    System.out.print("enter value to search: ");
                    int index ;
                    if((index = ar.search(in.nextInt())) == -1){
                        System.out.println("not found");
                    }else{
                        System.out.println("found in : " + index);
                    }
                }break;

                case 4 : {
                    System.out.print("enter value to delete from all array: ");
                    ar.deleteAll(in.nextInt()); 
                }break;

                case 5 : {
                    System.out.println("sum: " + ar.sum());
                }break;

                case 6 : {
                    System.out.println("avg: " + ar.avg());
                }break;
                
                case 7 : {
                    ar.print();
                }break;

                default : 
                    System.out.println("invalid choose");
            }

        } while (true);
    }
    
}
