package com.dam.DAM2_21_22_EjercicioHibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Factura {
	
	@Id
	private int numero;
	@Column
	private int total;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codCliente", foreignKey = @ForeignKey(foreignKeyDefinition = "fk_cliente"))
	private Cliente cliente;
	@OneToMany(mappedBy = "factura", fetch = FetchType.LAZY)
	private List<Linea> lineas = new ArrayList<Linea>();

	
	public Factura(int numero, int total) {
		this.numero = numero;
		this.total = total;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	public List<Linea> getLineas() {
		return lineas;
	}

	public void setLineas(List<Linea> lineas) {
		this.lineas = lineas;
	}
	
	
	
}
