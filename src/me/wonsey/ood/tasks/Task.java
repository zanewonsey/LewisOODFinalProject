package me.wonsey.ood.tasks;

import me.wonsey.ood.states.CompletedState;
import me.wonsey.ood.states.EmptyState;
import me.wonsey.ood.states.IState;
import me.wonsey.ood.states.InProgressState;
import me.wonsey.ood.states.WaitingState;

public class Task implements ITask
{
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
      // TODO this.status = new 
   }

   @Override
   public void remove()
   {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void edit()
   {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void beginWork()
   {
      this.status = inProgress;
   }

}
