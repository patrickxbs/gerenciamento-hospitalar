package com.br.pkdev.model;

import com.br.pkdev.model.enums.TipoQuarto;

import java.util.Objects;

public class Quarto {

    private String numero;
    private int capacidadeTotal;
    private int vagas;
    private TipoQuarto tipoQuarto;

    public Quarto() {
    }

    public Quarto(String numero, int capacidadeTotal, TipoQuarto tipoQuarto) {
        this.numero = numero;

        if (capacidadeTotal < 1)
            throw new RuntimeException("O quarto tem que ter pelo menos uma vaga");
        this.capacidadeTotal = capacidadeTotal;
        this.vagas = 0;
        this.tipoQuarto = tipoQuarto;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getCapacidadeTotal() {
        return capacidadeTotal;
    }

    public void setCapacidadeTotal(int capacidadeTotal) {
        this.capacidadeTotal = capacidadeTotal;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }


    public TipoQuarto getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(TipoQuarto tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public boolean verificarDisponibilidade() {
        if (vagas == capacidadeTotal)
            return false;
        else return true;
    }

    public void ocupar() {
        if (verificarDisponibilidade())
            throw new RuntimeException("Capacidade máxima atingida");
        vagas++;
    }

    public void liberar() {
        if (vagas == 0)
            throw new RuntimeException("O quarto não possui paciente para liberar");
        vagas--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quarto quarto = (Quarto) o;
        return Objects.equals(numero, quarto.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numero);
    }


}
