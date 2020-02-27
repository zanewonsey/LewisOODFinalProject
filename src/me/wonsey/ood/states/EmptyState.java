package me.wonsey.ood.states;

import me.wonsey.ood.tasks.ITask;

public class EmptyState implements IState
{
   ITask task;
   
   public EmptyState(ITask task)
   {
      this.task = task;
   }
   
   public String toString()
   {
      return "";
   }
}
