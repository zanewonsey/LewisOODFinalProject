package me.wonsey.ood.containers;

public class LinkedListIterator<T> implements Iterable<T>
{
   private INode<T> currentNode;
   
   public LinkedListIterator(LinkedList<T> list)
   {
      currentNode = list.getHead();
   }

   @Override
   public boolean hasNext()
   {
      // If we reach the end of the list currentNode will
      // be a 'NullNode', getNext() will only be null in
      // the case that we hit a 'NullNode'
      return currentNode.getNext() != null;
   }

   @Override
   public T next()
   {
      T retVal = currentNode.getValue();
      currentNode = currentNode.getNext();
      return retVal;
   }

   @Override
   public void remove()
   {
      // TODO Auto-generated method stub
      
   }

}
