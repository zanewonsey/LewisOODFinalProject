package me.wonsey.ood.commands;

import me.wonsey.ood.tasks.Task;

public class BeginTaskCommand implements Command
{
   
   Task task;
   
   public BeginTaskCommand(Task task)
   {
      this.task = task;
   }

   @Override
   public void Execute()
   {
      this.task.beginWork();
   }

   @Override
   public void Undo() {   }

}
