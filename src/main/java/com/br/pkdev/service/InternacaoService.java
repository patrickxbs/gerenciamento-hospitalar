package com.br.pkdev.service;

import com.br.pkdev.model.Internacao;
import com.br.pkdev.persistence.InternacaoRepository;

import java.util.List;

public class InternacaoService {

    private final InternacaoRepository internacaoRepository;

    public InternacaoService(InternacaoRepository internacaoRepository) {
        this.internacaoRepository = internacaoRepository;
    }

    public Internacao internar(Internacao internacao) {
        return internacaoRepository.salvarInternacao(internacao);
    }

    public List<Internacao> listarInternacaoAtiva() {
        return internacaoRepository.listarInternacaoAtiva();
    }

    public Internacao buscarInternacaoPorPacienteCpf(String cpf) {
        return internacaoRepository.buscarInternacaoPorPacienteCpf(cpf);
    }

    public boolean atualizarEstadoDeSaudeDoPaciente(String cpf, Integer gravidade, String estadoDeSaude) {
        Internacao internacao = buscarInternacaoPorPacienteCpf(cpf);
        if (internacao != null) {
            internacao.getPaciente().atualizarDadosDeSaude(gravidade, estadoDeSaude);
            return true;
        }
        return false;
    }

    public boolean darAlta(String cpf) {
        Internacao internacao = buscarInternacaoPorPacienteCpf(cpf);
        if (internacao != null) {
            internacao.registrarAlta();
            return true;
        }
        return false;
    }


}
