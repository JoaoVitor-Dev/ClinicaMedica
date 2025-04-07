package com.ifto.mapeamento.model.repository;

import com.ifto.mapeamento.model.entity.Medico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicoRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(Medico medico){
        em.persist(medico);
    }

    public Medico medico(Long id){
        return em.find(Medico.class, id);
    }

    public List<Medico> medicos(){
        Query query = em.createQuery("from Medico");
        return query.getResultList();
    }

    public void remove(Long id){
        Medico v = em.find(Medico.class, id);
        em.remove(v);
    }

    public void update(Medico medico){
        em.merge(medico);
    }

    public List<Medico> pesquisaPorNome(String nome) {
        String jpql = "SELECT m FROM Medico m WHERE LOWER(m.nome) LIKE LOWER(:nome)";
        Query query = em.createQuery(jpql, Medico.class);
        query.setParameter("nome", "%" + nome.toLowerCase() + "%");

        return query.getResultList();
    }

}
