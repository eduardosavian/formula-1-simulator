package br.com.univali.poo.esporte;

import java.util.ArrayList;
import java.util.List;

public class Equipe implements Informacao {
    private final String nomeDaEquipe;
    private int numeroDeCorridasVencidasEquipe;
    private int podiumsEquipe;
    private double pontosDaEquipe;
    private double nivelDeHabilidadeDaEquipe;
    private List<Piloto> pilotos;
    private List<Veiculo> veiculos;

    public Equipe(String nome, double nivelHabilidade) {
        this.nomeDaEquipe = nome;
        this.numeroDeCorridasVencidasEquipe = 0;
        this.podiumsEquipe = 0;
        this.nivelDeHabilidadeDaEquipe = nivelDeHabilidadeDaEquipe;
        this.pontosDaEquipe = 0;
        this.pilotos = new ArrayList<Piloto>();
        this.veiculos = new ArrayList<Veiculo>();
    }

    public String getNomeDaEquipe() {
        return nomeDaEquipe;
    }

    public int getNumeroDeCorridasVencidasEquipe() {
        for (Piloto piloto : pilotos) {
            this.numeroDeCorridasVencidasEquipe += piloto.getNumeroDeCorridasVencidasPiloto();
        }

        return numeroDeCorridasVencidasEquipe;
    }

    public int getPodiumsEquipe() {
        for (Piloto piloto : pilotos) {
            this.podiumsEquipe += piloto.getPodiumsPiloto();
        }

        return podiumsEquipe;
    }

    public double getPontosDaEquipe() {
        return pontosDaEquipe;
    }

    public void calcularPontos() {
        for (Piloto piloto : pilotos) {
            this.pontosDaEquipe += piloto.getPontosDoPiloto();
        }
    }

    public double getNivelDeHabilidadeDaEquipe() {
        return nivelDeHabilidadeDaEquipe;
    }

    public void contratarPiloto(Piloto piloto) {
        this.pilotos.add(piloto);
    }

    public void demitirPiloto(int numerroDoPiloto) {
        this.pilotos.remove(pilotos.get(numerroDoPiloto));
        this.veiculos.get(numerroDoPiloto).removerPiloto();
    }

    public List<Piloto> getPilotos() {
        return pilotos;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    public void removerVeiculo(int numeroDoCarro) {
        this.veiculos.remove(numeroDoCarro);
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void realizarPitStop(Veiculo veiculo, Veiculo.TiposDePneu tiposDePneu) {
        veiculo.trocarPneus(tiposDePneu);
    }

    @Override
    public void mostrarInformacao() {
        System.out.print(this.getNomeDaEquipe() + " : ");
        System.out.print(this.getPontosDaEquipe() + " pontos com ");
        System.out.print(this.getNumeroDeCorridasVencidasEquipe() + " corridas vencidas e ");
        System.out.println(this.getPodiumsEquipe() + " podiums");
    }
}
