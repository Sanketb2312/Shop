package onlinestore.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import onlinestore.core.User;

import java.io.IOException;

public class UserSerializer extends JsonSerializer<User> {
  @Override public void serialize(User user, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
      throws IOException {

    jsonGenerator.writeStartObject();
    jsonGenerator.writeStringField("username", user.getUsername());
    jsonGenerator.writeStringField("firstName", user.getFirstName());
    jsonGenerator.writeStringField("familyName", user.getFamilyName());
    jsonGenerator.writeStringField("password", user.getPassword());
    jsonGenerator.writeEndObject();

  }
}
