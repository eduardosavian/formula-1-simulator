package br.com.univali.poo.esporte;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Organizacao {

    public Campeonato OrganizarCampeonato(String nome) {
        Campeonato campeonato = criarCampeonato(nome);

        campeonato.competir(campeonato);

        return campeonato;
    }

    public void mostrarInformacoes(Campeonato campeonato) {

        System.out.println(campeonato.getNome());

        for (Equipe equipe : campeonato.getEquipes()) {
            equipe.calcularPontos();
        }

        campeonato.getEquipes().sort(Comparator.comparing(Equipe::getPontosDaEquipe).reversed());

        System.out.println("Colocação: ");

        List<Piloto> pilotosRanking = new ArrayList<>();
        for (Equipe equipe : campeonato.getEquipes()) {
            equipe.mostrarInformacao();
            pilotosRanking.addAll(equipe.getPilotos());
        }

        System.out.println("\nPilotos: ");

        pilotosRanking.sort(Comparator.comparing(Piloto::getPontosDoPiloto).reversed());
        for (Piloto piloto : pilotosRanking) {
            piloto.mostrarInformacao();
            System.out.println();
        }
    }

    private Campeonato criarCampeonato(String nome) {
        Campeonato campeonato = new Campeonato(nome);

        campeonato.adicionarCorrida(new Corrida("Grande Prêmio do Bahein", 3664));
        campeonato.adicionarCorrida(new Corrida("Grande Prêmio da Arábia Saudita", 6175));
        campeonato.adicionarCorrida(new Corrida("Grande Prêmio da Austrália", 5303));
        campeonato.adicionarCorrida(new Corrida("Grande Prêmio da Emilia Romagna", 4909));
        campeonato.adicionarCorrida(new Corrida("Grande de Miami", 5410));
        campeonato.adicionarCorrida(new Corrida("Grande Prêmio da Espanha", 5419));
        campeonato.adicionarCorrida(new Corrida("Grande Prêmio de Mônaco", 3337));
        campeonato.adicionarCorrida(new Corrida("Grande Prêmio do Azerbaijão", 6003));
        campeonato.adicionarCorrida(new Corrida("Grande Prêmio do Canadá", 4361));
        campeonato.adicionarCorrida(new Corrida("Grande Prêmio da Grâ-Bretanha", 5891));
        campeonato.adicionarCorrida(new Corrida("Grande Prêmio da Áustria", 4318));
        campeonato.adicionarCorrida(new Corrida("Grande Prêmio da França", 5842));
        campeonato.adicionarCorrida(new Corrida("Grande Prêmio da Hungria", 4381));
        campeonato.adicionarCorrida(new Corrida("Grande Prêmio da Bélgica", 7004));
        campeonato.adicionarCorrida(new Corrida("Grande Prêmio dos Países Baixos", 4252));
        campeonato.adicionarCorrida(new Corrida("Grande Prêmio da Russia", 5848));
        campeonato.adicionarCorrida(new Corrida("Grande Prêmio de Singapura", 5063));
        campeonato.adicionarCorrida(new Corrida("Grande Prêmio do Japão", 3703));
        campeonato.adicionarCorrida(new Corrida("Grande Prêmio dos Estados Unidos", 5513));
        campeonato.adicionarCorrida(new Corrida("Grande Prêmio da Cidade do México", 4304));
        campeonato.adicionarCorrida(new Corrida("Grande Prêmio de São Paulo", 4309));
        campeonato.adicionarCorrida(new Corrida("Grande Prêmio de Abu Dhabi", 5554));

        campeonato.removerCorrida(15); //Remover a russia

        Equipe ferrari = new Equipe("Ferrari", 8.5);

        ferrari.contratarPiloto(new Piloto("Charles Leclerc", 8.5));
        ferrari.contratarPiloto(new Piloto("Carlos Sainz", 8.0));

        ferrari.adicionarVeiculo(new Carro("Ferrari F40CL"));
        ferrari.adicionarVeiculo(new Carro("Ferrari F40SCS"));
        ferrari.getVeiculos().get(0).adicionarPiloto(ferrari.getPilotos().get(0));
        ferrari.getVeiculos().get(1).adicionarPiloto(ferrari.getPilotos().get(1));

        campeonato.adicionarEquipe(ferrari);

        Equipe redBull = new Equipe("Red Bull", 9.5);

        redBull.contratarPiloto(new Piloto("Max Verstappen", 9.0));
        redBull.contratarPiloto(new Piloto("Checo Perez", 8.5));
        redBull.adicionarVeiculo(new Carro("Red Bull RB3"));
        redBull.adicionarVeiculo(new Carro("Red Bull RB3"));
        redBull.getVeiculos().get(0).adicionarPiloto(redBull.getPilotos().get(0));
        redBull.getVeiculos().get(1).adicionarPiloto(redBull.getPilotos().get(1));

        campeonato.adicionarEquipe(redBull);

        Equipe mercedes = new Equipe("Mercedes", 8.5);

        mercedes.contratarPiloto(new Piloto("Lewis Hamilton", 8.5));
        mercedes.contratarPiloto(new Piloto("George Russel", 8.0));
        mercedes.adicionarVeiculo(new Carro("Mercedes AMG GT3"));
        mercedes.adicionarVeiculo(new Carro("Mercedes AMG GT3"));
        mercedes.getVeiculos().get(0).adicionarPiloto(mercedes.getPilotos().get(0));
        mercedes.getVeiculos().get(1).adicionarPiloto(mercedes.getPilotos().get(1));

        campeonato.adicionarEquipe(mercedes);

        Equipe mcLaren = new Equipe("McLaren", 7.5);

        mcLaren.contratarPiloto(new Piloto("Lando Noris", 8.0));
        mcLaren.contratarPiloto(new Piloto("Daniel Riccardo", 8.0));
        mcLaren.adicionarVeiculo(new Carro("McLaren F1"));
        mcLaren.adicionarVeiculo(new Carro("McLaren F1"));
        mcLaren.getVeiculos().get(0).adicionarPiloto(mcLaren.getPilotos().get(0));
        mcLaren.getVeiculos().get(1).adicionarPiloto(mcLaren.getPilotos().get(1));

        campeonato.adicionarEquipe(mcLaren);

        Equipe alpine = new Equipe("Alpine", 7.0);

        alpine.contratarPiloto(new Piloto("Fernando Alonso", 9.0));
        alpine.contratarPiloto(new Piloto("Esteban Ocon", 7.0));
        alpine.adicionarVeiculo(new Carro("Alpine A110"));
        alpine.adicionarVeiculo(new Carro("Alpine A110"));
        alpine.getVeiculos().get(0).adicionarPiloto(alpine.getPilotos().get(0));
        alpine.getVeiculos().get(1).adicionarPiloto(alpine.getPilotos().get(1));

        campeonato.adicionarEquipe(alpine);

        Equipe alfaRomeo = new Equipe("Alfa Romeo", 6.5);

        alfaRomeo.contratarPiloto(new Piloto("Valtteri Bottas", 7.5));
        alfaRomeo.contratarPiloto(new Piloto("Guan Yu Zhou", 4.0));
        alfaRomeo.adicionarVeiculo(new Carro("Alfa Romeo Giulia"));
        alfaRomeo.adicionarVeiculo(new Carro("Alfa Romeo Giulia"));
        alfaRomeo.getVeiculos().get(0).adicionarPiloto(alfaRomeo.getPilotos().get(0));
        alfaRomeo.getVeiculos().get(1).adicionarPiloto(alfaRomeo.getPilotos().get(1));

        campeonato.adicionarEquipe(alfaRomeo);

        Equipe williams = new Equipe("Williams", 5.0);

        williams.contratarPiloto(new Piloto("Nicholas Latifi", 0.0));
        williams.contratarPiloto(new Piloto("Alexander Albon", 7.0));
        williams.adicionarVeiculo(new Carro("Williams V8"));
        williams.adicionarVeiculo(new Carro("Williams V8"));
        williams.getVeiculos().get(0).adicionarPiloto(williams.getPilotos().get(0));
        williams.getVeiculos().get(1).adicionarPiloto(williams.getPilotos().get(1));

        campeonato.adicionarEquipe(williams);

        Equipe alphaTauri = new Equipe("Alpha Tauri", 6.0);

        alphaTauri.contratarPiloto(new Piloto("Pierre Gasly", 7.0));
        alphaTauri.contratarPiloto(new Piloto("Yuki Tsunoda", 5.0));
        alphaTauri.adicionarVeiculo(new Carro("Alpha Tauri A110"));
        alphaTauri.adicionarVeiculo(new Carro("Alpha Tauri A110"));
        alphaTauri.getVeiculos().get(0).adicionarPiloto(alphaTauri.getPilotos().get(0));
        alphaTauri.getVeiculos().get(1).adicionarPiloto(alphaTauri.getPilotos().get(1));

        campeonato.adicionarEquipe(alphaTauri);

        Equipe astonMartin = new Equipe("Aston Martin", 6.0);

        astonMartin.contratarPiloto(new Piloto("Sebastian Vettel", 8.0));
        astonMartin.contratarPiloto(new Piloto("Lance Stroll", 6.0));
        astonMartin.adicionarVeiculo(new Carro("Aston Martin DB9"));
        astonMartin.adicionarVeiculo(new Carro("Aston Martin DB9"));
        astonMartin.getVeiculos().get(0).adicionarPiloto(astonMartin.getPilotos().get(0));
        astonMartin.getVeiculos().get(1).adicionarPiloto(astonMartin.getPilotos().get(1));

        campeonato.adicionarEquipe(astonMartin);

        Equipe hass = new Equipe("Hass", 4.0);

        hass.contratarPiloto(new Piloto("Mick Schumacher", 5.0));
        hass.contratarPiloto(new Piloto("Nikita Mazepin", -10.0));
        hass.adicionarVeiculo(new Carro("Hass A110"));
        hass.adicionarVeiculo(new Carro("Hass A110"));
        hass.getVeiculos().get(0).adicionarPiloto(hass.getPilotos().get(0));
        hass.getVeiculos().get(1).adicionarPiloto(hass.getPilotos().get(1));

        hass.demitirPiloto(1);
        hass.contratarPiloto(new Piloto("Kevin Magnussen", 7.0));
        hass.getVeiculos().get(1).adicionarPiloto(hass.getPilotos().get(1));

        campeonato.adicionarEquipe(hass);

        return campeonato;
    }
}