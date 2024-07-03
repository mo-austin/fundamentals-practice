
public class Task implements Comparable<Task>{
   private String taskName;
   private int priority;


   /**
    * Constructor for privatized variables
    * @param taskName - taskName
    * @param priority - priority
    */

    public Task(String taskName) {
        this.priority = -1;
        this.taskName = taskName;
    }

   public Task(String taskName, int priority){ // Constructor, intialize variables
       this.taskName = taskName;
       this.priority = priority;
   }


   /**
    * getPriority() method that returns an integer
    * @return int
    */


   public int getPriority(){ // Priority getter
       return priority;
   }


   /**
    * getTask() method that returns a String
    * @return String
    */


   public String getTask(){ // Task getter
       return taskName;
   }


   /**
    * toString method
    * @return - [taskName, priority]
    */
  
    public String toString(){ // Return String of task and priority
        return "[ " + taskName + ", " + priority + " ]";
    }


   public boolean equals(Object o) { // Equals method for task class
       if (this == o) return true;
       if (o == null || getClass() != o.getClass()) return false;
       Task task = (Task) o;
       return priority == task.priority && taskName.equals(task.taskName);
   }


   @Override
   public int compareTo(Task o) { // Compare priority of two tasks
    //    return Integer.compare(o.getPriority(), this.getPriority());
           return Integer.compare(this.getPriority(), o.getPriority());

   }
}


