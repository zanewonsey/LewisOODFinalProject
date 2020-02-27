package me.wonsey.ood.containers;

public class LinkedList<T> implements ILinkedList<T>
{
   
   private INode<T> head;
   private INode<T> tail;
   
   public LinkedList()
   {
      this.head = null;
      this.tail = null;
   }
   
   @Override
   public INode<T> getHead()
   {
      return this.head;
   }

   @Override
   public INode<T> getTail()
   {
      return this.tail;
   }

   @Override
   public boolean append(INode<T> node)
   {
      boolean retVal = false;
      
      if (this.head == null)
      {
         this.head = node;
         this.tail = this.head;
      }
      else if (this.head == this.tail)
      {
         this.tail = node;
         this.head.setNext(tail);
      }
      else
      {
         this.tail.setNext(node);
         this.tail = this.tail.getNext();
      }
      
      return retVal;
   }

   @Override
   public boolean add(INode<T> node)
   {
      boolean retVal = false;
      if (this.head == null)
      {
         this.head = node;
         this.tail = this.head;
      }
      else if (this.head == this.tail)
      {
         this.head = node;
         this.head.setNext(this.tail);
      }
      else
      {
         node.setNext(this.head);
         this.head.setPrevious(node);
         this.head = node;
      }
      return retVal;
   }
   
   @Override
   public boolean remove(T task)
   {
      // TODO finish this
      INode<T> current = this.head;
      boolean notFound = true;
      do
      {
         if (current.getValue() == task)
         {
            // Ok so we found a match. Check the parent and child nodes
            // to know how to remove it.
            if (current == head)
            {
               head = head.getNext();
            }
            else if (current == tail)
            {
               tail = tail.getPrevious();
            }
            else
            {
               INode<T> parent = current.getPrevious();
               INode<T> child = current.getNext();
               parent.setNext(child);
               child.setPrevious(parent);
            }
            notFound = false;
         }
      } while (notFound);
      return !notFound;
   }

   @Override
   public boolean remove(INode<T> node)
   {
      // TODO finish this
      INode<T> current = this.head;
      boolean notFound = true;
      do
      {
         if (current == node)
         {
            
            notFound = false;
         }
      } while (notFound);
      return !notFound;
   }

   @Override
   public boolean remove(int index)
   {
      // TODO Auto-generated method stub
      boolean retVal = false;
      return retVal;
   }

   @Override
   public boolean removeFirst()
   {
      // TODO Auto-generated method stub
      boolean retVal = false;
      return retVal;
   }

   @Override
   public boolean removeLast()
   {
      // TODO Auto-generated method stub
      boolean retVal = false;
      return retVal;
   }

}
