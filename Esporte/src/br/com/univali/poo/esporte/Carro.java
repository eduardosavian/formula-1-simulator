package br.com.univali.poo.esporte;

public class Carro extends Veiculo {
    public Carro(String nomeDoVeiculo) {
        super(nomeDoVeiculo);
    }

    @Override
    public void mostrarInformacao() {
        getPiloto().mostrarInformacao();
        System.out.println(" com seu " + getNomeDoVeiculo());
    }
}
