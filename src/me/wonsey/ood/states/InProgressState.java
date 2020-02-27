package me.wonsey.ood.states;

import me.wonsey.ood.tasks.ITask;

public class InProgressState implements IState
{
   ITask task;
   
   public InProgressState(ITask task)
   {
      this.task = task;
   }
   
   public String toString()
   {
      return "In progress";
   }
}
