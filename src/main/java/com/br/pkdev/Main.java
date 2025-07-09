package com.br.pkdev;

import com.br.pkdev.persistence.impl.InternacaoRepositoryImpl;
import com.br.pkdev.persistence.impl.MedicoRepositoryImpl;
import com.br.pkdev.model.Internacao;
import com.br.pkdev.model.Medico;
import com.br.pkdev.model.Paciente;
import com.br.pkdev.model.Quarto;
import com.br.pkdev.model.enums.Doenca;
import com.br.pkdev.model.enums.Especialidade;
import com.br.pkdev.model.enums.TipoQuarto;
import com.br.pkdev.persistence.impl.PacienteRepositoryImpl;
import com.br.pkdev.persistence.impl.QuartoRepositoryImpl;
import com.br.pkdev.service.InternacaoSevice;
import com.br.pkdev.service.MedicoService;
import com.br.pkdev.service.PacienteService;
import com.br.pkdev.service.QuartoService;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        MedicoService medicoService = new MedicoService(new MedicoRepositoryImpl());
        PacienteService pacienteService = new PacienteService(new PacienteRepositoryImpl());
        QuartoService quartoService = new QuartoService(new QuartoRepositoryImpl());
        InternacaoSevice internacaoSevice = new InternacaoSevice(new InternacaoRepositoryImpl());

        // Cria um paciente
        Paciente patrick = new Paciente("Patrick", "123456",20, "123456",
                3, Doenca.ALERGIA, "corceira no corpo todo");
        pacienteService.cadastrar(patrick);

        // Cria um medico
        Medico deivid = new Medico("Deivid", "123",21, "123456", "DVD1789", Especialidade.CLINICO_GERAL);
        medicoService.salvarMedico(deivid);

        // Cria um quarto
        Quarto quarto1 = new Quarto("101", 2, TipoQuarto.UTI);
        quartoService.salvar(quarto1);

        // Interna o paciente
        Internacao internacao = new Internacao(patrick, deivid, quarto1);
        internacaoSevice.internar(internacao);
        List<Internacao> internacoes = internacaoSevice.listarInternacaoAtiva();

        System.out.println("Listar quartos com vagas: ");
        List<Quarto> quartosAtivos = quartoService.listarQuartosComVaga();
        quartosAtivos.forEach(System.out::println);

        System.out.println("\n=== Antes da alta ===");
        for (Internacao i : internacoes) {
            System.out.println(i.getPaciente().getNome() + " - Alta: " + i.isAlta());
        }

        // Dá alta
        if (internacaoSevice.darAlta("123456")) {
            System.out.println("\n=== Depois da alta ===");
            for (Internacao i : internacoes) {
                System.out.println(i.getPaciente().getNome() + " - Alta: " + i.isAlta() + " em " + i.getDataAlta());
            }
        }
    }
}

