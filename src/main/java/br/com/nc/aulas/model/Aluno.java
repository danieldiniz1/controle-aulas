package br.com.nc.aulas.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity(name = "alunos")
public class Aluno implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private DadosPessoais dadosPessoais;

    public Aluno() {
    }

    public Aluno(DadosPessoais dadosPessoais) {
        this.dadosPessoais = dadosPessoais;
    }

    public Long getId() {
        return id;
    }

    public DadosPessoais getDadosPessoais() {
        return dadosPessoais;
    }

    public String getNome(){
        return this.dadosPessoais.getNome();
    }

    public String getSobrenome() {
        return this.dadosPessoais.getSobrenome();
    }

    public LocalDate getDataNascimento() {
        return this.dadosPessoais.getDataNascimento();
    }

    public String getEmail() {
        return this.dadosPessoais.getEmail();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluno)) return false;
        Aluno aluno = (Aluno) o;
        return getId().equals(aluno.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
