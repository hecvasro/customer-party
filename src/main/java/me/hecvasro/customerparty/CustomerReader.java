package me.hecvasro.customerparty;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.hecvasro.customerparty.util.ObjectUtil;
import me.hecvasro.customerparty.util.StringUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Reader implementation that reads a {@link List list} of {@link Customer customers} from given a {@link BufferedReader
 * reader} of JSON strings.
 *
 * @author hecvasro
 */
public final class CustomerReader {

  public static CustomerReader create() {
    return new CustomerReader();
  }

  private final Gson gson;

  private CustomerReader() {
    this.gson = new GsonBuilder()
      .registerTypeAdapter(Customer.class, CustomerDeserializer.create())
      .create();
  }

  /**
   * Reads a {@link List list} of {@link Customer customers} from given a {@link BufferedReader reader} of JSON
   * strings.
   *
   * @param reader
   *   {@link Reader} from which the list of customers will be read.
   *
   * @return {@link List} of {@link Customer customers} read from given thelink BufferedReader reader} of JSON strings.
   *
   * @throws NullPointerException
   *   If {@code reader} is {@code null}.
   */
  public final List<Customer> read(BufferedReader reader) throws IOException {
    ObjectUtil.checkNotNull(reader, "reader");
    final List<Customer> customers = new ArrayList<>();
    String line;
    while (!StringUtil.isNullOrEmpty(line = reader.readLine())) {
      customers.add(this.gson.fromJson(line, Customer.class));
    }
    reader.close();
    return customers;
  }
}
