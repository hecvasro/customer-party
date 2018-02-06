package me.hecvasro.customerparty;

import me.hecvasro.customerparty.util.Data;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for the {@link CustomerReader} class.
 *
 * @author hecvasro
 */
public final class CustomerReaderTest {

  private static BufferedReader createReader(String s) {
    return new BufferedReader(new StringReader(s));
  }

  private final CustomerReader mapper;

  public CustomerReaderTest() {
    this.mapper = CustomerReader.create();
  }

  @Test(expected = NullPointerException.class)
  public final void read_nullReader_shouldThrowNullPointerException() throws IOException {
    this.mapper.read(null);
  }

  @Test
  public final void read_notNullReader_shouldReturnList() throws IOException {
    assertEquals(Data.OBJECTS, this.mapper.read(createReader(Data.JSON)));
  }
}
