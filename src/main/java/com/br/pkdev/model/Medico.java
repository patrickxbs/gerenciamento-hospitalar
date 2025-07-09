package com.br.pkdev.model;

import com.br.pkdev.model.enums.Especialidade;

public class Medico extends Pessoa{

    private String crm;
    private Especialidade especialidade;

    public Medico() {
        super();
    }

    public Medico(String nome, String cpf, int idade, String telefone, String crm, Especialidade especialidade) {
        super(nome, cpf, idade, telefone);
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public void apresentarDados() {
        super.apresentarDados();
        System.out.println("CRM: " + crm);
        System.out.println("Especialidade: " + especialidade);
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + ", CPF: " + getCpf() + ", Idade: " + getIdade() + ", Telefone: " + getTelefone() + ", CRM: " + crm + ", Especialidade: " + especialidade;
    }

}
