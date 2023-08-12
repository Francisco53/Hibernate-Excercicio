package br.com.cursopcv.respositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.cursopcv.modelo.Produto;

public class RepositorioProduto {

    EntityManagerFactory emf;

    public RepositorioProduto() {
        emf = Persistence.createEntityManagerFactory("exemplo-jpa");
    }

    public Produto salvar(Produto produto) {
    	EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            if (produto.getCod() == null) {
            	em.persist(produto);
            } else {
            	if (!em.contains(produto)) {
            		if (em.find(Produto.class, produto.getCod()) == null) {
            			throw new Exception("Erro ao atualizar o produto!");
            		}
            	}
            	produto = em.merge(produto);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
        	em.getTransaction().rollback();
        } finally {
			em.close();
		}
        return produto;
    }
    
    public Produto obterPorCod(Long cod) {
    	EntityManager em = emf.createEntityManager();
    	Produto produto = null;
    	try {
    		produto = em.find(Produto.class, cod);
    	} finally {
    		em.close();
    	}
    	return produto;
    }

    public List<Produto> listarTodos() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("FROM Produto", Produto.class).getResultList();
        } finally {
            em.close();
        }
    }
    
    public Produto atualizar(Produto produto) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            produto = em.merge(produto);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return produto;
    }
    
    public void removerPorCod(Long cod) {
    	EntityManager em = emf.createEntityManager();
    	Produto produto = em.find(Produto.class, cod);
    	try {
    		em.getTransaction().begin();
    		if (produto != null) {
    			em.remove(produto);
    		}
    		em.getTransaction().commit();
    	} finally {
    		em.close();
    	}
    }
    
    public void removerPorObjeto(Produto produto) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.contains(produto) ? produto : em.merge(produto));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public void fecharEntityManagerFactory() {
        emf.close();
    }
}
