package br.com.univali.poo.esporte;

import java.util.Scanner;

public class Menu {
    public Menu(Organizacao organizacao) {
        Scanner scanner = new Scanner(System.in);
        Campeonato campeonato = null;
        for (int i = 0; i != 4; ) {
            System.out.print("""
                    Escolha uma opcão
                    1 - Criar campeonato
                    2 - Ver campeonato
                    3 - Ver corridas
                    4 - Sair
                    Opcão: 
                    """);
            i = scanner.nextInt();
            try {
                switch (i) {
                    case 1 -> campeonato = organizacao.OrganizarCampeonato("Campeonato");
                    case 2 -> mostraCampeonato(organizacao, campeonato);
                    case 3 -> mostrarCorrida(campeonato);
                    case 4 -> System.out.println("Saiu");
                }
            } catch (Exception e) {
                System.out.println("Opção inválida");
            }
        }
    }

    public void mostraCampeonato(Organizacao organizacao, Campeonato campeonato) {
        organizacao.mostrarInformacoes(campeonato);
    }

    public void mostrarCorrida(Campeonato campeonato) {
        Scanner scanner = new Scanner(System.in);
        for (int opcao = 0; opcao != -1; ) {
            System.out.print("""
                    Escolha uma opcão
                    0 - Sair
                    Escolha uma corrida
                    Escolha: 
                    """);
            opcao = scanner.nextInt();
            opcao--;
            try {
                campeonato.getCorrida(opcao).mostrarInformacao();
            } catch (Exception e) {
                System.out.println("Corrida inválida");
            }
        }
    }
}
