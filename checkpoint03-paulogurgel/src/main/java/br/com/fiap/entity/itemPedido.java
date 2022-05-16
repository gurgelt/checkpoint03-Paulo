package br.com.fiap.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "tb_itemPedido")
@SequenceGenerator(name = "itemPedido", sequenceName = "SQ_TB_ITEMPEDIDO", allocationSize = 1)
public class itemPedido implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemPedido")
	private Long id;
	
	@Column(name = "nr_qtd", length = 30, nullable = false)
	private int qtd;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="pedido_id")
	private Pedido pedido;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="produto_id")
	private Produto produto;
	
	public itemPedido () {}

	public itemPedido(int qtd) {
		this();
		this.qtd = qtd;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	@Override
	public String toString() {
		return "\nQuantidade: " + this.getQtd();
	}

}

