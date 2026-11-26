package pm_prova2_m;

public class Van extends Veiculo implements Avaliavel, Inspecionavel {
    private int quantidadePassageiros;
    private int nota;

    public Van(String placa, String modelo, int anoFabricacao, double valorDiaria, double quilometragem, StatusVeiculo status, int quantidadePassageiros) {
        super(placa, modelo, anoFabricacao, valorDiaria, quilometragem, status);
        this.quantidadePassageiros = quantidadePassageiros;
    }

    public int getQuantidadePassageiros() {
        return quantidadePassageiros;
    }

    public void setQuantidadePassageiros(int quantidadePassageiros) {
        this.quantidadePassageiros = quantidadePassageiros;
    }

    public int getNota() {
        return nota;
    }

    @Override
    public void avaliar(int nota) {
        if (nota >= 0 && nota <= 10) {
            this.nota = nota;
            System.out.println("Avaliacao registrada!!");
        } else {
            System.out.println("A nota deve ser de 0 a 10.cuidado");
        }
    }

    @Override
    public void realizarInspecao() {
        setStatus(StatusVeiculo.MANUTENCAO);
        System.out.println("Van foi enviada para manutencao apos a inspecao");
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Modelo da Van: " + getModelo() + "Placa: " + getPlaca() + "Ano: " + getAnoFabricacao());
        System.out.println("Quant. Passageiros: " + quantidadePassageiros + "Diaria: R$ " + getValorDiaria() + "Km: " + getQuilometragem() + "Status: " + getStatus() + "Nota: " + nota);
    }


}
