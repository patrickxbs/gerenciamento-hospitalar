package com.br.pkdev.model;

import com.br.pkdev.model.enums.Doenca;

import java.time.LocalDateTime;

public class Paciente extends Pessoa{

    private LocalDateTime dataEntrada;
    private int gravidade;
    private Doenca doenca;
    private String estadoDeSaude;

    public Paciente() {
        super();
    }

    public Paciente(String nome, String cpf, int idade, String telefone, int gravidade,
                    Doenca doenca, String estadoDeSaude) {
        super(nome, cpf, idade, telefone);
        this.dataEntrada = LocalDateTime.now();
        this.gravidade = gravidade;
        this.doenca = doenca;
        this.estadoDeSaude = estadoDeSaude;
    }

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public int getGravidade() {
        return gravidade;
    }

    public void setGravidade(int gravidade) {
        this.gravidade = gravidade;
    }

    public Doenca getDoenca() {
        return doenca;
    }

    public void setDoenca(Doenca doenca) {
        this.doenca = doenca;
    }

    public String getEstadoDeSaude() {
        return estadoDeSaude;
    }

    public void setEstadoDeSaude(String estadoDeSaude) {
        this.estadoDeSaude = estadoDeSaude;
    }

    public void atualizarDadosDeSaude(Integer novaGravidade, String novoEstadoDeSaude) {
        if (novaGravidade != null && novaGravidade >= 0) {
            this.gravidade = novaGravidade;
        }
        if (novoEstadoDeSaude != null && !novoEstadoDeSaude.isBlank()) {
            this.estadoDeSaude = novoEstadoDeSaude;
        }
    }


    @Override
    public void apresentarDados() {
        super.apresentarDados();
        System.out.println("Gravidade: " + gravidade);
    }

}
