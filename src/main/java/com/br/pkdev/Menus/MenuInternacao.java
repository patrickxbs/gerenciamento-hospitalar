package com.br.pkdev.Menus;

import com.br.pkdev.model.Internacao;
import com.br.pkdev.model.Medico;
import com.br.pkdev.model.Paciente;
import com.br.pkdev.model.Quarto;
import com.br.pkdev.service.InternacaoSevice;
import com.br.pkdev.service.MedicoService;
import com.br.pkdev.service.PacienteService;
import com.br.pkdev.service.QuartoService;

import java.util.List;
import java.util.Scanner;

public class MenuInternacao {
    private final InternacaoSevice internacaoService;
    private final PacienteService pacienteService;
    private final MedicoService medicoService;
    private final QuartoService quartoService;

    public MenuInternacao(InternacaoSevice internacaoService, PacienteService pacienteService,
                          MedicoService medicoService, QuartoService quartoService) {
        this.internacaoService = internacaoService;
        this.pacienteService = pacienteService;
        this.medicoService = medicoService;
        this.quartoService = quartoService;
    }

    public void exibir(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Menu Internação ---");
            System.out.println("1 - Internar Paciente");
            System.out.println("2 - Listar Internados");
            System.out.println("3 - Dar Alta em Paciente");
            System.out.println("4 - Atualizar Estado de Saúde");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    internarPaciente(scanner);
                    break;
                case 2:
                    listarInternados();
                    break;
                case 3:
                    darAlta(scanner);
                    break;
                case 4:
                    atualizarEstadoDeSaude(scanner);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void internarPaciente(Scanner scanner) {
        System.out.print("Digite o CPF do paciente: ");
        String cpfPaciente = scanner.nextLine();
        Paciente paciente = pacienteService.buscarPorCpf(cpfPaciente);
        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        System.out.print("Digite o CRM do médico: ");
        String crm = scanner.nextLine();
        Medico medico = medicoService.buscarPorCrm(crm);
        if (medico == null) {
            System.out.println("Médico não encontrado.");
            return;
        }

        System.out.print("Digite o número do quarto: ");
        String numero = scanner.nextLine();
        Quarto quarto = quartoService.buscarPorNumero(numero);
        if (quarto == null || quarto.getVagas() == 0) {
            System.out.println("Quarto inválido ou sem vagas.");
            return;
        }

        Internacao internacao = new Internacao(paciente, medico, quarto);
        internacaoService.internar(internacao);
        System.out.println("Paciente internado com sucesso.");
    }

    private void listarInternados() {
        List<Internacao> internados = internacaoService.listarInternacaoAtiva();
        if (internados.isEmpty()) {
            System.out.println("Nenhum paciente internado.");
        } else {
            for (Internacao i : internados) {
                System.out.println(i.getPaciente().getNome() + " - Quarto: " + i.getQuarto().getNumero());
            }
        }
    }

    private void darAlta(Scanner scanner) {
        System.out.print("Digite o CPF do paciente para dar alta: ");
        String cpf = scanner.nextLine();
        boolean sucesso = internacaoService.darAlta(cpf);
        if (sucesso) {
            System.out.println("Alta registrada com sucesso.");
        } else {
            System.out.println("Paciente não encontrado ou já teve alta.");
        }
    }

    private void atualizarEstadoDeSaude(Scanner scanner) {
        System.out.print("Digite o CPF do paciente: ");
        String cpf = scanner.nextLine();

        System.out.print("Nova gravidade (1-5): ");
        int gravidade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Descrição do estado de saúde: ");
        String descricao = scanner.nextLine();

        boolean sucesso = internacaoService.atualizarEstadoDeSaudeDoPaciente(cpf, gravidade, descricao);
        if (sucesso) {
            System.out.println("Estado de saúde atualizado com sucesso.");
        } else {
            System.out.println("Paciente não encontrado ou não está internado.");
        }
    }
}
