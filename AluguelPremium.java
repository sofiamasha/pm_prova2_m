package pm_prova2_m;

public class AluguelPremium extends Aluguel {
    public AluguelPremium(String nomeCliente, int quantidadeDias, double valorTotal, StatusAluguel status) {
        super(nomeCliente, quantidadeDias, valorTotal, status);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Aluguel Premium: ");
        System.out.println("Cliente: " + getNomeCliente() + "Dias: " + getQuantidadeDias());
        System.out.println("Valor: ");
        System.out.println("R$ " + getValorTotal() + "Status: " + getStatus() + "Quilometragem ilimitada" + "Seguro: Sim");
        exibirVeiculos();
    }

    @Override
    public boolean possuiSeguroIncluso() {
        return true;
    }
}
