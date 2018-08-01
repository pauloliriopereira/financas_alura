package br.com.alura.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TesteFuncoesJPQL 
{
	public static void main( String[] args ) 
	{
		Conta conta = new Conta();
		conta.setId( 2 );
		
		EntityManager em = new JPAUtil().getEntityManager();
	    em.getTransaction().begin();

	    String jpql = "select avg(m.valor) from Movimentacao m where m.conta = :pConta" + " and m.tipo = :pTipo" + " order by m.valor desc";
	    Query query = em.createQuery( jpql );
	    query.setParameter( "pConta", conta );
	    query.setParameter( "pTipo", TipoMovimentacao.SAIDA );
	    
	    Double soma = ( Double ) query.getSingleResult();
	    System.out.println( "A media é: " + soma ); 
	    
	    em.getTransaction().commit();
	    em.close();
	}
}