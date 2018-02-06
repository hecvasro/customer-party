package me.hecvasro.customerparty;

import me.hecvasro.customerparty.util.Data;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test cases for the {@link CustomerParty} class.
 *
 * @author hecvasro
 */
public final class CustomerPartyTest {

  private final CustomerParty customerParty;

  public CustomerPartyTest() {
    this.customerParty = CustomerParty.create(Office.create(Coordinates.create(0, 0), 100));
  }

  @Test(expected = NullPointerException.class)
  public final void isWithinEligibleRange_nullCustomer_shouldThrowNullPointerException() {
    this.customerParty.isWithinEligibleRange(null);
  }

  @Test
  public final void isWithinEligibleRange_notNullCustomerWithSameCoordinates_shouldReturnTrue() {
    assertTrue(this.customerParty.isWithinEligibleRange(Data.OBJECTS.get(0)));
  }

  @Test
  public final void isWithinEligibleRange_notNullCustomerWithDifferentCoordinatesWithinTheEligibleRange_shouldReturnTrue() {
    assertTrue(this.customerParty.isWithinEligibleRange(Data.OBJECTS.get(1)));
  }

  @Test
  public final void isWithinEligibleRange_notNullCustomerWithDifferentCoordinatesNotWithinTheEligibleRange_shouldReturnFalse() {
    assertFalse(this.customerParty.isWithinEligibleRange(Data.OBJECTS.get(2)));
  }
}
