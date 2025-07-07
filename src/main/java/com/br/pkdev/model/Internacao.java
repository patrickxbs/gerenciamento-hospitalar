package com.br.pkdev.model;

import java.time.LocalDateTime;

public class Internacao {

    private LocalDateTime dataEntrada;
    private LocalDateTime dataAlta;
    private boolean alta;

    private Paciente paciente;
    private Medico medico;
    private Quarto quarto;

    public Internacao(Paciente paciente, Medico medico, Quarto quarto) {
        this.dataEntrada = LocalDateTime.now();
        this.paciente = paciente;
        this.medico = medico;
        if (!quarto.verificarDisponibilidade())
            throw new RuntimeException("Quarto indisponivel");
        quarto.ocupar();
        this.quarto = quarto;
        this.alta = false;
    }

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public LocalDateTime getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(LocalDateTime dataAlta) {
        this.dataAlta = dataAlta;
    }

    public boolean isAlta() {
        return alta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public void registarAlta() {
        this.alta = true;
        this.quarto.liberar();
        this.dataAlta = LocalDateTime.now();
    }

}
