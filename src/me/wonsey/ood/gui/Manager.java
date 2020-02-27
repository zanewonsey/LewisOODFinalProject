package me.wonsey.ood.gui;

import me.wonsey.ood.containers.LinkedList;
import me.wonsey.ood.containers.Node;
import me.wonsey.ood.tasks.ITask;
import me.wonsey.ood.tasks.Task;

public class Manager
{
   private LinkedList<Task> task_list;
   
   public Manager()
   {
      task_list = new LinkedList<Task>();
   }
   
   public void addNewTask(String taskName)
   {
      System.out.println("sdfgsdgsdfgsdfg");
      task_list.add(new Node<Task>(new Task(taskName)));
   }
   
   public void removeTask(ITask task)
   {
      task_list.remove((Task) task);
   }
   
   public void getAllList()
   {
      
   }
   
   public void getInList()
   {
      
   }
   
   public void getAldxfghlList()
   {
      
   }
   
   public boolean openFile()
   {
      System.out.println("openFile");
      return false;
   }
   
   public boolean saveFile()
   {
      System.out.println("saveFile");
      return false;
   }
}
