package me.hecvasro.customerparty;

import me.hecvasro.customerparty.util.ObjectUtil;

import java.util.Objects;

/**
 * Represents an office of the company.
 *
 * @author hecvasro
 */
public final class Office {

  public static Office create(Coordinates coordinates, double eligibleRange) {
    return new Office(coordinates, eligibleRange);
  }

  public static final Office HQ = create(Coordinates.create(53.339428, -6.257664), 100);

  /**
   * Office's coordinates.
   */
  private final Coordinates coordinates;

  /**
   * Office's eligible range (in kilometers).
   */
  private final double eligibleRange;

  private Office(Coordinates coordinates, double eligibleRange) {
    this.coordinates = ObjectUtil.checkNotNull(coordinates, "coordinates");
    this.eligibleRange = eligibleRange;
  }

  /**
   * Office's coordinates.
   */
  public final Coordinates coordinates() {
    return this.coordinates;
  }

  /**
   * Office's eligible range (in kilometers).
   */
  public final double eligibleRange() {
    return this.eligibleRange;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (ObjectUtil.isNull(object)) {
      return false;
    }
    if (!(object instanceof Office)) {
      return false;
    }
    final Office that = (Office) object;
    return this.coordinates.equals(that.coordinates)
      && Double.compare(this.eligibleRange, that.eligibleRange) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.coordinates, this.eligibleRange);
  }
}
