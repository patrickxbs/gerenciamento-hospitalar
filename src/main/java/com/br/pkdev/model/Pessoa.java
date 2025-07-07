package com.br.pkdev.model;

import java.util.Objects;

public abstract class Pessoa {

    private String nome;
    private String cpf;
    private int idade;
    private String telefone;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, int idade, String telefone) {

        if (idade < 0) throw  new IllegalArgumentException("idade nao existe");

        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public  void apresentarDados() {
        System.out.println("Dados Pessoal:");
        System.out.println("Nome: " + nome);
        System.out.println("Telefone: " + telefone);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(cpf, pessoa.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }

}
