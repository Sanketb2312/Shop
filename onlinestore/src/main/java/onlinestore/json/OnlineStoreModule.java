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
      addSerializer(Item.class, new ItemSerializer());
      addDeserializer(ShoppingCart.class, new ShoppingCartDeserializer());
      addDeserializer(Item.class, new ItemDeserializer());
    }

   public static void main(String[] args){
     ObjectMapper mapper = new ObjectMapper();
     mapper.registerModule(new OnlineStoreModule());
     ShoppingCart shoppingCart = new ShoppingCart();
     Item item1 = new Item("electronic", "Macbook pro", "Apple");
     //item1.setCategory("electronic");
     //item1.setItemName("Macbook pro");
     //item1.setBrand("Apple");
     Item item2 = new Item("electronic", "Surfacebook" , "Microsoft");
     //item2.setCategory("electronic");
     //item2.setItemName("Surfacebook");
     //item1.setBrand("Microsoft");


     shoppingCart.addItem(item1);
     shoppingCart.addItem(item2);
    try {
      String json = mapper.writeValueAsString(shoppingCart);
      ShoppingCart shoppingCart1 = mapper.readValue(json, ShoppingCart.class);
      for(Item item : shoppingCart1){
        System.out.println(item.getCategory());
        System.out.println(item.getItemName());
        System.out.println(item.getBrand());
      }
      System.out.println(shoppingCart1);
     } catch (JsonProcessingException e) {
       e.printStackTrace();
     }


   }
  }
