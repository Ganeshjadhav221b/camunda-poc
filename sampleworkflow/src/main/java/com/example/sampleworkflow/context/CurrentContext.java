package com.example.sampleworkflow.context;

/**
 * The Class CurrentContext.
 */
public class CurrentContext {

  /**
   * Instantiates a new current context.
   */
  private CurrentContext() {}

  /**
   * The Constant value.
   */
  private static final ThreadLocal<Object> value = new ThreadLocal<>();

  /**
   * Sets the.
   * @param context the context
   */
  public static void set(Object context) {
    value.set(context);
  }

  /**
   * Gets the.
   * @return the object
   */
  public static Object get() {
    return value.get();
  }

  /**
   * Removes the.
   */
  public static void remove() {
    value.remove();
  }
}
