package me.hecvasro.customerparty;

import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * {@link JsonDeserializer Deserializer} implementation that creates a {@link Customer} instance from a JSON string.
 *
 * @author hecvasro
 */
public final class CustomerDeserializer implements JsonDeserializer<Customer> {

  private static final String PROPERTY_ID = "user_id";
  private static final String PROPERTY_NAME = "name";
  private static final String PROPERTY_LATITUDE = "latitude";
  private static final String PROPERTY_LONGITUDE = "longitude";

  public static CustomerDeserializer create() {
    return new CustomerDeserializer();
  }

  private CustomerDeserializer() {
  }

  /**
   * Checks whether a given {@link JsonObject object} has a property of the given name and throws an {@link
   * JsonParseException exception} if that's not the case.
   *
   * @throws JsonParseException
   *   If {@code object} does not {@link JsonObject#has has} a property of the given name.
   */
  private static void checkHasProperty(JsonObject object, String propertyName) throws JsonParseException {
    if (!object.has(propertyName)) {
      throw new JsonParseException(String.format("!object.has(%1$s)", propertyName));
    }
  }

  /**
   * @throws JsonParseException
   *   If is not an {@link JsonElement#isJsonObject() object}.
   * @throws JsonParseException
   *   If does not has {@link #PROPERTY_ID}.
   * @throws JsonParseException
   *   If does not has {@link #PROPERTY_NAME}.
   * @throws JsonParseException
   *   If does not has {@link #PROPERTY_LATITUDE}.
   * @throws JsonParseException
   *   If does not has {@link #PROPERTY_LONGITUDE}.
   */
  @Override
  public Customer deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
    if (!json.isJsonObject()) {
      throw new JsonParseException("!json.isJsonObject()");
    }
    final JsonObject object = json.getAsJsonObject();
    checkHasProperty(object, PROPERTY_ID);
    final int id = object.get(PROPERTY_ID)
      .getAsInt();
    checkHasProperty(object, PROPERTY_NAME);
    final String name = object.get(PROPERTY_NAME)
      .getAsString();
    checkHasProperty(object, PROPERTY_LATITUDE);
    final double latitude = object.get(PROPERTY_LATITUDE)
      .getAsDouble();
    checkHasProperty(object, PROPERTY_LONGITUDE);
    final double longitude = object.get(PROPERTY_LONGITUDE)
      .getAsDouble();
    return Customer.create(id, name, Coordinates.create(latitude, longitude));
  }
}
