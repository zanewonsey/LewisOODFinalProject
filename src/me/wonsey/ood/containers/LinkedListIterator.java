package me.wonsey.ood.containers;

/**
*
* The {@code LinkedListIterator<T>} class wraps a {@code LinkedList<T>}
* and provides methods to iterate through the list. The Generic type of
* the {@code LinkedListIterator<T>} must match the Generic type of {@code LinkedList<T>}
*
* @author  Zane Wonsey
*/
public class LinkedListIterator<T> implements Iterable<T>
{
   /**
    * 
    */
   private INode<T> currentNode;
   
   /**
    * Constructs a newly allocated {@code LinkedListIterator} object
    * that can be used to easily loop through a list.
    * 
    * @param list     {@code LinkedList<T>} to be iterated over
    */
   public LinkedListIterator(LinkedList<T> list)
   {
      currentNode = list.getHead();
   }

   /**
    * Returns whether or not there is another item in the list.
    */
   @Override
   public boolean hasNext()
   {
      // If we reach the end of the list currentNode will
      // be a 'NullNode', getNext() will only be null in
      // the case that we hit a 'NullNode'
      return currentNode.getNext() != null;
   }

   /**
    * Returns the value of the current node and moves the 'pointer' forward.
    */
   @Override
   public T next()
   {
      T retVal = currentNode.getValue();
      currentNode = currentNode.getNext();
      return retVal;
   }

   /**
    * Not Implemented.
    */
   @Override
   public void remove()
   {
      // TODO Auto-generated method stub
      
   }

}
