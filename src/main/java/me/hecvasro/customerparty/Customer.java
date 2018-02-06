package me.hecvasro.customerparty;

import me.hecvasro.customerparty.util.ObjectUtil;
import me.hecvasro.customerparty.util.StringUtil;

import java.util.Objects;

/**
 * Represents a customer of the company.
 *
 * @author hecvasro
 */
public final class Customer implements Comparable<Customer> {

  public static Customer create(int id, String name, Coordinates coordinates) {
    return new Customer(id, name, coordinates);
  }

  /**
   * Customer's identifier.
   */
  private final int id;

  /**
   * Customer's name.
   */
  private final String name;

  /**
   * Customer's coordinates.
   */
  private final Coordinates coordinates;

  private Customer(int id, String name, Coordinates coordinates) {
    this.id = id;
    this.name = StringUtil.checkIsNotNullNorEmpty(name, "name");
    this.coordinates = ObjectUtil.checkNotNull(coordinates, "coordinates");
  }

  /**
   * Customer's identifier.
   */
  public final int id() {
    return this.id;
  }

  /**
   * Customer's name.
   */
  public final String name() {
    return this.name;
  }

  /**
   * Customer's coordinates.
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
    if (!(object instanceof Customer)) {
      return false;
    }
    final Customer that = (Customer) object;
    return this.id == that.id
      && this.name.equals(that.name)
      && this.coordinates.equals(that.coordinates);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name, this.coordinates);
  }

  @Override
  public String toString() {
    return String.format("%1$s (%2$s)", this.name, this.id);
  }

  /**
   * Compares by {@link #id}.
   *
   * @param that
   *   {@link Customer} to which will be compared.
   *
   * @return Negative integer if the id of the given customer is greater than its id, or positive integer if the id of
   * the given customer is less than its id, or zero if they're the same.
   */
  @Override
  public int compareTo(Customer that) {
    ObjectUtil.checkNotNull(that, "that");
    return this.id - that.id;
  }
}
