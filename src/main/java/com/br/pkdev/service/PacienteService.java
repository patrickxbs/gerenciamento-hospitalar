package com.br.pkdev.service;

import com.br.pkdev.model.Paciente;
import com.br.pkdev.persistence.PacienteRepository;

import java.util.List;

public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente cadastrar(Paciente paciente) {
        return pacienteRepository.salvarPaciente(paciente);
    }

    public List<Paciente> pacientes() {
        return pacienteRepository.listarPacientes();
    }

    public void removerPaciente(String cpf) {
        pacienteRepository.removerPaciente(cpf);
    }

    public Paciente buscarPorCpf(String cpf) {
    return pacienteRepository.buscarPorCpf(cpf);
    }
}
