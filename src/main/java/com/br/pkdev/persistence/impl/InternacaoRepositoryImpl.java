package com.br.pkdev.persistence.impl;

import com.br.pkdev.model.Internacao;
import com.br.pkdev.persistence.InternacaoRepository;

import java.util.ArrayList;
import java.util.List;

public class InternacaoRepositoryImpl implements InternacaoRepository {

    List<Internacao> internacaoList = new ArrayList<>();

    @Override
    public Internacao salvarInternacao(Internacao internacao) {
        internacaoList.add(internacao);
        return internacao;
    }

    @Override
    public List<Internacao> listarInternacaoAtiva() {
        List<Internacao> internacoesAtivas = new ArrayList<>();
        for (Internacao i: internacaoList) {
            if (!i.isAlta()) {
                internacoesAtivas.add(i);
            }
        }
        return internacoesAtivas;
    }

    @Override
    public Internacao buscarInternacaoPorPacienteCpf(String cpf) {
        Internacao internacoaoPorPaciente = null;
        for (Internacao i: internacaoList) {
            if (i.getPaciente().getCpf().equals(cpf))
                internacoaoPorPaciente = i;
        }
        return internacoaoPorPaciente;
    }

}
