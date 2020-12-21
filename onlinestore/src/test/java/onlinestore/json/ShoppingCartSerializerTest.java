package onlinestore.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import onlinestore.core.Item;
import onlinestore.core.ShoppingCart;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ShoppingCartSerializerTest {

  private static ObjectMapper mapper;

  @BeforeAll
  public static void setUp() {
    mapper = new ObjectMapper();
    mapper.registerModule(new OnlineStoreModule());

  }

  @Test public void testShoppingCartSerializer() {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new OnlineStoreModule());
    ShoppingCart shoppingCart = new ShoppingCart();
    Item item1 = new Item("electronic", "Macbook pro", "Apple");
    Item item2 = new Item("electronic", "Surfacebook", "Microsoft");
    shoppingCart.addItem(item1);
    shoppingCart.addItem(item2);
    try {
      assertEquals("{\"shoppingCart\":[{\"category\":\"electronic\",\"itemname\":\"Macbook pro\",\"brand\":\"Apple\"},{\"category\":\"electronic\",\"itemname\":\"Surfacebook\",\"brand\":\"Microsoft\"}]}",
          mapper.writeValueAsString(shoppingCart));
    } catch (JsonProcessingException e) {
      fail();
    }
  }
}
