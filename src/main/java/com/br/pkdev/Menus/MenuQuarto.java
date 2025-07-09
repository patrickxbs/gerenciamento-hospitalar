package com.br.pkdev.Menus;

import java.util.Scanner;
import com.br.pkdev.model.Quarto;
import com.br.pkdev.model.enums.TipoQuarto;
import com.br.pkdev.service.QuartoService;

public class MenuQuarto {
    private final QuartoService quartoService;
    public MenuQuarto(QuartoService quartoService) {
        this.quartoService = quartoService;
    }
    public void exibir(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Menu Quarto ---");
            System.out.println("1 - Criar Quarto");
            System.out.println("2 - Listar Quartos");
            System.out.println("3 - Listar Quartos com Vaga");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Numero: ");
                    String numero = scanner.nextLine();
                    System.out.println("Capacidade total: ");
                    int capacidadeTotal = scanner.nextInt();
                    System.out.println("Qual o tipo de Quarto:");
                    System.out.println("1 - Enfermaria");
                    System.out.println("2- UTI");
                    System.out.println("3 - Isolamento");
                    System.out.println("4 - Pediatrico");
                    System.out.println("5 - Emergencia");
                    System.out.println("Digite um número: ");
                    int num = scanner.nextInt();
                    TipoQuarto tipoQuarto = null;
                    switch (num) {
                        case 1:
                            tipoQuarto = TipoQuarto.ENFERMARIA;
                            break;
                        case 2: 
                            tipoQuarto = TipoQuarto.UTI;
                            break;
                        case 3:
                            tipoQuarto = TipoQuarto.ISOLAMENTO;
                            break;
                        case 4:
                            tipoQuarto = TipoQuarto.PEDIATRICO;
                            break;
                        case 5:
                            tipoQuarto = TipoQuarto.EMERGENCIA;
                            break;
                        default:
                            System.out.println("Opção inválida");
                            break;
                    }
                    Quarto quarto = new Quarto(numero, capacidadeTotal, tipoQuarto);
                    quartoService.salvar(quarto);
                    break;
                case 2:
                    quartoService.listar();
                    break;
                case 3:
                    quartoService.listarQuartosComVaga();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
