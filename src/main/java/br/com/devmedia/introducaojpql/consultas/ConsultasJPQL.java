package br.com.devmedia.introducaojpql.consultas;

import br.com.devmedia.introducaojpql.dao.JPAUtil;
import br.com.devmedia.introducaojpql.domain.Serie;
import javax.persistence.EntityManager;
import java.util.List;

public class ConsultasJPQL {


    /*Listar todos*/
    public List<Serie> listarTodasSeries(){
        EntityManager em = JPAUtil.getEntityManager();

        String queryJPQL = "SELECT s from Serie s";
        return em.createQuery(queryJPQL, Serie.class)
                .getResultList();
    }

    /* Listar com ano fixo*/
    public List<Serie> listarSeriesCriadasNoAno2008(){
        EntityManager em = JPAUtil.getEntityManager();

        String queryJPQL = "SELECT s FROM Serie s WHERE s.anoCriacao = 2008";
        return em.createQuery(queryJPQL, Serie.class)
                .getResultList();
    }


    /* Lista ano passando parametro*/
    public List<Serie> listarSeriesCriadasNoAno(int ano) {
        EntityManager em = JPAUtil.getEntityManager();

        String queryJPQL = "SELECT s FROM Serie s WHERE s.anoCriacao = :anoDesejado";

        return em.createQuery(queryJPQL, Serie.class)
                .setParameter("anoDesejado", ano)
                .getResultList();
    }

    /* Lista ano passando parametro nome*/
    public List<Serie> listarSeriesCujoNomeContenha(String nome){
        EntityManager em = JPAUtil.getEntityManager();

        String queryJPQL = "SELECT s FROM Serie s " +
                "WHERE s.nome LIKE :nome";

        return em.createQuery(queryJPQL, Serie.class)
                .setParameter("nome", "%" + nome + "%")
                .getResultList();
    }

    /* Lista ano passando parametro nome e ano*/
    public Serie recuperarSeriePorAnoENome(String nome, int ano) {
        EntityManager em = JPAUtil.getEntityManager();
        String queryJpql = "SELECT s FROM Serie s WHERE s.nome LIKE :nome AND s.anoCriacao = :ano";

        return em.createQuery(queryJpql, Serie.class)
                .setParameter("nome", nome)
                .setParameter("ano", ano)
                .getSingleResult();
    }

    public String recuperarSeriePorNomeEAno2(String nome, int ano) {
        EntityManager em = JPAUtil.getEntityManager();

        String queryJpql = "SELECT s.nome FROM Serie s WHERE s.nome LIKE :nome AND s.anoCriacao = :ano";

        return em.createQuery(queryJpql, String.class)
                .setParameter("nome", nome)
                .setParameter("ano", ano)
                .getSingleResult();
    }

}
