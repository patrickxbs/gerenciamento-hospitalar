package com.br.pkdev.service;

import com.br.pkdev.persistence.InternacaoRepository;

public class InternacaoSevice {

    private final InternacaoRepository internacaoRepository;

    public InternacaoSevice(InternacaoRepository internacaoRepository) {
        this.internacaoRepository = internacaoRepository;
    }
}
