package com.dam.DAM2_21_22_EjercicioHibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Linea {
	
	@Id
	private int codigo;
	@Column
	private String producto;
	@Column
	private int precio;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "numFactura", foreignKey = @ForeignKey(foreignKeyDefinition = "fk_linea"))
	private Factura factura;
	
	public Linea(int codigo, String producto, int precio) {
		this.codigo = codigo;
		this.producto = producto;
		this.precio = precio;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
	

}
