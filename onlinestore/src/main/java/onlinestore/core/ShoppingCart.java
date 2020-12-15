package onlinestore.core;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ShoppingCart implements Iterable<Item>{

  private Collection<Item> items = new ArrayList<>();

  public void addItem(Item item){
    items.add(item);
  }

  public void removeItem(Item item){
    if(this.items.contains(item))
      items.remove(item);
  }

  public Collection<Item> getItems(){
    return items;
  }


  @Override public Iterator<Item> iterator() {
    return items.iterator();
  }
}
