package me.wonsey.ood.states;

import java.io.Serializable;

import me.wonsey.ood.tasks.ITask;

public class WaitingState implements IState, Serializable
{
   /**
    * 
    */
   private static final long serialVersionUID = -5170521432053882880L;
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
