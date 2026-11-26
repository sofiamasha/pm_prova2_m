package pm_prova2_m;

public class AluguelBasico extends Aluguel {
    public AluguelBasico(String nomeCliente, int quantidadeDias, double valorTotal, StatusAluguel status) {
    super(nomeCliente, quantidadeDias, valorTotal, status);
    }

    public int getLimiteQuilometragem() {
    return getQuantidadeDias() * 100;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("AlUGUEL BASICO: ");
        System.out.println("Cliente: " + getNomeCliente() + "Dias: " + getQuantidadeDias());
        System.out.println("VALOR: ");
        System.out.println("R$ " + getValorTotal() + "Status: " + getStatus() + "Limite: " + getLimiteQuilometragem() + " km " + " Seguro: Nao tem");
        exibirVeiculos();
    }

    @Override
    public boolean TemSeguroIncluso() { //acho q é boolean ne pra flr que nao tem
    return false; 
}
}
