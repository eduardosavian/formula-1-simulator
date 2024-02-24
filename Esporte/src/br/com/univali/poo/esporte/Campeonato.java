package br.com.univali.poo.esporte;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Campeonato {
    public String nome;
    public List<Equipe> equipes;
    public List<Corrida> corridas;

    public Campeonato(String nome) {
        this.nome = nome;
        this.equipes = new ArrayList<>();
        this.corridas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarEquipe(Equipe equipe) {
        this.equipes.add(equipe);
    }

    public void removerEquipe(int numeroDaEquipe) {
        this.equipes.remove(equipes.get(numeroDaEquipe));
    }

    public List<Equipe> getEquipes() {
        return equipes;
    }

    public void adicionarCorrida(Corrida corrida) {
        this.corridas.add(corrida);
    }

    public void removerCorrida(int numeroDaCorrida) {
        this.corridas.remove(corridas.get(numeroDaCorrida));
    }

    public Corrida getCorrida(int numeroDaCorrida) {
        return corridas.get(numeroDaCorrida);
    }

    public List<Corrida> getCorridas() {
        return corridas;
    }

    public void competir(Campeonato campeonato) {
        for (Corrida corrida : campeonato.getCorridas()) {
            campeonato.organizarFinalDeSemana( corrida);
        }
    }

    public void organizarFinalDeSemana( Corrida corrida) {
        Map<Equipe, Map<Veiculo, Double>> gridParaAQualifacao = corrida.prepararCorrida(this, null, Corrida.TipoDeCorrida.QUALIFICACAO);

        List<Veiculo> gridDeChegadaDaQuaficacao = corrida.correr(gridParaAQualifacao);

        Map<Equipe, Map<Veiculo, Double>> gridDeLargada = corrida.prepararCorrida(this, gridDeChegadaDaQuaficacao, Corrida.TipoDeCorrida.NORMAL);

        List<Veiculo> gridDeChegadaDaCorrida = corrida.correr(gridDeLargada);

        for (Veiculo veiculo : gridDeChegadaDaCorrida) {
            corrida.setGridFinal(veiculo);
        }

        this.distribuirPontos(gridDeChegadaDaCorrida);
    }

    public void distribuirPontos(List<Veiculo> gridDeChegada) {
        for (Veiculo veiculo : gridDeChegada) {
            if (gridDeChegada.indexOf(veiculo) < 10) {
                if (gridDeChegada.indexOf(veiculo) < 3) {
                    veiculo.getPiloto().aumentarPodiumsPiloto();
                    if (gridDeChegada.indexOf(veiculo) == 0) {
                        veiculo.getPiloto().aumentarNumeroDeCorridasVencidasPiloto();
                    }
                }

                if (gridDeChegada.indexOf(veiculo) == 0) {
                    veiculo.getPiloto().setPontosDoPiloto(26.0);
                } else if (gridDeChegada.indexOf(veiculo) == 1) {
                    veiculo.getPiloto().setPontosDoPiloto(18.0);
                } else if (gridDeChegada.indexOf(veiculo) == 2) {
                    veiculo.getPiloto().setPontosDoPiloto(15.0);
                } else if (gridDeChegada.indexOf(veiculo) == 3) {
                    veiculo.getPiloto().setPontosDoPiloto(12.0);
                } else if (gridDeChegada.indexOf(veiculo) == 4) {
                    veiculo.getPiloto().setPontosDoPiloto(10.0);
                } else if (gridDeChegada.indexOf(veiculo) == 5) {
                    veiculo.getPiloto().setPontosDoPiloto(8.0);
                } else if (gridDeChegada.indexOf(veiculo) == 6) {
                    veiculo.getPiloto().setPontosDoPiloto(6.0);
                } else if (gridDeChegada.indexOf(veiculo) == 7) {
                    veiculo.getPiloto().setPontosDoPiloto(4.0);
                } else if (gridDeChegada.indexOf(veiculo) == 8) {
                    veiculo.getPiloto().setPontosDoPiloto(2.0);
                } else if (gridDeChegada.indexOf(veiculo) == 9) {
                    veiculo.getPiloto().setPontosDoPiloto(1.0);
                } else {
                    veiculo.getPiloto().setPontosDoPiloto(0.0);
                }
            }
        }
    }
}
