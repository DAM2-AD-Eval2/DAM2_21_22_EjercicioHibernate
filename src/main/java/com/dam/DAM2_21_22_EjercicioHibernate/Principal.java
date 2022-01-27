package com.dam.DAM2_21_22_EjercicioHibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Principal {

	public static void main(String[] args) {
		
		//Crear los objetos
		Cliente cli1 = new Cliente(1, "Pepito", "981111111");
		Cliente cli2 = new Cliente(2, "Fulanito", "981222222");
		
		Factura fac1 = new Factura(10, 250);
		fac1.setCliente(cli1);
		Factura fac2 = new Factura(20, 400);
		fac2.setCliente(cli2);
		
		List<Linea> listaLineas1 = new ArrayList<Linea>();
		Linea linea1F1 = new Linea(10, "Monitores", 100);
		linea1F1.setFactura(fac1);
		listaLineas1.add(linea1F1);
		Linea linea2F1 = new Linea(20, "Teclados", 150);
		linea2F1.setFactura(fac1);
		listaLineas1.add(linea2F1);
		fac1.setLineas(listaLineas1);
		
		List<Linea> listaLineas2 = new ArrayList<Linea>();
		Linea linea1F2 = new Linea(30, "Ratones", 250);
		linea1F2.setFactura(fac2);
		listaLineas2.add(linea1F2);
		Linea linea2F2 = new Linea(40, "RAM", 150);
		linea2F2.setFactura(fac2);
		listaLineas2.add(linea2F2);
		fac2.setLineas(listaLineas2);
		
		//Creación del SessionFactory
		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();   	
		SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();

		//Creamos la sesión
		Session sesion = sf.openSession();

		//Comenzamos la transacción
		sesion.beginTransaction();

			sesion.save(cli1);
			sesion.save(cli2);
			sesion.save(fac1);
			sesion.save(fac2);
			sesion.save(linea1F1);
			sesion.save(linea2F1);
			sesion.save(linea1F2);
			sesion.save(linea2F2);

	     sesion.getTransaction().commit();


		//Cerramos objetos
		sesion.close();
		sf.close();

	}

}
