package Lesson3;

import java.lang.reflect.Method;

public class ReflectionSample {

  private void someMethod() {

  }

  public static void main(String[] args) {

    Method[] methods = ReflectionSample.class.getMethods();

    for (Method m : methods) {
      System.out.println(m.getName());
    }
  }

}
