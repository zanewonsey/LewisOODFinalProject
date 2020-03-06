package me.wonsey.ood.commands;

import me.wonsey.ood.tasks.Task;

public class CompleteTaskCommand implements Command
{
   
   Task task;
   
   public CompleteTaskCommand(Task task)
   {
      this.task = task;
   }

   @Override
   public void Execute()
   {
      this.task.complete();
   }

   @Override
   public void Undo() {   }

}
