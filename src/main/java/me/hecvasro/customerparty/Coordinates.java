package me.hecvasro.customerparty;

import me.hecvasro.customerparty.util.ObjectUtil;

import java.util.Objects;

/**
 * Represents a point on the Earth.
 *
 * @author hecvasro
 */
public final class Coordinates {

  /**
   * Approximate Earth's radius in kilometers.
   */
  private static final double EARTH_RADIUS = 6371.0;

  /**
   * Creates an instance of a {@link Coordinates} with a given latitude and longitude.
   *
   * @return Instance of a {@link Coordinates} with a given latitude and longitude.
   */
  public static Coordinates create(double latitude, double longitude) {
    return new Coordinates(latitude, longitude);
  }

  private final double latitude;
  private final double longitude;

  private Coordinates(double latitude, double longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public final double latitude() {
    return this.latitude;
  }

  public final double longitude() {
    return this.longitude;
  }

  /**
   * Calculates the distance (in kilometers) to a given {@link Coordinates coordinates}.
   * <p>
   * <a href="https://en.wikipedia.org/wiki/Great-circle_distance">This</a> formula is used in order to calculate the
   * distance.
   *
   * @param coordinates
   *   {@link Coordinates} to which the distance will be calculated to.
   *
   * @return Distance (in kilometers) to the given {@link Coordinates coordinates}.
   */
  public final double calculateDistanceTo(Coordinates coordinates) {
    ObjectUtil.checkNotNull(coordinates, "coordinates");
    final double lat1 = Math.toRadians(this.latitude);
    final double lat2 = Math.toRadians(coordinates.latitude());
    final double lon1 = Math.toRadians(this.longitude);
    final double lon2 = Math.toRadians(coordinates.longitude());
    final double dlat = Math.abs(lat1 - lat2);
    final double dlon = Math.abs(lon1 - lon2);
    final double a = Math.pow(Math.sin(dlat / 2), 2.0);
    final double b = Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2.0);
    final double ca = 2 * Math.asin(Math.sqrt(a + b));
    return EARTH_RADIUS * ca;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (ObjectUtil.isNull(object)) {
      return false;
    }
    if (!(object instanceof Coordinates)) {
      return false;
    }
    final Coordinates other = (Coordinates) object;
    return Double.compare(this.latitude, other.latitude) == 0
      && Double.compare(this.longitude, other.longitude) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.latitude, this.longitude);
  }
}
