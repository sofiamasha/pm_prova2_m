/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pm_prova2_m;

/**
 *
 * @author glbra
 */

import java.util.ArrayList;
import java.util.Scanner;

public class PM_Prova2_M {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Veiculo> veiculos = new ArrayList<>();
    static ArrayList<Aluguel> alugueis = new ArrayList<>();

    public static void main(String[] args) {
        criarDadosIniciais();
        int opcao;

        do {
            mostrarMenu();
            opcao = lerNumero();

            switch (opcao) {
                case 1:
                    associarVeiculo();
                    break;
                case 2:
                    exibirTodosVeiculos();
                    break;
                case 3:
                    exibirTodosAlugueis();
                    break;
                case 4:
                    exibirVeiculosDisponiveis();
                    break;
                case 5:
                    avaliarObjeto();
                    break;
                case 6:
                    realizarInspecao();
                    break;
                case 7:
                    removerVeiculosManutencao();
                    break;
                case 0:
                    System.out.println("fim");
                    break;
                default:
                    System.out.println("Opcao invalida");
            }
        } while (opcao != 0);
    }

    public static void criarDadosIniciais() {
    veiculos.add(new Carro("ABCDEFG", "hundai", 2020, 120, 22000, StatusVeiculo.DISPONIVEL));
    veiculos.add(new Moto("AABB445", "gol", 2015, 80, 18000, StatusVeiculo.DISPONIVEL));
    veiculos.add(new Van("6767ABC", "bmw", 2025, 250, 80000, StatusVeiculo.DISPONIVEL));

    alugueis.add(new AluguelBasico("Sofia", 3, 100, StatusAluguel.ATIVO));
    alugueis.add(new AluguelPremium("Lui", 5, 1000, StatusAluguel.ATIVO));
    }

    public static void mostrarMenu() {
        System.out.println("LOCADORA");
        System.out.println("1 - Associar veiculo a um aluguel");
        System.out.println("2 - Exibir tds os veiculos");
        System.out.println("3 - Exibir tds os alugueis");
        System.out.println("4 - Exibir veiculos disponiveis");
        System.out.println("5 - Avaliar objeto");
        System.out.println("6 - Realizar inspecao");
        System.out.println("7 - Remover veiculos em manutencao");
        System.out.println("0 - Sair");
        System.out.print("Opcao: ");
    }

    public static int lerNumero() {
        while (!sc.hasNextInt()) {
            System.out.println("Digite um numero q seja valido:");
            sc.next();
        }
        int numero = sc.nextInt();
        sc.nextLine();
        return numero;
    }

    public static void associarVeiculo() {
        System.out.println("Escolha o aluguel:");
        for (int i = 0; i < alugueis.size(); i++) {
            System.out.println((i + 1) + "  " + alugueis.get(i).getNomeCliente());
        }
        int numeroAluguel = lerNumero() - 1;

        System.out.println("Escolha o veiculo:");
        for (int i = 0; i < veiculos.size(); i++) {
            System.out.println((i + 1) + " - " + veiculos.get(i).getModelo() + " - " + veiculos.get(i).getStatus());
        }
        int numeroVeiculo = lerNumero() - 1;

        if (numeroAluguel >= 0 && numeroAluguel < alugueis.size() && numeroVeiculo >= 0 && numeroVeiculo < veiculos.size()) {
            alugueis.get(numeroAluguel).adicionarVeiculo(veiculos.get(numeroVeiculo));
        } else {
            System.out.println("Escolha invalida");
        }
    }

    public static void exibirTodosVeiculos() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veiculo cadastrado");
        }
        for (Veiculo veiculo : veiculos) {
            veiculo.exibirDetalhes();
            System.out.println();
        }
    }

    public static void exibirTodosAlugueis() {
        if (alugueis.isEmpty()) {
            System.out.println("Nenhum aluguel cadastrado");
        }
        for (Aluguel aluguel : alugueis) {
            aluguel.exibirDetalhes();
            System.out.println();
        }
    }

    public static void exibirVeiculosDisponiveis() {
        boolean encontrou = false;
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getStatus() == StatusVeiculo.DISPONIVEL) {
                veiculo.exibirDetalhes();
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum veiculo disponivel desculpa");
        }
    }

    public static void avaliarObjeto() {
        ArrayList<Avaliavel> avaliaveis = new ArrayList<>();

        for (Veiculo veiculo : veiculos) {
            if (veiculo instanceof Avaliavel) {
                avaliaveis.add((Avaliavel) veiculo);
            }
        }
        for (Aluguel aluguel : alugueis) {
            if (aluguel instanceof Avaliavel) {
                avaliaveis.add((Avaliavel) aluguel);
            }
        }

        if (avaliaveis.isEmpty()) {
            System.out.println("Nao existem objetos avaliaveis");
            return;
        }

        for (int i = 0; i < avaliaveis.size(); i++) {
            String tipo = "Aluguel Executivo";
            if (avaliaveis.get(i) instanceof Carro) {
                tipo = "Carro";
            }
            if (avaliaveis.get(i) instanceof Van) {
                tipo = "Van";
            }
            System.out.println((i + 1) + " - " + tipo);
        }
        System.out.print("Escolha: ");
        int escolha = lerNumero() - 1;
        if (escolha >= 0 && escolha < avaliaveis.size()) {
            System.out.print("Nota de 0 a 10: ");
            avaliaveis.get(escolha).avaliar(lerNumero());
        }
    }

    public static void realizarInspecao() {
        ArrayList<Inspecionavel> inspecionaveis = new ArrayList<>();

        for (Veiculo veiculo : veiculos) {
            if (veiculo instanceof Inspecionavel) {
                inspecionaveis.add((Inspecionavel) veiculo);
            }
        }

        if (inspecionaveis.isEmpty()) {
            System.out.println("Nao tem veiculos para inspecionar");
            return;
        }

        for (int i = 0; i < inspecionaveis.size(); i++) {
            Veiculo veiculo = (Veiculo) inspecionaveis.get(i);
            System.out.println((i + 1) + "  " + veiculo.getModelo());
        }
        System.out.print("Escolha: ");
        int escolha = lerNumero() - 1;
        if (escolha >= 0 && escolha < inspecionaveis.size()) {
            inspecionaveis.get(escolha).realizarInspecao();
        } 
    }

    public static void removerVeiculosManutencao() {
        int removidos = 0;
        for (int i = veiculos.size() - 1; i >= 0; i--) {
            if (veiculos.get(i).getStatus() == StatusVeiculo.MANUTENCAO) {
                veiculos.remove(i);
                removidos++;
            }
        }
        System.out.println(removidos + "veiculo removido");
    }
}
