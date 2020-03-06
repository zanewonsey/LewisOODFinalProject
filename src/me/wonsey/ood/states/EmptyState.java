package me.wonsey.ood.states;

import java.io.Serializable;

import me.wonsey.ood.tasks.ITask;

public class EmptyState implements IState, Serializable
{
   /**
    * 
    */
   private static final long serialVersionUID = -5193203144445864150L;
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
