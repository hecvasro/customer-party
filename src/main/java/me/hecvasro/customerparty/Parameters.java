package me.hecvasro.customerparty;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.converters.FileConverter;

import java.io.File;

/**
 * @author hecvasro
 */
final class Parameters {

  static Parameters create() {
    return new Parameters();
  }

  @Parameter(
    names = "--file",
    description = "File from which the list of customers will be read.",
    converter = FileConverter.class
  )
  File file;

  private Parameters() {
  }
}
