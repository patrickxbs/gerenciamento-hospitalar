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
            switch (opcao) {
                case 1:
                    System.out.println("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.println("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.println("Idade: ");
                    int idade = scanner.nextInt();
                    System.out.println("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.println("Gravidade: ");
                    int gravidade = scanner.nextInt();
                    System.out.println("Qual sua doença:");
                    System.out.println("1 - Virose");
                    System.out.println("2- Fratura");
                    System.out.println("3 - Dor no Corpo");
                    System.out.println("4 - Alergia");
                    System.out.println("5 - Queimadura");
                    System.out.println("Digite um número: ");
                    int num = scanner.nextInt();
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
                            System.out.println("Opção inválida");
                            break;
                    }
                    String estadoDeSaude = scanner.nextLine();
                    
                    
                    Paciente paciente = new Paciente(nome, cpf, idade, telefone, gravidade, doenca, estadoDeSaude);
                    pacienteService.cadastrar(paciente);
                    
                    break;
                case 2:
                    pacienteService.pacientes();
                    break;
                case 3:
                    System.out.println("Informe o cpf: ");
                    String cpfRemovido = scanner.nextLine();
                    pacienteService.removerPaciente(cpfRemovido);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
