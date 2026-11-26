package pm_prova2_m;

public class Moto extends Veiculo implements Inspecionavel {
    private int cilindrada;

    public Moto(String placa, String modelo, int anoFabricacao, double valorDiaria, double quilometragem, StatusVeiculo status, int cilindrada) {
        super(placa, modelo, anoFabricacao, valorDiaria, quilometragem, status);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public void realizarInspecao() {
        setStatus(StatusVeiculo.MANUTENCAO);
        System.out.println("Moto foi enviada para manutencao apos a inspecao");
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Moto: " + getModelo() + "Placa: " + getPlaca() + "Ano: " + getAnoFabricacao());
        System.out.println("Cilindrada: " + cilindrada + "Diaria: R$ " + getValorDiaria() + "Km: " + getQuilometragem() + "Status: " + getStatus());
    }

}
