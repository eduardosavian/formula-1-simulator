package br.com.univali.poo.esporte;

public class Piloto implements Informacao {
    private final String nomeDoPiloto;
    private int podiumsPiloto;
    private int numeroDeCorridasVencidasPiloto;
    private double pontosDoPiloto;
    private final double nivelDeHabilidadeDoPiloto;

    public Piloto(String nome, double nivelDeHabilidade) {
        this.nomeDoPiloto = nome;
        this.podiumsPiloto = 0;
        this.numeroDeCorridasVencidasPiloto = 0;
        this.pontosDoPiloto = 0;
        this.nivelDeHabilidadeDoPiloto = nivelDeHabilidade;
    }

    public String getNomeDoPiloto() {
        return nomeDoPiloto;
    }

    public int getPodiumsPiloto() {
        return podiumsPiloto;
    }

    public void aumentarPodiumsPiloto() {
        this.podiumsPiloto++;
    }

    public int getNumeroDeCorridasVencidasPiloto() {
        return numeroDeCorridasVencidasPiloto;
    }

    public void aumentarNumeroDeCorridasVencidasPiloto() {
        this.numeroDeCorridasVencidasPiloto++;
    }

    public void adicionarPontos(double pontos) {
        this.pontosDoPiloto += pontos;
    }

    public double getPontosDoPiloto() {
        return pontosDoPiloto;
    }

    public void setPontosDoPiloto(double pontosDoPiloto) {
        this.pontosDoPiloto += pontosDoPiloto;
    }

    public double getNivelDeHabilidadeDoPiloto() {
        return nivelDeHabilidadeDoPiloto;
    }

    @Override
    public void mostrarInformacao() {
        System.out.print(this.getNomeDoPiloto() + " : ");
        System.out.print(this.getPontosDoPiloto() + " pontos, com ");
        System.out.print(this.getNumeroDeCorridasVencidasPiloto() + " corridas vencidas e ");
        System.out.print(this.getPodiumsPiloto() + " podiums ");
    }
}
