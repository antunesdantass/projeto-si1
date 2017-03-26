package br.edu.ufcg.computacao.si1.model.anuncio;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import java.util.Date;

/**
 * Created by Antunes Dantas.
 */
public class Servico extends Anuncio {


    @Column(name = "data_execucao", nullable = true)
    @JsonFormat(pattern = "dd-MMM-yyyy HH:mm:ss")
    private Date dataDeExecucao;

    public Servico() { super(); }

    public Date getDataDeExecucao() {
        return this.dataDeExecucao;
    }

    public void setDataDeExecucao(Date dataDeExecucao) {
        this.dataDeExecucao = dataDeExecucao;
    }

}
