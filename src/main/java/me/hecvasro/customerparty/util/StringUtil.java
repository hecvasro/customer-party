package me.hecvasro.customerparty.util;

/**
 * Collection of utils for {@link String strings}.
 *
 * @author hecvasro
 */
public final class StringUtil {

  /**
   * Checks whether the a {@link String string} is {@code null} or empty.
   *
   * @param s
   *   {@link String} that will be checked.
   *
   * @return True if the given {@link String string} is null or empty, or otherwise false.
   */
  public static boolean isNullOrEmpty(String s) {
    return ObjectUtil.isNull(s) || s.isEmpty();
  }

  /**
   * Returns a given {@link String string} if it isn't {@code null} or {@link String#isEmpty() empty}, throws an {@link
   * IllegalArgumentException exception} otherwise.
   *
   * @param s
   *   {@link String} that will be evaluated.
   * @param argumentName
   *   {@link String} that will be used for the message of the {@link IllegalArgumentException exception}.
   *
   * @throws IllegalArgumentException
   *   If {@code s} is {@code null} or empty..
   */
  public static String checkIsNotNullNorEmpty(String s, String argumentName) {
    if (isNullOrEmpty(s)) {
      throw new IllegalArgumentException(String.format("isNullOrEmpty(%1$s)", argumentName));
    }
    return s;
  }

  private StringUtil() {
  }
}
