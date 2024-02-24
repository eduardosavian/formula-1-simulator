package br.com.univali.poo.esporte;

import java.util.Map;
import java.util.Random;

public abstract class Veiculo implements Informacao {
    private final String nomeDoVeiculo;
    private double qualidadeDosPneus;
    private TiposDePneu tipoDePneu;
    private Piloto piloto;

    public enum TiposDePneu {SOFT, MEDIUM, HARD}

    public Veiculo(String nomeDoVeiculo) {
        this.nomeDoVeiculo = nomeDoVeiculo;
        this.qualidadeDosPneus = 100.0;
        this.tipoDePneu = null;
        this.piloto = null;
        this.tipoDePneu = TiposDePneu.MEDIUM;
    }

    public String getNomeDoVeiculo() {
        return nomeDoVeiculo;
    }

    public double getQualidadeDosPneus() {
        return qualidadeDosPneus;
    }

    public void setQualidadeDosPneus(double qualidadeDosPneus) {
        this.qualidadeDosPneus -= qualidadeDosPneus;
    }

    public double getTipoDePneu() {
        if (this.tipoDePneu == TiposDePneu.SOFT) {
            return 1.0;
        } else if (this.tipoDePneu == TiposDePneu.MEDIUM) {
            return 0.75;
        } else if (this.tipoDePneu == TiposDePneu.HARD) {
            return 0.5;
        } else {
            return 0.0;
        }
    }

    public void trocarPneus(TiposDePneu tipoDePneu) {
        this.tipoDePneu = tipoDePneu;

        if (tipoDePneu == TiposDePneu.SOFT) {
            this.qualidadeDosPneus = 100.0;
        } else if (tipoDePneu == TiposDePneu.MEDIUM) {
            this.qualidadeDosPneus = 200.0;
        } else if (tipoDePneu == TiposDePneu.HARD) {
            this.qualidadeDosPneus = 300.0;
        }
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void adicionarPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public void removerPiloto() {
        this.piloto = null;
    }
}


