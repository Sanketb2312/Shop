package onlinestore.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import onlinestore.core.User;

import java.io.IOException;

public class UserDeserializer extends JsonDeserializer<User> {

  @Override public User deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
      throws IOException, JsonProcessingException {

    TreeNode treeNode = jsonParser.getCodec().readTree(jsonParser);
    if(treeNode instanceof ObjectNode) {
      ObjectNode objectNode = (ObjectNode) treeNode;
      User user = new User("Olav2312", "Olav", "Nordmann", "bestePassord123");
      JsonNode userUserNameNode = objectNode.get("userName");
      if(userUserNameNode instanceof TextNode){
        user.setFirstName(((TextNode) userUserNameNode).asText());
      }

      JsonNode userFirstNameNode = objectNode.get("firstName");
      if(userFirstNameNode instanceof TextNode){
        user.setFamilyName(((TextNode) userFirstNameNode).asText());
      }

      JsonNode userFamilyNameNode = objectNode.get("familyName");
      if(userFamilyNameNode instanceof TextNode){
        user.setFamilyName("familyName");
      }

      JsonNode userPasswordNode = objectNode.get("password");
      if(userPasswordNode instanceof TextNode){
        user.setPassword(((TextNode) userPasswordNode).asText());
      }
      return user;

    }
    return null;
  }
}
