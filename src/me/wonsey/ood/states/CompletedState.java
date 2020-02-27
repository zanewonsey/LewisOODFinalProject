package me.wonsey.ood.states;

import me.wonsey.ood.tasks.ITask;

public class CompletedState implements IState
{
   ITask task;
   
   public CompletedState(ITask task)
   {
      this.task = task;
   }
   
   public String toString()
   {
      return "Completed";
   }
}
