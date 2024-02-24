package br.com.univali.poo.esporte;

import java.util.*;

public class Corrida implements Informacao {
    private final String nomeDaCorrida;
    private final double tamanhdoTotal;
    public List<Veiculo> gridFinal;

    public enum TipoDeCorrida {QUALIFICACAO, NORMAL}

    public Corrida(String nome, int tamanhoTotal) {
        this.nomeDaCorrida = nome;
        this.tamanhdoTotal = tamanhoTotal;
        this.gridFinal = new ArrayList<>();
    }

    public String getNomeDaCorrida() {
        return nomeDaCorrida;
    }

    public double getTamanhdoTotal() {
        return tamanhdoTotal;
    }

    public List<Veiculo> getGridFinal() {
        return gridFinal;
    }

    public void setGridFinal(Veiculo veiculo) {
        this.gridFinal.add(veiculo);
    }

    public Map<Equipe, Map<Veiculo, Double>> prepararCorrida(Campeonato campeonato, List<Veiculo> gridDeChegada, TipoDeCorrida tipoDeCorrida) {
        Map<Equipe, Map<Veiculo, Double>> grid = new HashMap<>();
        for (Equipe equipe : campeonato.getEquipes()) {
            Map<Veiculo, Double> posicao = new HashMap<>();
            for (Veiculo veiculo : equipe.getVeiculos()) {
                if (tipoDeCorrida == TipoDeCorrida.QUALIFICACAO) {
                    double posicaoDoVeiculoInicial = 0.0;
                    posicao.put(veiculo, posicaoDoVeiculoInicial);
                }

                if (tipoDeCorrida == TipoDeCorrida.NORMAL) {
                    double posicaoDoVeiculoNaQualificacao = gridDeChegada.indexOf(veiculo) * -50;
                    posicao.put(veiculo, posicaoDoVeiculoNaQualificacao);
                }
            }
            grid.put(equipe, posicao);
        }

        return grid;
    }

    public List<Veiculo> correr(Map<Equipe, Map<Veiculo, Double>> grid) {
        List<Veiculo> gridDeChegada = new ArrayList<>();

        while (gridDeChegada.size() < grid.size() * 2) {
            for (Equipe equipe : grid.keySet()) {
                for (Veiculo veiculo : grid.get(equipe).keySet()) {
                    double posicaoAtualizada = aumentarPosicao(grid, equipe, veiculo);

                    grid.get(equipe).put(veiculo, posicaoAtualizada);

                    boolean veiculoChegou = verSeOCarroTerminouAProva(grid, gridDeChegada, equipe, veiculo);
                    if (veiculoChegou) {
                        gridDeChegada.add(veiculo);
                    }
                }
            }
        }

        return gridDeChegada;
    }

    private boolean verSeOCarroTerminouAProva(Map<Equipe, Map<Veiculo, Double>> grid, List<Veiculo> gridDeChegada, Equipe equipe, Veiculo veiculo) {
        return grid.get(equipe).get(veiculo) > 100 && !gridDeChegada.contains(veiculo);
    }

    private double aumentarPosicao(Map<Equipe, Map<Veiculo, Double>> grid, Equipe equipe, Veiculo veiculo) {
        Random random = new Random();

        double coeficienteDoPneu = veiculo.getTipoDePneu();
        double posicaoAtual = grid.get(equipe).get(veiculo);
        double coeficienteDeHabilidade = (veiculo.getPiloto().getNivelDeHabilidadeDoPiloto() * 10 + equipe.getNivelDeHabilidadeDaEquipe()) / 2;
        double sorte = random.nextDouble() * 2;

        double perdaDePosicaoPitStop = 0;
        boolean pneuEstaRuim = verSePrecisaTrocarPneu(veiculo);
        if (pneuEstaRuim) {
            fazerParada(equipe, veiculo, random);
            perdaDePosicaoPitStop = 1;
        }

        double posicaoAtualizada = coeficienteDoPneu * (posicaoAtual + sorte + coeficienteDeHabilidade) - perdaDePosicaoPitStop;

        veiculo.setQualidadeDosPneus(random.nextDouble());

        return posicaoAtualizada;
    }

    private void fazerParada(Equipe equipe, Veiculo veiculo, Random random) {
        double tipoDePneuDeTroca = random.nextInt(3);

        if (tipoDePneuDeTroca == 0) {
            equipe.realizarPitStop(veiculo, Veiculo.TiposDePneu.HARD);
        } else if (tipoDePneuDeTroca == 1) {
            equipe.realizarPitStop(veiculo, Veiculo.TiposDePneu.MEDIUM);
        } else if (tipoDePneuDeTroca == 2) {
            equipe.realizarPitStop(veiculo, Veiculo.TiposDePneu.SOFT);
        }
    }

    private boolean verSePrecisaTrocarPneu(Veiculo veiculo) {
        return veiculo.getQualidadeDosPneus() < 1;
    }

    @Override
    public void mostrarInformacao() {
        System.out.println(getNomeDaCorrida() + " - " + getTamanhdoTotal());
        for (Veiculo veiculo : gridFinal) {
            veiculo.mostrarInformacao();
        }
    }

}