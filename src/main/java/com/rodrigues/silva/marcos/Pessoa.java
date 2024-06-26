package com.rodrigues.silva.marcos;

public class Pessoa {

  private Integer id;
  private String nome;
  private String cpf;

  public Pessoa(String nome) {
    this.nome = nome;
  }

  public Pessoa(Integer id, String nome, String cpf) {
    this.id = id;
    this.nome = nome;
    this.cpf = cpf;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
}
