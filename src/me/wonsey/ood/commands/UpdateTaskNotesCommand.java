package me.wonsey.ood.commands;

import me.wonsey.ood.tasks.Task;

public class UpdateTaskNotesCommand implements Command
{
   Task task;
   
   public UpdateTaskNotesCommand(Task task)
   {
      this.task = task;
   }
   
   @Override
   public void Execute()
   {
      this.task.setTaskNotes("");
   }
   
   public void Execute(String notes)
   {
      this.task.setTaskNotes(notes);
   }

   @Override
   public void Undo() {   }

}
