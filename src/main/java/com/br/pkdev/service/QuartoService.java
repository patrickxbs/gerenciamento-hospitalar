package com.br.pkdev.service;

import com.br.pkdev.model.Quarto;
import com.br.pkdev.model.enums.TipoQuarto;
import com.br.pkdev.persistence.QuartoRepository;

import java.util.ArrayList;
import java.util.List;

public class QuartoService {

    private final QuartoRepository quartoRepository;

    public QuartoService(QuartoRepository quartoRepository) {
        this.quartoRepository = quartoRepository;
    }

    public Quarto salvar(Quarto quarto) {
        return quartoRepository.criarQuarto(quarto);
    }

    public List<Quarto> listar() {
        return quartoRepository.listarQuartos();
    }

    public List<Quarto> listarQuartosComVaga() {
        return quartoRepository.listarQuartosComVaga();
    }

    public void criarQuartos() {
        Quarto q1 = new Quarto("101", 2, TipoQuarto.ENFERMARIA);
        Quarto q2 = new Quarto("106", 2, TipoQuarto.ENFERMARIA);
        Quarto q3 = new Quarto("107", 3, TipoQuarto.ENFERMARIA);
        Quarto q4 = new Quarto("102", 1, TipoQuarto.UTI);
        Quarto q5 = new Quarto("103", 3, TipoQuarto.ISOLAMENTO);
        Quarto q6 = new Quarto("104", 2, TipoQuarto.PEDIATRICO);
        Quarto q7 = new Quarto("105", 4, TipoQuarto.EMERGENCIA);
        Quarto q8 = new Quarto("108", 1, TipoQuarto.EMERGENCIA);
        List<Quarto> quartoList = new ArrayList<>(List.of(q1, q2, q3, q4, q5, q6, q7, q8));
        quartoRepository.criarVariosQuartos(quartoList);
    }

     public Quarto buscarPorNumero(String numero) {
        return quartoRepository.buscarPorNumero(numero);
    }
}
