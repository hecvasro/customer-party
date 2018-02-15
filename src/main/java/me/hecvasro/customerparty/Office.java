package me.hecvasro.customerparty;

import me.hecvasro.customerparty.util.ObjectUtil;

import java.util.Objects;

/**
 * Represents an office of the company.
 *
 * @author hecvasro
 */
public final class Office {

  public static Office create(Coordinates coordinates) {
    return new Office(coordinates);
  }

  public static final Office HQ = create(Coordinates.create(53.339428, -6.257664));

  /**
   * Office's coordinates.
   */
  private final Coordinates coordinates;

  private Office(Coordinates coordinates) {
    this.coordinates = ObjectUtil.checkNotNull(coordinates, "coordinates");
  }

  /**
   * Office's coordinates.
   */
  public final Coordinates coordinates() {
    return this.coordinates;
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
    return this.coordinates.equals(that.coordinates);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.coordinates);
  }
}
