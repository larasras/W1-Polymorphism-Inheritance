// ****************************************************************
// IntegerListTest.java
//
// Provide a menu-driven tester for the IntegerList class.
//
// ****************************************************************
import java.util.Scanner;

public class IntegerListTest
{
    static IntegerList list = new IntegerList(10);
    static Scanner scan = new Scanner(System.in);

    //-------------------------------------------------------
    // Create a list, then repeatedly print the menu and do what the
    // user asks until they quit
    //-------------------------------------------------------
    public static void main(String[] args)
    {
        printMenu();
        int choice = scan.nextInt();
        while (choice != 0)
        {
            dispatch(choice);
            printMenu();
            choice = scan.nextInt();
        }
    }
    //-------------------------------------------------------
    // Do what the menu item calls for
    //-------------------------------------------------------
    public static void dispatch(int choice)
    {
        int loc;
        int oldVal, newVal;

        switch(choice)
        {
            case 0:
                System.out.println("Bye!");
                break;
            case 1:
                System.out.println("How big should the list be?");
                int size = scan.nextInt();
                list = new IntegerList(size);
                list.randomize();
                break;
            case 2:
                Scanner scanner1 = new Scanner(System.in); 
                Scanner scanner2 = new Scanner(System.in);

                System.out.println("Input the value to replace: ");
                oldVal = scanner1.nextInt();
                System.out.println("Input a replacement value: ");
                newVal = scanner2.nextInt();

                list.replaceFirst(oldVal, newVal);
                break;
            case 3:
                Scanner scanner3 = new Scanner(System.in); 
                Scanner scanner4 = new Scanner(System.in);

                System.out.println("Input the value to replace: ");
                oldVal = scanner3.nextInt();
                System.out.println("Input a replacement value: ");
                newVal = scanner4.nextInt();

                list.replaceAll(oldVal, newVal);
                break;
            case 4:
                list.selectionSortIncreasing();
                break;
            case 5:
                list.selectionSortDecreasing();
                break;
            case 6:
                System.out.print("Enter the value to look for: ");
                loc = list.search(scan.nextInt());
                if (loc != -1)
                    System.out.println("Found at location " + loc);
                else
                    System.out.println("Not in list");
                break;
            case 7:
                System.out.print("Enter the value to look for: "); 
                loc = list.binarySearchD(scan.nextInt()); 
                if (loc != -1) 
                    System.out.println("Found at location " + loc); 
                else 
                    System.out.println("Not in list"); 
                break; 
            case 8:
                list.print();
                break;
            default:
                System.out.println("Sorry, invalid choice");
        }
    }
    //-------------------------------------------------------
    // Print the user's choices
    //-------------------------------------------------------
    public static void printMenu()
    {
        System.out.println("\n Menu ");
        System.out.println(" ====");
        System.out.println("0: Quit");
        System.out.println("1: Create a new list (** do this first!! **)");
        System.out.println("2: Replace a value");
        System.out.println("3: Replace all value");
        System.out.println("4: Sort ascending list (increasing order use selection sort)");
        System.out.println("5: Sort descending list (decreasing order use selection sort)");
        System.out.println("6: Find an element in the list using linear search");
        System.out.println("7: Find an element in the list using bynary search");
        System.out.println("8: Print the list");
        System.out.print("\nEnter your choice: ");
    }
}