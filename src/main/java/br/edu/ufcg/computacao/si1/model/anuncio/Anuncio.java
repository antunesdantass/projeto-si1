package br.edu.ufcg.computacao.si1.model.anuncio;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "tb_anuncio")
public abstract class Anuncio {

    private final static DateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "data_criacao", nullable = false)
    private Date dataDeCriacao;

    @Column(name = "preco", nullable = false)
    private double preco;

    @Column(name = "nota")
    private String nota;

    @ManyToMany
    @JoinColumn()

    public Anuncio(String titulo, Date dataDeCriacao, double preco) {
        this.titulo = titulo;
        this.dataDeCriacao = dataDeCriacao;
        this.preco = preco;
    }

    public Anuncio() {}

    public Long getId() {
        return id;
    }

   public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDataDeCriacao() {
        return DATE_FORMAT.format(dataDeCriacao);
    }

    public void setDataDeCriacao(Date dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Anuncio anuncio = (Anuncio) o;

        if (!id.equals(anuncio.id)) return false;
        return titulo.equals(anuncio.titulo);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + titulo.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Anuncio{" +
                "_id=" + id +
                ", titulo='" + titulo + '\'' +
                ", dataDeCriacao=" + getDataDeCriacao() +
                ", preco=" + preco +
                ", nota=" + nota +
                '}';
    }
}
