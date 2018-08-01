package br.com.alura.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TesteConsultaFuncaoMax 
{
	public static void main( String[] args ) 
	{	
		Conta conta = new Conta();
		conta.setId( 2 );
		
		EntityManager em = new JPAUtil().getEntityManager();
	    em.getTransaction().begin();

	    String jpql = "select max(m.valor) from Movimentacao m where m.conta = :pConta";
	    Query query = em.createQuery( jpql );
	    query.setParameter( "pConta", conta );
	    
	    BigDecimal maior = ( BigDecimal ) query.getSingleResult();
	    
	    System.out.println( "O maior valor é: " + maior );
	    
	    em.getTransaction().commit();
	    em.close();
	}
}