package br.edu.ufcg.computacao.si1.model.usuario;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by adson_silva on 15/03/17.
 */
@Entity(name = "Financas")
@Table(name = "tb_financas")
public class Financas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private double saldo;

    @Column
    private ArrayList<String> extrato;

    public Financas(){
        this.saldo = saldo;
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

    public Long getId() { return this.id; }

    public void setId(Long id) {
        this.id = id;
    }
}
