package me.wonsey.ood.states;

import java.io.Serializable;

import me.wonsey.ood.tasks.ITask;

public class InProgressState implements IState, Serializable
{
   /**
    * 
    */
   private static final long serialVersionUID = 7141865714889417604L;
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
