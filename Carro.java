package pm_prova2_m;

public class Carro extends Veiculo implements Avaliavel {
    private int quantidadePortas;
    private int nota;

    public Carro(String placa, String modelo, int anoFabricacao, double valorDiaria, double quilometragem, StatusVeiculo status, int quantidadePortas) {
        super(placa, modelo, anoFabricacao, valorDiaria, quilometragem, status);
        this.quantidadePortas = quantidadePortas;
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(int quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
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
            System.out.println("A nota deve ser de 0 a 10. cuidado");
        }
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Carro: " + getModelo() + "Placa: " + getPlaca() + "Ano: " + getAnoFabricacao());
        System.out.println("Portas: " + quantidadePortas + "Diaria: R$ " + getValorDiaria() + "Km: " + getQuilometragem() + "Status: " + getStatus() + "Nota: " + nota);
    }
}