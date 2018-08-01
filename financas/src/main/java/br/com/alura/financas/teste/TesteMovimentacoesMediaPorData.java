package br.com.alura.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.financas.dao.MovimentacaoDAO;
import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TesteMovimentacoesMediaPorData 
{
	public static void main( String[] args ) 
	{
		EntityManager em = new JPAUtil().getEntityManager();
	    em.getTransaction().begin();
	    
	    Conta conta = em.find( Conta.class, 2 );
	    
	    MovimentacaoDAO dao = new MovimentacaoDAO( new JPAUtil().getEntityManager() );
	    
	    List<Double> medias = dao.buscaMediaPorDataMovimentacoes( conta );
	    
	    for( Double media : medias ) 
	    {
	    	System.out.println( "O maior valor é: " + media );
		}
	}
}