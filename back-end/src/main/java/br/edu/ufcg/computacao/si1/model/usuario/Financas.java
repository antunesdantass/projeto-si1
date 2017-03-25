package br.edu.ufcg.computacao.si1.model.usuario;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

/**
 * Created by adson_silva on 15/03/17.
 */
@Entity(name = "Financas")
@Table(name = "tb_financas")
public class Financas {

    @Column
    private double saldo = 0;

    @Column
    private ArrayList<String> extrato = new ArrayList<String>();

    public Financas(){
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
