package br.com.nc.aulas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity(name = "dados_pessoais")
public class DadosPessoais implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private String email;

    public DadosPessoais() {
    }

    public DadosPessoais(String nome, String sobrenome, LocalDate dataNascimento, String email) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }

    public Long getId() {
        return Id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DadosPessoais)) return false;
        DadosPessoais that = (DadosPessoais) o;
        return getId().equals(that.getId()) && Objects.equals(getNome(), that.getNome()) && Objects.equals(getSobrenome(), that.getSobrenome()) && Objects.equals(getDataNascimento(), that.getDataNascimento());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getSobrenome(), getDataNascimento());
    }
}
