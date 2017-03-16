package br.edu.ufcg.computacao.si1.model.usuario;

import java.util.ArrayList;

/**
 * Created by adson_silva on 15/03/17.
 */
public class Financas {

    private double saldo;
    private ArrayList<String> extrato;

    public Financas(){
        this.saldo = 0;
        this.extrato = new ArrayList<String>();
    }

    public void creditar(double valor){
        this.saldo += valor;
        this.extrato.add("Crédito no valor de R$: " + valor + ". Saldo atual R$: " + this.saldo);
    }

    public void debitar(double valor){
        this.saldo -= valor;
        this.extrato.add("Débito no valor de R$: " + valor + ". Saldo atual R$: " + this.saldo);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public ArrayList<String> getExtrato() {
        return extrato;
    }

    public void setExtrato(ArrayList<String> extrato) {
        this.extrato = extrato;
    }
}
