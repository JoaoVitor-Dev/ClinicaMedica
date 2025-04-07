package com.ifto.mapeamento.model.entity;

import com.ifto.mapeamento.model.validation.groups.Insert;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "tipo")
public class Pessoa {
    @NotNull(message = "Por favor, preencha este campo", groups = Insert.class)
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private Long id;
    @NotBlank(message = "Por favor, informe o nome!")
//    @NotBlank(message = "Por favor, informe o nome!", groups = Insert.class)
    private String nome;
    @NotBlank(message = "Por favor, informe o telefone!")
    private String telefone;

    @NotBlank(message = "Por favor, informe o CPF!")
    private String cpf;

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
