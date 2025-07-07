package com.br.pkdev.persistence.impl;

import com.br.pkdev.persistence.MedicoRepository;
import com.br.pkdev.model.Medico;
import com.br.pkdev.model.enums.Especialidade;

import java.util.ArrayList;
import java.util.List;

public class MedicoRepositoryImpl implements MedicoRepository {

    List<Medico> medicos = new ArrayList<>();

    @Override
    public void salvarMedico(Medico medico) {
        medicos.add(medico);
    }

    @Override
    public List<Medico> listarMedicos() {
        return medicos;
    }

    @Override
    public List<Medico> listarMedicosPorEspecialidades(Especialidade especialidade) {
        return medicos.stream().filter(m -> m.getEspecialidade().equals(especialidade)).toList();
    }
}
