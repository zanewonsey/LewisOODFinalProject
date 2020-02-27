package me.wonsey.ood.tests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import me.wonsey.ood.containers.LinkedList;
import me.wonsey.ood.containers.Node;

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
   
   @Test
   public void testLinkedListAdd()
   {
      LinkedList<String> ll = new LinkedList<String>();
      ll.add(new Node<String>("ree1"));
      ll.add(new Node<String>("ree2"));
      ll.add(new Node<String>("ree3"));
      
      fail("Not yet implemented");
   }

}
