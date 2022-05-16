package br.com.fiap.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "tb_produto")
@SequenceGenerator(name = "produto", sequenceName = "SQ_TB_PRODUTO", allocationSize = 1)
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido")
	private Long id;
	
	@Column(name = "ds_nome", length = 80, nullable = false)
	private String nome;
	
	@Column(name = "nr_valoor", length = 30, nullable = false)
	private int valor;
	
	@OneToMany(mappedBy="produto")
	private List<itemPedido> itemPedidos;
	
	public Produto () {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produto(String nome, int valor) {
		this();
		this.nome = nome;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "\nNome: " + this.getNome() 
				+ "\nValor" + this.getValor();
	}

}

