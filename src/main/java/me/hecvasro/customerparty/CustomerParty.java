package me.hecvasro.customerparty;

import me.hecvasro.customerparty.util.ObjectUtil;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Helper responsible of identifying and finding eligible {@link Customer customers} for the party.
 *
 * @author hecvasro
 */
public final class CustomerParty {

  static CustomerParty create(Office office) {
    return new CustomerParty(office);
  }

  /**
   * Office where the party will take place.
   */
  private final Office office;

  private CustomerParty(Office office) {
    this.office = ObjectUtil.checkNotNull(office, "office");
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
    return Double.compare(distanceToOffice, this.office.eligibleRange()) <= 0;
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
