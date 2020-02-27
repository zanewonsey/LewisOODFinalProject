package me.wonsey.ood.containers;

public interface ILinkedList<T>
{
   public INode<T> getHead();
   public INode<T> getTail();
   public boolean append(INode<T> node);
   public boolean add(INode<T> node);
   public boolean remove(T task);
   public boolean remove(INode<T> node);
   public boolean remove(int index);
   public boolean removeFirst();
   public boolean removeLast();
}
