package br.edu.ufcg.computacao.si1.model.usuario;

import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Usuario")
@Table(name = "tb_usuario")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PessoaFisica.class, name = "Fisica"),

        @JsonSubTypes.Type(value = PessoaJuridica.class, name = "Juridica") }
)
public abstract class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "O nome não pode ser nulo.")
    @NotEmpty(message = "O nome não pode ser vazio.")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres.")
    @Column
    private String nome;

    @NotEmpty(message = "O email não pode ser vazio.")
    @Email
    @Column(unique = true)
    private String email;

    @NotNull(message = "A senha não pode ser nula.")
    @NotEmpty
    @Size(min = 4, max = 16, message = "A senha deve ter entre 4 e 16 caracteres.")
    @Column
    private String senha;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Financas financas;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Anuncio> anuncios;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.financas = new Financas();
        this.anuncios = new HashSet<Anuncio>();
    }

    public Usuario() {
        this.financas = new Financas();
        this.anuncios = new HashSet<Anuncio>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void comprar(double valor){
        financas.debitar(valor);
    }

    public void vender(double valor){
        financas.creditar(valor);
    }

    public Set<Anuncio> getAnuncios() {
        return anuncios;
    }

    public void setAnuncios(Set<Anuncio> anuncios) {
        this.anuncios = anuncios;
    }

    public void addAnuncio(Anuncio anuncio) {
        this.anuncios.add(anuncio);
    }

    public void removeAnuncio(Anuncio anuncio) {
        this.anuncios.remove(anuncio);
    }

    public Financas getFinancas(){
        return this.financas;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", financas='" + financas.getSaldo() + '\'';
    }
}
