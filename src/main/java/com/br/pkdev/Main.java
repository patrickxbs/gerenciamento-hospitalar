package com.br.pkdev;

import com.br.pkdev.persistence.impl.InternacaoRepositoryImpl;
import com.br.pkdev.persistence.impl.MedicoRepositoryImpl;
import com.br.pkdev.Menus.MenuInternacao;
import com.br.pkdev.Menus.MenuMedico;
import com.br.pkdev.Menus.MenuPaciente;
import com.br.pkdev.Menus.MenuQuarto;
import com.br.pkdev.persistence.impl.PacienteRepositoryImpl;
import com.br.pkdev.persistence.impl.QuartoRepositoryImpl;
import com.br.pkdev.service.InternacaoService;
import com.br.pkdev.service.MedicoService;
import com.br.pkdev.service.PacienteService;
import com.br.pkdev.service.QuartoService;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        
        MedicoService medicoService = new MedicoService(new MedicoRepositoryImpl());
        PacienteService pacienteService = new PacienteService(new PacienteRepositoryImpl());
        QuartoService quartoService = new QuartoService(new QuartoRepositoryImpl());
        InternacaoService internacaoSevice = new InternacaoService(new InternacaoRepositoryImpl());

        MenuPaciente menuPaciente = new MenuPaciente(pacienteService);
        MenuMedico menuMedico = new MenuMedico(medicoService);
        MenuQuarto menuQuarto = new MenuQuarto(quartoService);
        MenuInternacao menuInternacao = new MenuInternacao(internacaoSevice, pacienteService, medicoService, quartoService);
        
        while (true) {
            System.out.println("\n=== Sistema Hospitalar ===");
            System.out.println("1 - Paciente");
            System.out.println("2 - Medico");
            System.out.println("3 - Quarto");
            System.out.println("4 - Internação");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            Scanner scanner = new Scanner(System.in);
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    menuPaciente.exibir(scanner);
                    break;
                case 2:
                    menuMedico.exibir(scanner);
                    break;
                case 3:
                    menuQuarto.exibir(scanner);
                    break;
                case 4:
                    menuInternacao.exibir(scanner);
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}