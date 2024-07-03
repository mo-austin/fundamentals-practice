

import java.util.*;

import pq.MyPriorityQueue;


public class TesterPQ {

    public static void main(String[] args) {
        MyPriorityQueue<Task> pq = new MyPriorityQueue<>();

        Task a = new Task("read chapter of book", 2);
        Task b = new Task("feed the dog", 5);
        Task c = new Task("finish program", 10);
        Task d = new Task("play video game", 3);
        Task e = new Task("make bed", 1);
        pq.add(a);
        pq.add(b);
        pq.add(c);
        pq.add(d);
        pq.add(e);
        System.out.println(pq);

        System.out.println("Removing pq items, should be highest to lowest priority");
        while (pq.size() > 0)
            System.out.println(pq.remove());

        pq.clear();

        boolean done = false;
        Scanner scan = new Scanner(System.in);

        do {
            // menu to process Task list
            printMenu();
            System.out.println("Enter choice");
            int choice = scan.nextInt();
            String trash = scan.nextLine();
            switch(choice) {
                case 1: // print(list);
                    System.out.println(pq);
                    break;
                case 2: //add
                    System.out.println("Enter task");
                    String n = scan.nextLine();
                    System.out.println("Enter priority");
                    int p = scan.nextInt();
                    Task toAdd = new Task(n, p);
                    pq.add(toAdd);

                    break;
                case 3: // remove
                    Task t = pq.remove();
                    System.out.println("The following task has been removed:  " + t);
                    break;
                case 4: // clear
                    System.out.println("Clearing the task list.");
                    pq.clear();
                    break;
                case 5: // size
                    System.out.println("The size of the task list is " + pq.size());
                    break;
                case 6: // next task
                    System.out.println("The next task to be done is " + pq.peek());
                    break;
                case 7: // contains
                    System.out.println("Enter task to find");
                    String inName = scan.nextLine();
                    Task tofind = new Task(inName, 1);
                    if (pq.contains(tofind))
                        System.out.println("Task found!");
                    else
                        System.out.println("Task not found!");
                    break;
                case 8:  System.out.println("Closing task list.");  done = true; break;
                default:  System.out.println("Error, invalid selection");
            }
        } while (!done);


    }

    
    public static void printMenu()
    {
        System.out.println("1. Print the task list");
        System.out.println("2. Add a task");
        System.out.println("3. Remove a task");
        System.out.println("4. Clear the task list");
        System.out.println("5. Size of task list");
        System.out.println("6. Next task to do");
        System.out.println("7. Does task list contain this task?");
        System.out.println("8. Quit");
    }

}
