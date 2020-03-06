package me.wonsey.ood.tests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import me.wonsey.ood.commands.BeginTaskCommand;
import me.wonsey.ood.commands.CompleteTaskCommand;
import me.wonsey.ood.containers.Iterable;
import me.wonsey.ood.containers.LinkedList;
import me.wonsey.ood.states.CompletedState;
import me.wonsey.ood.states.EmptyState;
import me.wonsey.ood.states.InProgressState;
import me.wonsey.ood.states.WaitingState;
import me.wonsey.ood.tasks.Task;

public class Tests
{
   private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
   private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
   private final PrintStream originalOut = System.out;
   private final PrintStream originalErr = System.err;
   
   @Before
   public void setUp() throws Exception
   {
      System.setOut(new PrintStream(outContent));
      System.setErr(new PrintStream(errContent));
   }
   
   @After
   public void tearDown() throws Exception
   {
      System.setOut(new PrintStream(originalOut));
      System.setErr(new PrintStream(originalErr));
   }
   
   private String getSyso()
   {
      String retval = "";
      try
      {
         retval = outContent.toString();
         outContent.reset();
      }
      catch (Exception e)
      {
         System.err.println("Well then");
      }
      return retval;
   }
   
   // ##########################################################
   // Command Pattern Tests
   @Test
   public void testCommands()
   {
      Task task = new Task("test");
      BeginTaskCommand btc = new BeginTaskCommand(task);
      CompleteTaskCommand ctc = new CompleteTaskCommand(task);
      
      if (!(task.getState() instanceof WaitingState))
         Assert.fail();
      
      btc.Execute();
      if (!(task.getState() instanceof InProgressState))
         Assert.fail();
      
      ctc.Execute();
      if (!(task.getState() instanceof CompletedState))
         Assert.fail();
   }
   
   // ##########################################################
   // State Pattern Tests
   @Test
   public void testStateChange()
   {
      Task task = new Task();
      if (!(task.getState() instanceof EmptyState))
         Assert.fail();
      
      task = new Task("test");
      if (!(task.getState() instanceof WaitingState))
         Assert.fail();
      
      task.beginWork();
      if (!(task.getState() instanceof InProgressState))
         Assert.fail();
      
      task.complete();
      if (!(task.getState() instanceof CompletedState))
         Assert.fail();

   }
   
   // ##########################################################
   // Iterator Pattern Tests
   @Test
   public void testLinkedListAppend()
   {
      LinkedList<String> ll = new LinkedList<String>();
      ll.append("ree1");
      ll.append("ree2");
      ll.append("ree3");
      
      Iterable<String> ll_iter = ll.createIterator();
      
      while (ll_iter.hasNext()) System.out.println(ll_iter.next());
      
      Assert.assertEquals("ree1\r\nree2\r\nree3\r\n", getSyso());
   }
   
   @Test
   public void testLinkedListRemove()
   {
      LinkedList<String> ll = new LinkedList<String>();
      ll.append("ree1");
      ll.append("ree2");
      ll.append("ree3");
      
      Iterable<String> ll_iter = ll.createIterator();
      while (ll_iter.hasNext()) System.out.println(ll_iter.next());
      
      Assert.assertEquals("ree1\r\nree2\r\nree3\r\n", getSyso());
      
      ll.remove("ree2");
      
      ll_iter = ll.createIterator();
      while (ll_iter.hasNext()) System.out.println(ll_iter.next());
      
      Assert.assertEquals("ree1\r\nree3\r\n", getSyso());
      
      ll.append("hmmm");
      
      ll_iter = ll.createIterator();
      
      
      while (ll_iter.hasNext())
      {
         System.out.println(ll_iter.next());
      }
      
      Assert.assertEquals("ree1\r\nree3\r\nhmmm\r\n", getSyso());

   }
   
   @Test
   public void runningDirTest()
   {
      String dir = System.getProperty("user.dir");
      System.out.println(dir);
   }

}
