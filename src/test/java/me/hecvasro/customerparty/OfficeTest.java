package me.hecvasro.customerparty;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test cases for the {@link Office} class.
 *
 * @author hecvasro
 */
public final class OfficeTest {

  private static Office createOffice(double value) {
    return Office.create(Coordinates.create(value, value));
  }

  private final Office office;

  public OfficeTest() {
    this.office = createOffice(0.0);
  }

  @Test
  public final void equals_nullOffice_shouldReturnFalse() {
    assertFalse(this.office.equals(null));
  }

  @Test
  public final void equals_notNullOfficeWithDifferentValue_shouldReturnFalse() {
    assertFalse(this.office.equals(createOffice(1.0)));
  }

  @Test
  public final void equals_sameOfficeInstance() {
    assertTrue(this.office.equals(this.office));
  }

  @Test
  public final void equals_notNullOfficeWithSameValue_shouldReturnTrue() {
    assertTrue(this.office.equals(createOffice(0.0)));
  }
}
