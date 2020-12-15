package onlinestore.core;

import java.util.ArrayList;
import java.util.Collection;

public class Item {

  private String category;
  private Collection<Item> itemsList = new ArrayList<>();
  private String itemName;
  private String brand;

  public Item(String category, String itemName, String brand) {
    this.category = category;
    this.itemName = itemName;
    this.brand = brand;
  }

  public String getCategory() {
    return category;
  }

  public String getBrand() {
    return brand;
  }

  public String getItemName() {
    return itemName;
  }
}




