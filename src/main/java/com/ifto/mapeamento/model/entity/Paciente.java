package com.ifto.mapeamento.model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@DiscriminatorValue("P")
@PrimaryKeyJoinColumn(name = "id")
public class Paciente extends Pessoa implements Serializable {

    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consultas;

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
