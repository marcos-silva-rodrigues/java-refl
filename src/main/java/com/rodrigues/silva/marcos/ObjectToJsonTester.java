package com.rodrigues.silva.marcos;

import com.rodrigues.silva.marcos.refl.ObjectToJson;

public class ObjectToJsonTester {

  public static void main(String... x) {
    Pessoa pessoa = new Pessoa(1, "João", "12345");
    ObjectToJson objectToJson = new ObjectToJson();
    System.out.println(objectToJson.transform(pessoa));
  }
}
