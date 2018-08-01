package br.com.alura.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TesteConsultaFuncaoCount 
{
	public static void main( String[] args ) 
	{
		EntityManager em = new JPAUtil().getEntityManager();
	    em.getTransaction().begin();
	    Conta conta = em.find( Conta.class, 2 );
	    
	    TypedQuery<Long> typedQuery = em.createNamedQuery( "ContaMovimentacao", Long.class );
	    typedQuery.setParameter( "pConta", conta );
	    
	    Long quantidade = ( Long ) typedQuery.getSingleResult();
	    
	    System.out.println( "Total de movimentações é: " + quantidade );
	    
	    em.close();
	}
}