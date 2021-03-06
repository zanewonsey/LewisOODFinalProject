package me.wonsey.ood.containers;

public class Node<T> implements INode<T>
{
   private INode<T> previous;
   private INode<T> next;
   private T value;
   
   private INode<T> nullNode;
   
   public Node(T value)
   {
      nullNode = new NullNode<T>();
      this.value = value;
      this.next = nullNode;
      this.previous = nullNode;
   }

   @Override
   public T getValue()
   {
      return value;
   }
   
   @Override
   public void setValue(T value)
   {
      this.value = value;
   }

   @Override
   public INode<T> getPrevious()
   {
      return previous;
   }
   
   @Override
   public void setPrevious(INode<T> node)
   {
      this.previous = node;
   }

   @Override
   public INode<T> getNext()
   {
      return next;
   }

   @Override
   public void setNext(INode<T> node)
   {
      this.next = node;
   }
   
   public String toString()
   {
      return "";
   }

}
