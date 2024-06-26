package com.rodrigues.silva.marcos.refl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Transformator {

  public <I, O> O transform(I input) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    Class<?> source = input.getClass();
    Class<?> target = Class.forName(source.getName() + "DTO");

    O targetClass = (O) target.getDeclaredConstructor().newInstance();

    Field[] sourcesFields = source.getDeclaredFields();
    Field[] targetFields = target.getDeclaredFields();

    Arrays
            .stream(sourcesFields)
            .forEach(sourcesField -> Arrays
                    .stream(targetFields)
                    .forEach(targetField -> {
                      validate(sourcesField, targetField);
                      try {
                        targetField.set(targetClass, sourcesField.get(input));
                      } catch (IllegalAccessException e) {
                        e.printStackTrace();
                      }
                    }
            )
    );
    return targetClass;
  }

  private void validate(Field sourceField, Field targetField) {
    if (sourceField.getName().equals(targetField.getName())
            && sourceField.getType().equals(targetField.getType())) {
      sourceField.setAccessible(true);
      targetField.setAccessible(true);
    }
  }
}
