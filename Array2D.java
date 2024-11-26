package DSASE;


import java.util.Scanner;


public class Array2D {
    private int array[][] ;
    private static Scanner in = new Scanner(System.in);
    
    
    public Array2D(){
        this(4);
    }
    
    public Array2D(int row){
        array = new int[row][row];
    }
    
    public void insert(){
        System.out.println("Insert " + array.length * array.length + " elements: ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = in.nextInt();
            }
        }
    }
    
    public int[] search(int item){
        for (int i = 0; i < array.length; i++) 
            for (int j = 0; j < array[i].length; j++) 
                if(item == array[i][j])
                    return new int[]{i, j};
        return new int[]{-1, -1};
    }
    
    public void delete(int item){
        int[] index = search(item);
        if(index[0] == -1)
            return;
        deleteIndex(index[0], index[1]);
    }
    
    private void deleteIndex(int iIndex, int jIndex){
        if(iIndex < 0 || jIndex < 0 )
            return ;
        if(iIndex >= array.length || jIndex >= array[iIndex].length)
            return;
        
        for (int i = iIndex; i < array.length-1; i++) {
            array[i][jIndex] = array[i+1][jIndex];
        }
        for (int i = jIndex; i < array[0].length-1; i++) {
            array[iIndex][i] = array[iIndex][i+1];
        }
        array[array.length-1][array[array.length-1].length-1] = 0;
    }
    
    public void deleteAll(int item){
        int[] index;
        while((index = search(item))[0] != -1){
            deleteIndex(index[0], index[1]);
        }
    }
    
    public void toTowArray(int[] oneAr){
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = oneAr[index++];
            }
        }
    }
    public int[] toOneArray(){
        int temp[] = new int[array.length*array[0].length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                temp[index++] = array[i][j];
            }
        }
        return temp;
    }
    public void deleteAllByOneDArray(int item){
        int[] array = toOneArray();
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] != item)
                array[index++] = array[i];
        }
        while(index < array.length)
            array[index++] = 0;
        toTowArray(array);
   }
    
    public void display(){
        for (int i = 0; i < array.length; i++) {
            System.out.print("[");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + ", ");
            }
            System.out.println("\b\b]");
        }
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("enter size: ");
        Array2D ar = new Array2D(in.nextInt());
        
        do {
            System.out.println("|| 2D Array ||");
            System.out.println("1. insert");
            System.out.println("2. search");
            System.out.println("3. delete");
            System.out.println("4. delete All");
            System.out.println("5. delete by change to 1 array");
            System.out.println("6. display");
            System.out.print("enter your choose: ");
            int choise = in.nextInt();
            if(choise == 7)
                return ;
            switch(choise){
                case 1 : {
                    ar.insert();
                }break;
                
                case 2 : {
                    System.out.print("enter value: ");
                    ar.search(in.nextInt());
                }break;
                
                case 3 : {
                    System.out.print("enter value to delete: ");
                    ar.delete(in.nextInt());
                }break;
                
                case 4 : {
                    System.out.print("enter value to delete from all array: ");
                    ar.deleteAll(in.nextInt());
                }break;
                
                case 5 : {
                    System.out.print("enter value to delete by change to 1D array: ");
                    ar.deleteAllByOneDArray(in.nextInt());
                }break;
                
                case 6 : {
                    ar.display();
                }break;
                
                default : 
                    System.out.println("invalid choose");
            }
        } while (true);
    }
    
    
}
