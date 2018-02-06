package me.hecvasro.customerparty;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test cases for the {@link Customer} class.
 *
 * @author hecvasro
 */
public final class CustomerTest {

  private static Customer createCustomer(int id) {
    return Customer.create(id, "John Doe", Coordinates.create(0.0, 0.0));
  }

  private final Customer customer;

  public CustomerTest() {
    this.customer = createCustomer(1);
  }

  @Test
  public final void equals_nullCustomer_shouldReturnFalse() {
    assertFalse(this.customer.equals(null));
  }

  @Test
  public final void equals_notNullCustomerWithDifferentId_shouldReturnFalse() {
    assertFalse(this.customer.equals(createCustomer(2)));
  }

  @Test
  public final void equals_sameCustomerInstance() {
    assertTrue(this.customer.equals(this.customer));
  }

  @Test
  public final void toString_shouldReturnStringRepresentation() {
    assertEquals(String.format("%1$s (%2$s)", this.customer.name(), this.customer.id()), this.customer.toString());
  }

  @Test
  public final void equals_notNullCustomerWithSameId_shouldReturnTrue() {
    assertTrue(this.customer.equals(createCustomer(1)));
  }

  @Test(expected = NullPointerException.class)
  public final void compareTo_nullCustomer_shouldThrowNullPointerException() {
    this.customer.compareTo(null);
  }

  @Test
  public final void compareTo_notNullCustomerWithSameId_shouldReturnZero() {
    assertTrue(this.customer.compareTo(createCustomer(1)) == 0);
  }

  @Test
  public final void compareTo_notNullCustomerWithLowerId_shouldReturnPositive() {
    assertTrue(this.customer.compareTo(createCustomer(0)) > 0);
  }

  @Test
  public final void compareTo_notNullCustomerWithIdHigherId_shouldReturnNegative() {
    assertTrue(this.customer.compareTo(createCustomer(2)) < 0);
  }
}
