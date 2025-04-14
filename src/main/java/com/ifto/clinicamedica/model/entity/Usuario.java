package com.ifto.clinicamedica.model.entity;

import jakarta.persistence.*;

import org.springframework.data.annotation.Id;
import java.io.Serializable;
import java.util.Set;


@Entity
public class Usuario implements Serializable {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private String login;
    private String senha;
    @OneToOne
    @JoinColumn(name = "pessoaID")
    private Pessoa pessoa;
    @ManyToMany(cascade = {CascadeType.MERGE})
    private Set<Perfil> perfis;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Perfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(Set<Perfil> perfis) {
        this.perfis = perfis;
    }
}
