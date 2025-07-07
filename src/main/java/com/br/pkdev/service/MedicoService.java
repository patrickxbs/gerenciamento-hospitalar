package com.br.pkdev.service;

import com.br.pkdev.persistence.MedicoRepository;
import com.br.pkdev.model.Medico;
import com.br.pkdev.model.enums.Especialidade;

import java.util.List;

public class MedicoService {

    private MedicoRepository medicoGateway;

    public MedicoService(MedicoRepository medicoGateway) {
        this.medicoGateway = medicoGateway;
    }

    public void salvarMedico(Medico medico) {
        medicoGateway.salvarMedico(medico);
    }

    public List<Medico> listarMedicos() {
        return medicoGateway.listarMedicos();
    }

    public List<Medico> listarPorEspecialidade(Especialidade especialidade) {
        return medicoGateway.listarMedicosPorEspecialidades(especialidade);
    }
}
