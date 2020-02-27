package me.wonsey.ood.states;

import me.wonsey.ood.tasks.ITask;

public class WaitingState implements IState
{
   ITask task;
   
   public WaitingState(ITask task)
   {
      this.task = task;
   }
   
   public String toString()
   {
      return "Waiting";
   }
}
