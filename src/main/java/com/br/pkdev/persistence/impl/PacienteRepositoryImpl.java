package com.br.pkdev.persistence.impl;

import com.br.pkdev.persistence.PacienteRepository;
import com.br.pkdev.model.Paciente;

import java.util.ArrayList;
import java.util.List;

public class PacienteRepositoryImpl implements PacienteRepository {

    List<Paciente> pacientes = new ArrayList<>();

    @Override
    public void salvarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    @Override
    public List<Paciente> listarPacientes() {
        return pacientes;
    }

    @Override
    public void removerPacienteDeAlta(Paciente paciente) {
        pacientes.remove(paciente);
    }

    @Override
    public void removerPaciente(String cpf) {
        pacientes.removeIf(p -> p.getCpf().equals(cpf));
    }
}
