package com.br.pkdev.persistence;

import com.br.pkdev.model.Paciente;

import java.util.List;

public interface PacienteRepository {

    void salvarPaciente(Paciente paciente);

    List<Paciente> listarPacientes();

    void removerPacienteDeAlta(Paciente paciente);

    void removerPaciente(String cpf);
}
