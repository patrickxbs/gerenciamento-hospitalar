package com.br.pkdev.service;

import com.br.pkdev.persistence.QuartoRepository;

public class QuartoService {

    private final QuartoRepository quartoRepository;

    public QuartoService(QuartoRepository quartoRepository) {
        this.quartoRepository = quartoRepository;
    }
}
