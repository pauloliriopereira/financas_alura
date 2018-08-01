package br.com.alura.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TesteTodasAsMovimentacoesDasContas 
{
	public static void main( String[] args ) 
	{
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		String jpql = "select distinct c from Conta c left join fetch c.movimentacoes";
		TypedQuery<Conta> query = em.createQuery( jpql, Conta.class );
		
		List<Conta> contas = query.getResultList();
		
		for( Conta conta : contas ) 
		{
			System.out.println( "Titular: " + conta.getTitular() );
			System.out.println( "Movimentacoes:" );
			System.out.println( conta.getMovimentacoes() );
		}
	}
}