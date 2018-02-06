package me.hecvasro.customerparty;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import me.hecvasro.customerparty.util.Data;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for the {@link CustomerDeserializer} class.
 *
 * @author hecvasro
 */
public final class CustomerDeserializerTest {

  private final Gson gson;

  public CustomerDeserializerTest() {
    this.gson = new GsonBuilder()
      .registerTypeAdapter(Customer.class, CustomerDeserializer.create())
      .create();
  }

  @Test(expected = JsonParseException.class)
  public final void fromJson_notNullStringWithoutIdOrNameOrCoordinates_shouldThrowJsonParseException() {
    this.gson.fromJson("{}", Customer.class);
  }

  @Test(expected = JsonParseException.class)
  public final void fromJson_notNullStringWithoutNameOrCoordinates_shouldThrowJsonParseException() {
    this.gson.fromJson("{\"user_id\":1}", Customer.class);
  }

  @Test(expected = JsonParseException.class)
  public final void fromJson_notNullStringWithoutCoordinates_shouldThrowJsonParseException() {
    this.gson.fromJson("{\"user_id\":1,\"name\":\"John Doe\"}", Customer.class);
  }

  @Test
  public final void fromJson_notNullString_shouldReturnCustomer() {
    assertEquals(Data.OBJECTS.get(0), this.gson.fromJson(Data.JSON_AS_LIST.get(0), Customer.class));
  }
}
