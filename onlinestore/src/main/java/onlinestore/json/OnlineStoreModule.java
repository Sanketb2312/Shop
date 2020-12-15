package onlinestore.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.VersionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import onlinestore.core.Item;
import onlinestore.core.ShoppingCart;

 public class OnlineStoreModule extends SimpleModule {
    private static final String NAME = "CustomIntervalModule";
    private static final VersionUtil VERSION_UTIL = new VersionUtil() {};

    public OnlineStoreModule() {
      //super(NAME, VERSION_UTIL.version());
      addSerializer(ShoppingCart.class, new ShoppingCartSerializer());
    }

   public static void main(String[] args){
     ObjectMapper mapper = new ObjectMapper();
     mapper.registerModule(new OnlineStoreModule());
     ShoppingCart shoppingCart = new ShoppingCart();
     Item item1 = new Item("electronic", "Macbook pro", "Apple");
     Item item2 = new Item("electronic", "Surfacebook", "Microsoft");
     shoppingCart.addItem(item1);
     shoppingCart.addItem(item2);
    try {
      System.out.println(mapper.writeValueAsString(shoppingCart));
     } catch (JsonProcessingException e) {
       e.printStackTrace();
     }


   }
  }
