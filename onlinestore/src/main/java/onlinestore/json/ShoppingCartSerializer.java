package onlinestore.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import onlinestore.core.Item;
import onlinestore.core.ShoppingCart;

import java.io.IOException;


public class ShoppingCartSerializer extends JsonSerializer<ShoppingCart> {

  /* format:
  * {shoppingCart [{
  *"category": "...", "itemname": "...", "brand":"..."
  * }
  * ]}
  *
  * */

  @Override public void serialize(ShoppingCart shoppingCart, JsonGenerator jGen, SerializerProvider serializerProvider)
      throws IOException {
    jGen.writeStartObject();
    jGen.writeArrayFieldStart("shoppingCart");
    for(Item item : shoppingCart){
      jGen.writeObject(item);
    }
    jGen.writeEndArray();
    jGen.writeEndObject();

  }
}
