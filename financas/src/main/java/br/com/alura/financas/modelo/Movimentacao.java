package br.com.alura.financas.modelo;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Movimentacao 
{
	@Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;
	private BigDecimal valor;
	
	@Enumerated( EnumType.STRING )
	private TipoMovimentacao tipo;
	
	@Temporal( TemporalType.TIMESTAMP )
	private Calendar data;
	
	private String descricao;
	private Conta conta;

	public Integer getId()
	{
		return id;
	}

	public void setId( Integer id ) 
	{
		this.id = id;
	}

	public BigDecimal getValor() 
	{
		return valor;
	}

	public void setValor( BigDecimal valor )
	{
		this.valor = valor;
	}

	public TipoMovimentacao getTipoMovimentacao() 
	{
		return tipo;
	}

	public void setTipoMovimentacao( TipoMovimentacao tipo ) 
	{
		this.tipo = tipo;
	}

	public Calendar getData()
	{
		return data;
	}

	public void setData( Calendar data ) 
	{
		this.data = data;
	}

	public String getDescricao() 
	{
		return descricao;
	}

	public void setDescricao( String descricao ) 
	{
		this.descricao = descricao;
	}

	public Conta getConta() 
	{
		return conta;
	}

	public void setConta( Conta conta )
	{
		this.conta = conta;
	}
}