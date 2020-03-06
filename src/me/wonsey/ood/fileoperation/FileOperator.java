package me.wonsey.ood.fileoperation;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import me.wonsey.ood.containers.*;

public class FileOperator
{
   
   private static FileOperator file_operator = new FileOperator();
   
   private String name;
   private String path;
   
   private FileOperator()
   {
      name = "task_list.memes";
      path = System.getProperty("user.dir");
   }
   
   public static FileOperator getOperator()
   {
      return file_operator;
   }
   
   /***************************************************************/
   
   public void setSaveFileName(String name)
   {
      this.name = name;
   }
   
   public String getSaveFileName()
   {
      return this.name;
   }
   
   public void setSaveFileLocation(String location)
   {
      this.path = location;
   }
   
   public String getSaveFileLocation()
   {
      return this.path;
   }
   
   /**
    * @throws IOException *************************************************************/
   
   public <T> boolean writeList(LinkedList<T> list) throws IOException
   {
      boolean couldWrite = false;
      
      me.wonsey.ood.containers.Iterable<T> ll_iter = list.createIterator();
      FileOutputStream file = null;
      ObjectOutputStream out = null;
      
      // Serialization  
      try
      {    
         // Saving of object in a file 
         file = new FileOutputStream(path+"\\"+name);
         out = new ObjectOutputStream(file); 
         
         while (ll_iter.hasNext())
         {
            // Method for serialization of object 
            out.writeObject(ll_iter.next()); 
         }

      } 
      catch(IOException ex) 
      { 
          System.out.println("IOException is caught"); 
      }
      finally
      {
         out.close(); 
         file.close();
      }
      
      return couldWrite;
   }
   
   @SuppressWarnings("unchecked")
   public <T> LinkedList<T> readList() throws IOException
   {
      LinkedList<T> list = new LinkedList<T>();
      
      FileInputStream file = null;
      ObjectInputStream in = null;
      
      // Serialization  
      try
      {    
         // Saving of object in a file 
         file = new FileInputStream(path+"\\"+name);
         in = new ObjectInputStream(file); 
         
         while (true)
         {
            // Method for serialization of object 
            list.append((T)in.readObject());
         }
      } 
      catch (EOFException e)
      {
         System.out.println("EOF reached. All items read in."); 
      }
      catch(IOException ex) 
      { 
          System.out.println("IOException is caught"); 
      }
      catch (ClassNotFoundException e)
      {
         e.printStackTrace();
      }
      finally
      {
         if (in   != null) in.close(); 
         if (file != null) file.close();
      }
      
      return list;
   }
}
