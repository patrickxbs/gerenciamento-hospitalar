package com.br.pkdev.Menus;

import java.util.Scanner;
import com.br.pkdev.model.Medico;
import com.br.pkdev.model.enums.Especialidade;
import com.br.pkdev.service.MedicoService;

public class MenuMedico {
    private final MedicoService medicoService;
    public MenuMedico(MedicoService medicoService) {
        this.medicoService = medicoService;
    }
    public void exibir(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Menu Médico ---");
            System.out.println("1 - Criar Médico");
            System.out.println("2 - Listar Médicos");
            System.out.println("3 - Listar Médicos por Especialidade");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("CRM: ");
                    String crm = scanner.nextLine();
                    System.out.println("Qual a especialidade do Medico:");
                    System.out.println("1 - Cardiologista");
                    System.out.println("2 - Ortopedista");
                    System.out.println("3 - Neurologista");
                    System.out.println("4 - Clinico Geral");
                    System.out.println("5 - Pediatra");
                    System.out.print("Digite um número: ");
                    int num = scanner.nextInt();
                    Especialidade especialidade = null;
                    switch (num) {
                        case 1:
                            especialidade = Especialidade.CARDIOLOGIA;
                            break;
                        case 2: 
                            especialidade = Especialidade.ORTOPERDISTA;
                            break;
                        case 3:
                            especialidade = Especialidade.NEUROLOGISTA;
                            break;
                        case 4:
                            especialidade = Especialidade.CLINICO_GERAL;
                            break;
                        case 5:
                            especialidade = Especialidade.PEDIATRA;
                            break;
                        default:
                            System.out.println("Opção inválida");
                            break;
                    }
                    Medico medico = new Medico(nome, cpf, idade, telefone, crm, especialidade);
                    medicoService.salvarMedico(medico);
                    break;

                case 2:
                    medicoService.listarMedicos().forEach(System.out::println);
                    if (medicoService.listarMedicos().isEmpty()) {
                        System.out.println("Não existem medicos cadastrados");
                    }
                    break;

                case 3:
                    System.out.println("Qual a especialidade listar:");
                    System.out.println("1 - Cardiologistas");
                    System.out.println("2 - Ortopedistas");
                    System.out.println("3 - Neurologistas");
                    System.out.println("4 - Clinicos Gerais");
                    System.out.println("5 - Pediatras");
                    System.out.println("Digite um número: ");
                    int numAux = scanner.nextInt();
                    Especialidade especialidadeAux = null;
                    switch (numAux) {
                        case 1:
                            especialidadeAux = Especialidade.CARDIOLOGIA;
                            break;
                        case 2: 
                            especialidadeAux = Especialidade.ORTOPERDISTA;
                            break;
                        case 3:
                            especialidadeAux = Especialidade.NEUROLOGISTA;
                            break;
                        case 4:
                            especialidadeAux = Especialidade.CLINICO_GERAL;
                            break;
                        case 5:
                            especialidadeAux = Especialidade.PEDIATRA;
                            break;
                        default:
                            System.out.println("Opção inválida");
                            break;
                    }
                    if (especialidadeAux == null) {
                        System.out.println("Especialidade inválida.");
                        break;
                    }

                    var lista = medicoService.listarPorEspecialidade(especialidadeAux);
                    if (lista.isEmpty()) {
                        System.out.println("Não há médicos cadastrados nessa especialidade.");
                    } else {
                        lista.forEach(System.out::println);
                    }
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
