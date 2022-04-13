package br.com.nc.aulas.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "aulas")
public class Aula implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime data;
    @ManyToOne
    private Sala salaDeAula;
    @ManyToMany
    private List<Aluno> alunos = new ArrayList<Aluno>();

    public Aula() {
    }

    public Aula(LocalDateTime data, Sala salaDeAula) {
        this.data = data;
        this.salaDeAula = salaDeAula;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void adicionaAluno(Aluno aluno){
        this.alunos.add(aluno);
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public Sala getSalaDeAula() {
        return salaDeAula;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aula)) return false;
        Aula aula = (Aula) o;
        return getId().equals(aula.getId()) && getData().equals(aula.getData()) && getSalaDeAula().equals(aula.getSalaDeAula()) && getAlunos().equals(aula.getAlunos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getData(), getSalaDeAula(), getAlunos());
    }
}
