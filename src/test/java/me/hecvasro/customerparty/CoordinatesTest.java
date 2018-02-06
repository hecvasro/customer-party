package me.hecvasro.customerparty;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test cases for the {@link Coordinates} class.
 *
 * @author hecvasro
 */
public final class CoordinatesTest {

  private static final double DELTA = Math.ulp(1.0);

  private static Coordinates createCoordinates(double value) {
    return Coordinates.create(value, value);
  }

  private final Coordinates coordinates;

  public CoordinatesTest() {
    this.coordinates = createCoordinates(0.0);
  }

  @Test(expected = NullPointerException.class)
  public final void calculateDistanceTo_nullCoordinates_shouldThrowNullPointerException() {
    this.coordinates.calculateDistanceTo(null);
  }

  @Test
  public final void calculateDistanceTo_sameInstance_shouldReturnZero() {
    assertEquals(0.0, this.coordinates.calculateDistanceTo(this.coordinates), DELTA);
  }

  @Test
  public final void calculateDistanceTo_notNullCoordinatesWithSameValues_shouldReturnZero() {
    assertEquals(0.0, this.coordinates.calculateDistanceTo(createCoordinates(0.0)), DELTA);
  }

  @Test
  public final void calculateDistanceTo_notNullCoordinatesWithDifferentValues_shouldReturnNonZero() {
    Coordinates a = createCoordinates(0.0);
    Coordinates b = createCoordinates(10.0);
    assertEquals(1569.0, Math.round(a.calculateDistanceTo(b)), DELTA);

    a = createCoordinates(42.42);
    b = createCoordinates(-24.24);
    assertEquals(10073, Math.round(a.calculateDistanceTo(b)), DELTA);
  }

  @Test
  public final void equals_nullCoordinates_shouldReturnFalse() {
    assertFalse(this.coordinates.equals(null));
  }

  @Test
  public final void equals_notNullCoordinatesWithDifferentValues_shouldReturnFalse() {
    assertFalse(this.coordinates.equals(createCoordinates(1.0)));
  }

  @Test
  public final void equals_sameCoordinatesInstance() {
    assertTrue(this.coordinates.equals(this.coordinates));
  }

  @Test
  public final void equals_notNullCoordinatesWithSameValues_shouldReturnTrue() {
    assertTrue(this.coordinates.equals(createCoordinates(0.0)));
  }
}
