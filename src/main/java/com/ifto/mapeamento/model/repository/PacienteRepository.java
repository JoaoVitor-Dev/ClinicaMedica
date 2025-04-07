package com.ifto.mapeamento.model.repository;

import com.ifto.mapeamento.model.entity.Medico;
import com.ifto.mapeamento.model.entity.Paciente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PacienteRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(Paciente paciente){
        em.persist(paciente);
    }

    public Paciente paciente(Long id){
        return em.find(Paciente.class, id);
    }

    public List<Paciente> pacientes(){
        Query query = em.createQuery("from Paciente");
        return query.getResultList();
    }

    public void remove(Long id){
        Paciente p = em.find(Paciente.class, id);
        em.remove(p);
    }

    public void update(Paciente paciente){
        em.merge(paciente);
    }

    public List<Paciente> pesquisaPorNome(String nome) {
        String jpql = "SELECT p FROM Paciente p WHERE LOWER(p.nome) LIKE LOWER(:nome)";
        Query query = em.createQuery(jpql, Paciente.class);
        query.setParameter("nome", "%" + nome.toLowerCase() + "%");

        return query.getResultList();
    }
}
