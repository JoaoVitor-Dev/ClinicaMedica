package com.ifto.mapeamento.model.repository;

import com.ifto.mapeamento.model.entity.Agenda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AgendaRepository {
    @PersistenceContext
    private EntityManager em;
    public void save(Agenda agenda){
        em.persist(agenda);
    }

    public Agenda agenda(Long id) {
        return em.find(Agenda.class, id);
    }

    public List horarios() {
        Query query = em.createQuery("from Agenda");
        return query.getResultList();
    }

    public void remove(Long id) {
        Agenda agenda = em.find(Agenda.class, id);
        em.remove(agenda);
    }

    public void update(Agenda agenda) {
        em.merge(agenda);
    }

    public List<Agenda> agendasPorMedico(Long idMedico) {
        Query query = em.createQuery("SELECT a FROM Agenda a WHERE a.medico.id = :idMedico and a.disponivel = true" );
        query.setParameter("idMedico", idMedico);
        return query.getResultList();
    }
}
