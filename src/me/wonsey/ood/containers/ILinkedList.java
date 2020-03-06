package me.wonsey.ood.containers;

public interface ILinkedList<T>
{
   public INode<T> getHead();
   public INode<T> getTail();
   public boolean append(T item);
   public boolean remove(T item);
   public Iterable<T> createIterator();
}
