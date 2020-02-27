package me.wonsey.ood.containers;

public interface INode<T>
{
   public T getValue();
   public void setValue(T value);
   
   public INode<T> getPrevious();
   public void setPrevious(INode<T> node);
   
   public INode<T> getNext();
   public void setNext(INode<T> node);
   
   public String toString();
}
