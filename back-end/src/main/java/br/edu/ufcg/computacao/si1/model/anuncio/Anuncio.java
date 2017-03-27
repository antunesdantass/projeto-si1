package br.edu.ufcg.computacao.si1.model.anuncio;

import br.edu.ufcg.computacao.si1.model.Nota;
import br.edu.ufcg.computacao.si1.model.usuario.PessoaFisica;
import br.edu.ufcg.computacao.si1.model.usuario.PessoaJuridica;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import com.fasterxml.jackson.annotation.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "tb_anuncio")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Emprego.class, name = "emprego"),
        @JsonSubTypes.Type(value = Imovel.class, name = "imovel"),
        @JsonSubTypes.Type(value = Movel.class, name = "movel"),
        @JsonSubTypes.Type(value = Servico.class, name = "servico")}
)
public abstract class Anuncio {

    private final static DateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");

    @Column(insertable = false, updatable = false)
    @JsonIgnore
    private String dtype;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @JoinColumn(name = "usuario_id")
    @ManyToOne
    private Usuario usuario;

    @NotNull(message = "O título não pode ser nulo.")
    @NotEmpty(message = "O título não pode estar vazio.")
    @Size(min = 10, max = 100, message = "O título deve ter entre 2 e 100 caracteres")
    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "data_criacao", nullable = false)
    @JsonFormat(pattern = "dd-MMM-yyyy HH:mm:ss")
    private Date dataDeCriacao;

    @NotNull(message = "O preço não pode ser nulo.")
    @DecimalMin(value = "0.1", message = "O preço minimo é 0.1 para um anúncio.")
    @Column(name = "preco", nullable = false)
    private double preco;

    @Enumerated(EnumType.STRING)
    @Column(name = "nota")
    private Nota nota;

    public Anuncio() {}

    public Anuncio(String titulo, double preco) {
        this.titulo = titulo;
        this.preco = preco;
    }

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

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public Usuario getUsuario() { return this.usuario; }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Anuncio anuncio = (Anuncio) o;

        if (Double.compare(anuncio.preco, preco) != 0) return false;
        if (titulo != null ? !titulo.equals(anuncio.titulo) : anuncio.titulo != null) return false;
        return dataDeCriacao != null ? dataDeCriacao.equals(anuncio.dataDeCriacao) : anuncio.dataDeCriacao == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = titulo != null ? titulo.hashCode() : 0;
        result = 31 * result + (dataDeCriacao != null ? dataDeCriacao.hashCode() : 0);
        temp = Double.doubleToLongBits(preco);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
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
