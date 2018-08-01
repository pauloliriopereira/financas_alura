package br.com.alura.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.financas.dao.MovimentacaoDAO;
import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TesteTodasAsMovimentacoesDasContas 
{
	public static void main( String[] args ) 
	{
		EntityManager em = new JPAUtil().getEntityManager();
		MovimentacaoDAO dao = new MovimentacaoDAO( em );
		
		List<Conta> contas = dao.buscaTodasAsMovimentacoes();
		
		for( Conta conta : contas ) 
		{
			System.out.println( "Titular: " + conta.getTitular() );
			System.out.println( "Movimentacoes:" );
			System.out.println( conta.getMovimentacoes() );
		}
		
		em.close();
	}
}