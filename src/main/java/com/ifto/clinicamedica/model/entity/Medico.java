package com.ifto.clinicamedica.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.List;

@Entity
@DiscriminatorValue("M")
@PrimaryKeyJoinColumn(name = "id")
public class Medico extends Pessoa implements Serializable {
    @NotBlank(message = "Por favor, informe o CRM!")
    private String crm;

    @OneToMany(mappedBy = "medico")
    private List<Consulta> consultas;

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public double valorTotal(){
        double total = 0.00;

        for (Consulta consulta : consultas) {
            total += consulta.getValor();
        }
        return total;
    }
}
