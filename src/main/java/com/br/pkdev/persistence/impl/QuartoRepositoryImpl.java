package com.br.pkdev.persistence.impl;

import com.br.pkdev.model.Quarto;
import com.br.pkdev.persistence.QuartoRepository;

import java.util.ArrayList;
import java.util.List;

public class QuartoRepositoryImpl implements QuartoRepository {

    List<Quarto> quartos = new ArrayList<>();

    @Override
    public Quarto criarQuarto(Quarto quarto) {
        quartos.add(quarto);
        return quarto;
    }

    @Override
    public List<Quarto> listarQuartos() {
        return quartos;
    }

    @Override
    public List<Quarto> listarQuartosComVaga() {
        List<Quarto> quartosComVaga = new ArrayList<>();
        for (Quarto q: quartos) {
            if (q.verificarDisponibilidade())
                quartosComVaga.add(q);
        }
        return quartosComVaga;
    }

    @Override
    public void criarVariosQuartos(List<Quarto> quartoList) {
        quartos.addAll(quartoList);
    }
}
