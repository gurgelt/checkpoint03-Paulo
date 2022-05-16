package br.com.fiap.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.*;

@Entity
@Table(name = "tb_boleto")
@SequenceGenerator(name = "boleto", sequenceName = "SQ_TB_BOLETO", allocationSize = 1)
public class Boleto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "boleto")
	private Long id;
	
	@Column(name = "nr_nosso", length = 30, nullable = false)
	private int nossoNumero;
	
	@Column(name = "dt_vencimento")
	private LocalDate dataVencimento;
	
	@Column(name = "nr_valor", length = 30, nullable = false)
	private String valor;
	
	@Column(name = "ds_codigo", length = 80, nullable = false, unique = true)
	private String codigoBarras;
	
	@OneToOne(mappedBy = "boleto")
	private Pedido pedido;
	
	public Boleto () {}

	public Boleto(int nossoNumero, LocalDate dataVencimento, String valor, String codigoBarras) {
		this();
		this.nossoNumero = nossoNumero;
		this.dataVencimento = dataVencimento;
		this.valor = valor;
		this.codigoBarras = codigoBarras;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNossoNumero() {
		return nossoNumero;
	}

	public void setNossoNumero(int nossoNumero) {
		this.nossoNumero = nossoNumero;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	
	@Override
	public String toString() {
		
		return "\nNosso número: " + this.getNossoNumero() 
			+ "\nData Vencimento: " + this.getDataVencimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
			+ "\nValor: " + this.getValor() 
			+ "\nCódigo de barras: " + this.getCodigoBarras();
	}

}
