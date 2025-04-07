package com.ifto.mapeamento.model.repository;

import com.ifto.mapeamento.model.entity.Agendamento;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;

import java.util.List;

@Repository
public class AgendamentoRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(Agendamento agendamento) {
        em.persist(agendamento);
    }

    public Agendamento agendamento(Long id) {
        return em.find(Agendamento.class, id);
    }

    public List<Agendamento> agendamentos() {
        Query query = em.createQuery("from Agendamento");
        return query.getResultList();
    }

    public void remove(Long id) {
        Agendamento agendamento = em.find(Agendamento.class, id);
        em.remove(agendamento);
    }

    public void update(Agendamento agendamento) {
        em.merge(agendamento);
    }
}
