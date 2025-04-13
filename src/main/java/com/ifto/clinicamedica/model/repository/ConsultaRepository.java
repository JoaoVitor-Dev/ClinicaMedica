package com.ifto.clinicamedica.model.repository;

import com.ifto.clinicamedica.model.entity.Consulta;
import com.ifto.clinicamedica.model.entity.Medico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Repository
public class ConsultaRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Consulta> consultas(){
        Query query = em.createQuery("from Consulta");
        return query.getResultList();
    }

    public Consulta consulta(Long id){
        return em.find(Consulta.class, id);
    }

    public double total(){
        Query query = em.createQuery("SELECT SUM(VALOR) FROM CONSULTA");
        return query.getFirstResult();
    }

    public double vTotal(){
        Query query = em.createQuery("select sum(valor) from Consulta ");
        List total;
        total = query.getResultList();
        return (Double) total.get(0);
    }

    public void save(Consulta consulta){
        em.persist(consulta);
    }

    public void remove(Long id){
        Consulta c = em.find(Consulta.class, id);
        em.remove(c);
    }

    public void update(Consulta consulta){
        em.merge(consulta);
    }

    public List<Medico> pesquisaPorData(String data) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
        LocalDateTime dataFormatada = LocalDateTime.parse(data, formatter);

        String jpql = "FROM Consulta WHERE data = :data";
        Query query = em.createQuery(jpql, Consulta.class);
        query.setParameter("data", dataFormatada);

        return query.getResultList();
    }

    public List<Consulta> consultasDoMedico(Medico medico) {
        Query query = em.createQuery("from Consulta WHERE medico = :medico ");
        query.setParameter("medico", medico);
        return query.getResultList();
    }

    public Double valorTotalMedico(Medico medico) {
        Query query = em.createQuery("select sum(valor) from Consulta WHERE medico = :medico ");
        query.setParameter("medico", medico);

        List total;
        total = query.getResultList();
        return (Double) total.get(0);
    }

}
