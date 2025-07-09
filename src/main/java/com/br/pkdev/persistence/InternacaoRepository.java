package com.br.pkdev.persistence;

import com.br.pkdev.model.Internacao;

import java.util.List;

public interface InternacaoRepository {

    Internacao salvarInternacao(Internacao internacao);

    List<Internacao> listarInternacaoAtiva();

    Internacao buscarInternacaoPorPacienteCpf(String cpf);
}
