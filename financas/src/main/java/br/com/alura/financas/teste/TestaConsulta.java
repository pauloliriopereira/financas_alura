package br.com.alura.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.financas.modelo.Categoria;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TestaConsulta 
{
	public static void main( String[] args ) 
	{
		EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Categoria categoria = new Categoria();
        categoria.setId(1);

        String jpql = "select m from Movimentacao m join m.categoria c where c = :pCategoria";

        TypedQuery<Movimentacao> query = em.createQuery( jpql, Movimentacao.class );
        query.setParameter("pCategoria", categoria);

        List<Movimentacao> resultados = query.getResultList();
        
        for( Movimentacao movimentacao : resultados ) 
	    {
	        System.out.println( "Descricao: " + movimentacao.getDescricao() );
	        System.out.println( "Conta.id: " + movimentacao.getConta().getId() );
	    } 
	    
	    em.getTransaction().commit();
	    em.close();
	}
}