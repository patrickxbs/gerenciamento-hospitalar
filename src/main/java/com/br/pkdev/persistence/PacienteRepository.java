package com.br.pkdev.persistence;

import com.br.pkdev.model.Paciente;

import java.util.List;

public interface PacienteRepository {

    Paciente salvarPaciente(Paciente paciente);

    List<Paciente> listarPacientes();

    void removerPaciente(String cpf);
}
