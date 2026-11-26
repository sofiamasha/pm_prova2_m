/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pm_prova2_m;

/**
 *
 * @author glbra
 */

import java.util.ArrayList;

public abstract class Aluguel {
    private String nomeCliente;
    private int quantidadeDias;
    private double valorTotal;
    private StatusAluguel status;
    private ArrayList<Veiculo> veiculos;

    public Aluguel(String nomeCliente, int quantidadeDias, double valorTotal, StatusAluguel status) {
        this.nomeCliente = nomeCliente;
        this.quantidadeDias = quantidadeDias;
        this.valorTotal = valorTotal;
        this.status = status;
        veiculos = new ArrayList<>();
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getQuantidadeDias() {
        return quantidadeDias;
    }

    public void setQuantidadeDias(int quantidadeDias) {
        this.quantidadeDias = quantidadeDias;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public StatusAluguel getStatus() {
        return status;
    }

    public void setStatus(StatusAluguel status) {
        this.status = status;
    }

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        if (veiculo.getStatus() == StatusVeiculo.DISPONIVEL) {
            veiculos.add(veiculo);
            veiculo.setStatus(StatusVeiculo.ALUGADO);
            System.out.println("Veiculo associado ao aluguel");
        } else {
            System.out.println("Veiculo nao ta disponivel");
        }
    }

    public void exibirVeiculos() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veiculo associado.");
        } else {
            for (Veiculo veiculo : veiculos) {
                System.out.println("modelo: " + veiculo.getModelo() + "placa: " + veiculo.getPlaca());
            }
        }
    }

    public abstract void exibirDetalhes();
    public abstract boolean possuiSeguroIncluso();
}
