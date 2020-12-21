package onlinestore.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import onlinestore.core.Item;

import java.io.IOException;

public class ItemDeserializer extends JsonDeserializer<Item> {
  @Override public Item deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
      throws IOException, JsonProcessingException {
    TreeNode treeNode = jsonParser.getCodec().readTree(jsonParser);
    return deserialize((JsonNode) treeNode);
  }

  public Item deserialize(JsonNode jsonNode)
      throws IOException, JsonProcessingException {

    if(jsonNode instanceof ObjectNode){
      ObjectNode objectNode = (ObjectNode) jsonNode;
      Item item = new Item("defaultCategory", "defualtItemName", "defaultBrand");
      JsonNode categoryNode = objectNode.get("category");
      if(categoryNode instanceof TextNode){
        item.setCategory(((TextNode) categoryNode).asText());
      }
      JsonNode itemNameNode = objectNode.get("itemname");
      if(itemNameNode instanceof TextNode){
        item.setItemName(((TextNode) itemNameNode).asText());
      }
      JsonNode brandNode = objectNode.get("brand");
      if(brandNode instanceof TextNode){
        item.setBrand(((TextNode) brandNode).asText());
      }

      return item;
    }
    return null;
  }



}
