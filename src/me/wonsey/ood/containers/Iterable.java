package me.wonsey.ood.containers;

/**
 * Generic interface to make something iterable
 * @author Zane Wonsey
 *
 * @param <T>     Generic type of the collection to be iterated over
 */
public interface Iterable<T>
{
   /**
    * Returns whether there is another item in the collection
    * @return Whether there is another item in the collection
    */
   public boolean hasNext();
   
   /**
    * Returns the value of the current item in the collection 
    * @return value of the current item in the collection 
    */
   public T next();
   
   /**
    * Removes current item from the collection
    * @apiNote Likely unused
    */
   public void remove();
}
