package me.hecvasro.customerparty.util;

import me.hecvasro.customerparty.Coordinates;
import me.hecvasro.customerparty.Customer;

import java.util.Arrays;
import java.util.List;

/**
 * @author hecvasro
 */
public final class Data {

  public static final List<Customer> OBJECTS;

  public static final String JSON;
  public static final List<String> JSON_AS_LIST;

  static {
    OBJECTS = Arrays.asList(
      Customer.create(1, "John Doe", Coordinates.create(0.0, 0.0)),
      Customer.create(2, "Jane Doe", Coordinates.create(0.5, 0.5)),
      Customer.create(3, "Derp", Coordinates.create(1.0, 1.0))
    );

    JSON = new StringBuilder()
      .append("{\"user_id\":1,\"name\":\"John Doe\",\"latitude\":0.0,\"longitude\":0.0}")
      .append("\n")
      .append("{\"user_id\":2,\"name\":\"Jane Doe\",\"latitude\":0.5,\"longitude\":0.5}")
      .append("\n")
      .append("{\"user_id\":3,\"name\":\"Derp\",\"latitude\":1.0,\"longitude\":1.0}")
      .toString();
    JSON_AS_LIST = Arrays.asList(JSON.split("[\\r\\n]+"));
  }

  private Data() {
  }
}
