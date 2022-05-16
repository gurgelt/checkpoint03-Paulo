package br.com.fiap.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "tb_pedido")
@SequenceGenerator(name = "pedido", sequenceName = "SQ_TB_PEDIDO", allocationSize = 1)
@NamedQueries({
	@NamedQuery(name = "Pedido.listarPorCPF", 
			query = "SELECT a FROM Pedido a WHERE a.pedido.cpf = :uf")
})
public class Pedido implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido")
	private Long id;
	
	@Column(name = "nr_pedido", length = 40, nullable = false)
	private int numeroPedido;
	
	@Column(name = "vl_total", length = 30, nullable = false)
	private int valorTotal;
	
	@Column(name = "nr_cpf", length = 14, nullable = false, unique = true)
	private String cpf;
	
	@OneToOne
	@JoinColumn(name="pedido_id")
	private Boleto boleto;
	
	@OneToMany(mappedBy="pedido")
	private List<itemPedido> itemPedidos;
	
	public Pedido () {}

	public Pedido(int numeroPedido, int valorTotal, String cpf) {
		this();
		this.numeroPedido = numeroPedido;
		this.valorTotal = valorTotal;
		this.cpf = cpf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public int getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public int getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(int valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		
		return "\nNumero Pedido: " + this.getNumeroPedido() 
			+ "\nValor Total: " + this.getValorTotal()
			+ "\nCPF: " + this.getCpf();
	}

}

