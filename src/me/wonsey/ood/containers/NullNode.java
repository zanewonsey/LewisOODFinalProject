package me.wonsey.ood.containers;

public class NullNode<T> implements INode<T>
{

   @Override
   public T getValue()
   {
      return null;
   }

   @Override
   public void setValue(T value)
   {
   }

   @Override
   public INode<T> getPrevious()
   {
      return null;
   }

   @Override
   public void setPrevious(INode<T> node)
   {
   }

   @Override
   public INode<T> getNext()
   {
      return null;
   }

   @Override
   public void setNext(INode<T> node)
   {
   }

}
