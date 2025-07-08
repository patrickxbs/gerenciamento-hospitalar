package com.br.pkdev;

import com.br.pkdev.persistence.impl.MedicoRepositoryImpl;
import com.br.pkdev.model.Internacao;
import com.br.pkdev.model.Medico;
import com.br.pkdev.model.Paciente;
import com.br.pkdev.model.Pessoa;
import com.br.pkdev.model.Quarto;
import com.br.pkdev.model.enums.Doenca;
import com.br.pkdev.model.enums.Especialidade;
import com.br.pkdev.model.enums.TipoQuarto;
import com.br.pkdev.service.MedicoService;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Pessoa paciente = new Paciente("Patrick", "123456",20, "123456",
                3, Doenca.ALERGIA, "corceira no corpo todo");

        MedicoService medicoService = new MedicoService(new MedicoRepositoryImpl());

        Medico medico1 = new Medico("Emanuel", "123456",20, "123456", "EMA1789", Especialidade.CARDIOLOGIA);
        medicoService.salvarMedico(medico1);

        Medico medico2 = new Medico("Junior", "123456",45, "123456", "JUN4590", Especialidade.CARDIOLOGIA);
        medicoService.salvarMedico(medico2);

        Medico medico3 = new Medico("Leo", "123456",30, "123456", "LELU590", Especialidade.CLINICO_GERAL);
        medicoService.salvarMedico(medico3);

        List<Medico> medicos = medicoService.listarMedicos();
        List<Medico> listarPorEspecialidade = medicoService.listarPorEspecialidade(Especialidade.CARDIOLOGIA);

        medicos.forEach(System.out::println);
        System.out.println();
        listarPorEspecialidade.forEach(System.out::println);

        List<Internacao> internacoes = new ArrayList<>();

        // Cria um quarto
        Quarto quarto1 = new Quarto("101", 2, TipoQuarto.UTI);

        // Interna o paciente
        Internacao internacao = new Internacao((Paciente) paciente, medico1, quarto1);
        internacoes.add(internacao);

        System.out.println("\n=== Antes da alta ===");
        for (Internacao i : internacoes) {
            System.out.println(i.getPaciente().getNome() + " - Alta: " + i.isAlta());
        }

        // Dá alta
        darAlta("Patrick", internacoes);

        System.out.println("\n=== Depois da alta ===");
        for (Internacao i : internacoes) {
            System.out.println(i.getPaciente().getNome() + " - Alta: " + i.isAlta() + " em " + i.getDataAlta());
        }
    }
    public static void darAlta(String nomePaciente, List<Internacao> internacoes) {
    for (Internacao i : internacoes) {
        if (i.getPaciente().getNome().equalsIgnoreCase(nomePaciente) && !i.isAlta()) {
            i.registrarAlta();
            System.out.println("Alta registrada para " + nomePaciente);
            return;
        }
    }
    System.out.println("Nenhuma internação ativa encontrada para " + nomePaciente);
}
}

