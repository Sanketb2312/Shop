package onlinestore.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import onlinestore.core.Item;

import java.io.IOException;

public class ItemSerializer extends JsonSerializer<Item> {


  @Override public void serialize(Item item, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
      throws IOException {

    jsonGenerator.writeStartObject();
    jsonGenerator.writeStringField("category", item.getCategory());
    jsonGenerator.writeStringField("itemname", item.getItemName());
    jsonGenerator.writeStringField("brand", item.getBrand());
    jsonGenerator.writeEndObject();


  }
}
