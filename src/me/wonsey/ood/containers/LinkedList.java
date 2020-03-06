package me.wonsey.ood.containers;

public class LinkedList<T> implements ILinkedList<T>
{
   
   private INode<T> head;
   private INode<T> tail;
   
   private INode<T> nullNode;
   
   public LinkedList()
   {
      nullNode = new NullNode<T>();
      this.head = nullNode;
      this.tail = nullNode;
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
   public boolean append(T item)
   {
      boolean retVal = false;
      INode<T> newNode = new Node<T>(item);
      
      if (this.head == nullNode)
      {
         this.head = newNode;
         this.tail = this.head;
      }
      else if (this.head == this.tail)
      {
         this.tail = newNode;
         this.tail.setPrevious(head);
         this.head.setNext(tail);
      }
      else
      {
         this.tail.setNext(newNode);
         this.tail.getNext().setPrevious(tail);
         this.tail = this.tail.getNext();
      }
      
      return retVal;
   }
   
   @Override
   public boolean remove(T item)
   {
      boolean isFound = false;
      INode<T> node = this.getHead();
      
      while (!isFound)
      {
         if (node == nullNode)
         {
            break;
         }
         else if (node.getValue() == item)
         {
            INode<T> prev = node.getPrevious();
            INode<T> next = node.getNext();
            
            if (prev != nullNode)
            {
               prev.setNext(next);
            }
            
            if (next != nullNode)
            {
               next.setPrevious(prev);
            }
            
            isFound = true;
         }
         else
         {
            node = node.getNext();
         }
      }
      
      return isFound;
   }
   

   @Override
   public Iterable<T> createIterator()
   {
      return new LinkedListIterator<T>(this);
   }
   
}
