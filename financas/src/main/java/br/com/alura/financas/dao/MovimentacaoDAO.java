package br.com.alura.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.TipoMovimentacao;

public class MovimentacaoDAO 
{
	private EntityManager manager;
	
	public MovimentacaoDAO( EntityManager manager ) 
	{
		this.manager = manager;
	}
	
	public List<Conta> buscaTodasAsMovimentacoes()
	{
		this.manager.getTransaction().begin();
		
		String jpql = "select distinct c from Conta c left join fetch c.movimentacoes";
		TypedQuery<Conta> query = manager.createQuery( jpql, Conta.class );
		
		return query.getResultList();
	}
	
	public List<Double> buscaMediaPorDataMovimentacoes( Conta conta )
	{	
		this.manager.getTransaction().begin();
		String jpql = "select avg(m.valor) from Movimentacao m"
		    		+ " where m.conta = :pConta "
		    		+ " and m.tipo = :pTipo"
		    		+ " group by m.data";
		 
		TypedQuery<Double> query = this.manager.createQuery( jpql, Double.class );
		query.setParameter( "pConta", conta );
		query.setParameter( "pTipo", TipoMovimentacao.SAIDA );
		
		return query.getResultList();
	}
}