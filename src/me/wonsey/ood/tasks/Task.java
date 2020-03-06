package me.wonsey.ood.tasks;

import java.io.Serializable;

import me.wonsey.ood.states.*;

public class Task implements ITask, Serializable
{
   /**
    * 
    */
   private static final long serialVersionUID = 4314049020921672306L;
   private String taskName;
   private String notes;
   
   private IState empty;
   private IState waiting;
   private IState inProgress;
   private IState completed;
   private IState status;
   
   public Task()
   {
      
      init("");
      this.status = empty;
   }

   public Task(String name)
   {
      init(name);
   }
   
   private void init(String name)
   {
      this.taskName = name;
      this.notes = "";
      
      this.empty = new EmptyState(this);
      this.waiting = new WaitingState(this);
      this.inProgress = new InProgressState(this);
      this.completed = new CompletedState(this);
      
      this.status = this.waiting;
   }
   
   public IState getState()
   {
      return this.status;
   }
   
   public String getTaskName()
   {
      return this.taskName;
   }
   
   public void setTaskNotes(String notes)
   {
      this.notes = notes;
   }
   
   public String getTaskNotes()
   {
      return this.notes;
   }
   
   public String toString()
   {
      return getTaskName();
   }

   @Override
   public void complete()
   {
      this.status = this.completed;
   }

   @Override
   public void beginWork()
   {
      this.status = inProgress;
   }

}
