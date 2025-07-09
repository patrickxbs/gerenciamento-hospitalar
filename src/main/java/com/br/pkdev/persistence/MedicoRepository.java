package com.br.pkdev.persistence;

import com.br.pkdev.model.Medico;
import com.br.pkdev.model.enums.Especialidade;

import java.util.List;

public interface MedicoRepository {

    Medico salvarMedico(Medico medico);

    List<Medico> listarMedicos();

    List<Medico> listarMedicosPorEspecialidades(Especialidade especialidade);
}
