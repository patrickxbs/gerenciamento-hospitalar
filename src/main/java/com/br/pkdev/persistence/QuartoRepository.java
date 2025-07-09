package com.br.pkdev.persistence;

import com.br.pkdev.model.Quarto;

import java.util.List;

public interface QuartoRepository {

    Quarto criarQuarto(Quarto quarto);

    List<Quarto> listarQuartos();

    List<Quarto> listarQuartosComVaga();

    void criarVariosQuartos(List<Quarto> quartoList);
}
