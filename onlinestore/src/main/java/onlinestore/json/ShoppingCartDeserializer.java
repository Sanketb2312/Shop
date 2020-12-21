package onlinestore.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import onlinestore.core.Item;
import onlinestore.core.ShoppingCart;

import java.io.IOException;
//format:
//"{\"shoppingCart\":[{\"category\":\"electronic\",\"itemName\":\"Macbook pro\",\"brand\":\"Apple\"},{\"category\":\"electronic\",\"itemName\":\"Surfacebook\",\"brand\":\"Microsoft\"}]}",

public class ShoppingCartDeserializer extends JsonDeserializer<ShoppingCart> {

  private ItemDeserializer itemDeserializer = new ItemDeserializer();

  @Override public ShoppingCart deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
      throws IOException, JsonProcessingException {
    TreeNode treeNode = jsonParser.getCodec().readTree(jsonParser);
    if(treeNode instanceof ObjectNode){
      ObjectNode objectNode = (ObjectNode) treeNode;
      ShoppingCart shoppingCart = new ShoppingCart();
      JsonNode shoppingCartNode = objectNode.get("shoppingCart");
      if(shoppingCartNode instanceof ArrayNode){
        for(JsonNode itemElement : (ArrayNode) shoppingCartNode){
          Item item = itemDeserializer.deserialize(itemElement);
          if(item != null){
            shoppingCart.addItem(item);
          }
        }
      }
      return shoppingCart;
    }
return null;
  }
}
