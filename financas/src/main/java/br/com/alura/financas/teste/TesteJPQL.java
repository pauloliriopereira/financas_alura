package br.com.alura.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TesteJPQL 
{
	public static void main( String[] args ) 
	{
		Conta conta = new Conta();
		conta.setId( 2 );
		
		EntityManager em = new JPAUtil().getEntityManager();
	    em.getTransaction().begin();

	    String jpql = "select m from Movimentacao m where m.conta = :pConta" + " and m.tipo = :pTipo" + " order by m.valor desc";
	    TypedQuery<Movimentacao> query = em.createQuery( jpql, Movimentacao.class );
	    query.setParameter( "pConta", conta );
	    query.setParameter( "pTipo", TipoMovimentacao.SAIDA );
	    
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