package com.br.pkdev.Menus;


import com.br.pkdev.Menus.MenuPaciente;
import com.br.pkdev.model.Paciente;
import com.br.pkdev.model.enums.Doenca;
import com.br.pkdev.service.PacienteService;

import java.util.Scanner;

public class MenuPaciente {
    private final PacienteService pacienteService;
    public MenuPaciente(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }
    public void exibir(Scanner scanner) {
        while (true) {

            System.out.println("\n--- Menu Paciente ---");
            System.out.println("1 - Criar Paciente");
            System.out.println("2 - Listar Pacientes");
            System.out.println("3 - Remover Paciente");
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
                    System.out.print("Gravidade: ");
                    int gravidade = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Qual sua doença:");
                    System.out.println("1 - Virose");
                    System.out.println("2 - Fratura");
                    System.out.println("3 - Dor no Corpo");
                    System.out.println("4 - Alergia");
                    System.out.println("5 - Queimadura");
                    System.out.print("Digite um número: ");
                    int num = scanner.nextInt();
                    scanner.nextLine();
                    Doenca doenca = null;
                    switch (num) {
                        case 1:
                            doenca = Doenca.ALERGIA;
                            break;
                        case 2: 
                            doenca = Doenca.FRATURA;
                            break;
                        case 3:
                            doenca = Doenca.DOR_NO_CORPO;
                            break;
                        case 4:
                            doenca = Doenca.ALERGIA;
                            break;
                        case 5:
                            doenca = Doenca.QUEIMADURA;
                            break;
                        default:
                            System.out.print("Opção inválida. Tente novamente \n");
                            
                    }
                    System.out.print("Estado de Saude do Paciente: ");
                    String estadoDeSaude = scanner.nextLine();
                    
                    
                    Paciente paciente = new Paciente(nome, cpf, idade, telefone, gravidade, doenca, estadoDeSaude);
                    pacienteService.cadastrar(paciente);
                    break;
                    
                case 2:
                    pacienteService.pacientes().forEach(System.out::println);
                    if (pacienteService.pacientes().isEmpty()) {
                        System.out.println("Não existem pacientes cadastrados");
                    }
                    break;

                case 3:
                    System.out.println("Informe o cpf: ");
                    String cpfRemovido = scanner.nextLine();
                    if(pacienteService.buscarPorCpf(cpfRemovido) == null){
                        System.out.println("Não existe Paciente cadastrado com esse CPF");
                    }
                    pacienteService.removerPaciente(cpfRemovido);
                    break;
                case 0:
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
