package me.hecvasro.customerparty;

import me.hecvasro.customerparty.util.ObjectUtil;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Helper responsible of identifying and finding eligible {@link Customer customers} a the party.
 *
 * @author hecvasro
 */
public final class CustomerParty {

  /**
   * Default eligible range (in kilometers) for parties.
   */
  public static final double DEFAULT_ELIGIBLE_RANGE = 100.0;

  static CustomerParty create(Office office, double eligibleRange) {
    return new CustomerParty(office, eligibleRange);
  }

  static CustomerParty create(Office office) {
    return create(office, DEFAULT_ELIGIBLE_RANGE);
  }

  /**
   * Office where the party will take place.
   */
  private final Office office;

  /**
   * Range (in kilometers) used to check if {@link Customer customers} are eligible for the party.
   */
  private final double eligibleRange;

  private CustomerParty(Office office, double eligibleRange) {
    this.office = ObjectUtil.checkNotNull(office, "office");
    this.eligibleRange = eligibleRange;
  }

  /**
   * Checks whether a given {@link Customer customer} is within the eligible range to be invited to the party or not.
   *
   * @param customer
   *   {@link Customer} that will be checked.
   *
   * @return True if the given {@link Customer customer} is within the eligible range to be invited, false otherwise.
   */
  final boolean isWithinEligibleRange(Customer customer) {
    ObjectUtil.checkNotNull(customer, "customer");
    final double distanceToOffice = this.office.coordinates()
      .calculateDistanceTo(customer.coordinates());
    return Double.compare(distanceToOffice, this.eligibleRange) <= 0;
  }

  /**
   * Builds a {@link List list} of {@link Customer customers} from a given list that are within the eligible range to be
   * invited to the party.
   *
   * @return {@link List list} of {@link Customer customers} from the given list that are within the eligible range to
   * be invited to the party.
   */
  public final List<Customer> findEligibleCustomers(List<Customer> customers) {
    return ObjectUtil.checkNotNull(customers, "customers")
      .stream()
      .filter(this::isWithinEligibleRange)
      .sorted(Customer::compareTo)
      .collect(Collectors.toList());
  }
}
