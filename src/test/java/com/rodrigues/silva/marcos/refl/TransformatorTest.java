package com.rodrigues.silva.marcos.refl;

import com.rodrigues.silva.marcos.Endereco;
import com.rodrigues.silva.marcos.Pessoa;
import com.rodrigues.silva.marcos.PessoaDTO;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

public class TransformatorTest {

  Pessoa pessoa = new Pessoa(1, "João", "1234");
  Endereco endereco = new Endereco("Rua 10", 20);

  @Test
  public void shouldTransform() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    Transformator transformator = new Transformator();
    PessoaDTO pessoaDTO = transformator.transform(pessoa);

    assertInstanceOf(PessoaDTO.class, pessoaDTO);
    assertEquals(pessoa.getNome(), pessoaDTO.getNome());
    assertEquals(pessoa.getCpf(), pessoaDTO.getCpf());
  }

  @Test
  public void shouldNotTransform() {
    assertThrows(ClassNotFoundException.class, () -> {
      Transformator transformator = new Transformator();
      transformator.transform(endereco);
    });
  }

  @Test
  public void shouldTransformWhenSomeFieldIsNull() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    Pessoa pessoaSemCpf = new Pessoa("Fulano");

    Transformator transformator = new Transformator();
    PessoaDTO pessoaDTOSemCpf = transformator.transform(pessoaSemCpf);

    assertEquals(pessoaSemCpf.getNome(), pessoaDTOSemCpf.getNome());
    assertNull(pessoaDTOSemCpf.getCpf());
  }
}
