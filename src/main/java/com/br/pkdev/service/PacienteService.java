package com.br.pkdev.service;

import com.br.pkdev.persistence.PacienteRepository;

public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }
}
