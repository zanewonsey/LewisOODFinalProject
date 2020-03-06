package me.wonsey.ood.states;

import java.io.Serializable;

import me.wonsey.ood.tasks.ITask;

public class CompletedState implements IState, Serializable
{
   /**
    * 
    */
   private static final long serialVersionUID = 7849086933623444364L;
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
