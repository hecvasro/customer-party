package me.hecvasro.customerparty.util;

import static java.lang.String.format;

/**
 * Collection of utils for {@link Object objects}.
 *
 * @author hecvasro
 */
public final class ObjectUtil {

  /**
   * Checks whether a given {@link Object object} is {@code null} or not.
   *
   * @param object
   *   {@link Object} that will be checked.
   *
   * @return True if the given {@link Object object} is {@code null}, false otherwise.
   */
  public static boolean isNull(Object object) {
    return object == null;
  }

  /**
   * Checks whether a given {@link Object object} is {@code null}.
   *
   * @param object
   *   {@link Object} that will be checked.
   *
   * @return True if the given {@link Object object} is not {@code null}, false otherwise.
   */
  public static boolean isNotNull(Object object) {
    return !isNull(object);
  }

  /**
   * Returns a given {@link T object} if it isn't {@code null}, throws an {@link NullPointerException exception}
   * otherwise.
   *
   * @param object
   *   {@link T Object} that will be evaluated.
   * @param argumentName
   *   {@link String} that will be used for the message of the {@link NullPointerException exception}.
   *
   * @throws NullPointerException
   *   If {@code object} is {@code null}.
   */
  public static <T> T checkNotNull(T object, String argumentName) {
    if (isNull(object)) {
      throw new NullPointerException(format("isNull(%1$s)", argumentName));
    }
    return object;
  }

  private ObjectUtil() {
  }
}
