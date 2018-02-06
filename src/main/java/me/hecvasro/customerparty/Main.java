package me.hecvasro.customerparty;

import com.beust.jcommander.JCommander;
import me.hecvasro.customerparty.util.ObjectUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

/**
 * Entry point of the application.
 *
 * @author hecvasro
 */
public final class Main {

  public static void main(String[] args) {
    final Parameters parameters = Parameters.create();

    final JCommander commander = JCommander.newBuilder()
      .programName("customer-party")
      .addObject(parameters)
      .build();
    commander.parse(args);

    final File file = parameters.file;
    if (ObjectUtil.isNull(file)) {
      commander.usage();
    } else {
      try {
        final CustomerReader customerReader = CustomerReader.create();
        final List<Customer> eligibleCustomers = CustomerParty.create(Office.HQ)
          .findEligibleCustomers(customerReader.read(new BufferedReader(new FileReader(file))));
        System.out.println("Eligible customers");
        for (Customer customer : eligibleCustomers) {
          System.out.println(customer.toString());
        }
      } catch (Exception exception) {
        exception.printStackTrace(System.err);
      }
    }
  }
}
