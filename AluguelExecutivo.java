package pm_prova2_m;

public class AluguelExecutivo extends Aluguel implements Avaliavel {
    private String nomeMotorista;
    private int nota;

    public AluguelExecutivo(String nomeCliente, int quantidadeDias, double valorTotal, StatusAluguel status, String nomeMotorista) {
        super(nomeCliente, quantidadeDias, valorTotal, status);
        this.nomeMotorista = nomeMotorista;
    }

    public String getNomeMotorista() {
    return nomeMotorista;
    }

    public int getNota() {
    return nota;
    }

    @Override
    public void avaliar(int nota) {
        if (nota >= 0 && nota <= 10) {
            this.nota = nota;
            System.out.println("Avaliacao registrada");
        } else {
            System.out.println("A nota deve ser de 0 a 10. cuidado");
        }
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Aluguel executivo");
        System.out.println("Cliente: " + getNomeCliente() + "Dias: " + getQuantidadeDias());
        System.out.println("Valor: ");
        System.out.println("R$ " + getValorTotal() + "status: " + getStatus() + "Motorista: " + nomeMotorista + "Nota: " + nota + "Seguro: nao sei se tem");
        exibirVeiculos();
    }


}
