
package DSASE;

import DSASE_GE.Array1D;
import DSASE_GE.Queue;
import DSASE_GE.ArrayList;
import DSASE_GE.Array2D;
import DSASE_GE.DoubleLinkedList;
import DSASE_GE.LinearQueue;
import DSASE_GE.Stack;
import DSASE_GE.LinkedList;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        do {

            System.out.println("1. 1D Array");
            System.out.println("2. 2D Array");
            System.out.println("3. Array List");
            System.out.println("4. Double Linked List");
            System.out.println("5. Linear Queue");
            System.out.println("6. Linked List");
            System.out.println("7. Circle Queue");
            System.out.println("8. Stack");
            System.out.println("9. exit");
            System.out.print("Enter number your choose: ");
            int choose = in.nextInt();
            if(choose == 9)
                return;
            
            switch(choose){
                case 1 : {
                    Array1D.main(null);
                }break;
                case 2 : {
                    Array2D.main(null);
                }break;
                case 3 : {
                    ArrayList.main(null);
                }break;
                case 4 : {
                    DoubleLinkedList.main(null);
                }break;
                case 5 : {
                    LinearQueue.main(null);
                }break;
                case 6 : {
                    LinkedList.main(null);
                }break;
                case 7 : {
                    Queue.main(null);
                }break;
                case 8 : {
                    Stack.main(null);
                }break;
                
                default : 
                    System.out.println("invalid choose");
            }
            
        } while (true);
        
    }

}
