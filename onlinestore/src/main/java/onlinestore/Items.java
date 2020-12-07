package onlinestore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Items {

  private String category;
  private Collection<Items> itemsList = new ArrayList<>();

  public Items(String category) {
    this.category = category;
  }

}



