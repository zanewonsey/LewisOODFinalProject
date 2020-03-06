package me.wonsey.ood.gui;

import java.io.IOException;

import me.wonsey.ood.containers.LinkedList;
import me.wonsey.ood.fileoperation.FileOperator;
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
      task_list.append(new Task(taskName));
   }
   
   public void removeTask(ITask task)
   {
      task_list.remove((Task) task);
   }
   
   public LinkedList<Task> getList()
   {
      return this.task_list;
   }
   
   public boolean openFile()
   {
      System.out.println("openFile");
      FileOperator file_operator = FileOperator.getOperator();
      try
      {
         task_list = file_operator.readList();
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
      return false;
   }
   
   public boolean saveFile()
   {
      System.out.println("saveFile");
      FileOperator file_operator = FileOperator.getOperator();
      try
      {
         file_operator.writeList(task_list);
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
      return false;
   }
}
