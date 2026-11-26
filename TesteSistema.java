package pm_prova2_m;

public class TesteSistema {
    public static void main(String[] args) {
        Carro carro = new Carro("ABCDEFG", "hundai", 2020, 120, 22000, StatusVeiculo.DISPONIVEL);
        Moto moto = new Moto("AABB445", "gol", 2015, 80, 18000, StatusVeiculo.DISPONIVEL);
        AluguelBasico basico = new AluguelBasico("Sofia", 3, 100, StatusAluguel.ATIVO);
        AluguelPremium premium = new AluguelPremium("Lui", 5, 1000, StatusAluguel.ATIVO);

        basico.adicionarVeiculo(carro);
        conferir(basico.getVeiculos().size() == 1, "O aluguel deve receber o veiculo");
        conferir(carro.getStatus() == StatusVeiculo.ALUGADO, "O veiculo associado deve ficar alugado");

        premium.adicionarVeiculo(carro);
        conferir(premium.getVeiculos().isEmpty(), "Um veiculo alugado nao pode entrar em outro aluguel");
        conferir(basico.getLimiteQuilometragem() == 300, "O aluguel basico deve permitir 100 km por dia");
        conferir(!basico.possuiSeguroIncluso(), "O aluguel basico nao deve ter seguro");
        conferir(premium.possuiSeguroIncluso(), "O aluguel premium deve ter seguro");

        carro.avaliar(9);
        conferir(carro.getNota() == 9, "A avaliacao valida deve armazenada");
        carro.avaliar(15);
        conferir(carro.getNota() == 9, "A avaliacao invalida nao substitui a nota");

        moto.realizarInspecao();
        conferir(moto.getStatus() == StatusVeiculo.MANUTENCAO, "A inspecao deve enviar a moto para manutencao");

        System.out.println("TESTES FEITOS");
    }

    private static void conferir(boolean condicao, String mensagem) {
        if (!condicao) {
            throw new RuntimeException(mensagem);
        }
    }
}
