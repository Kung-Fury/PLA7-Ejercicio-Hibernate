package com.trifulcas.hibernate;

import com.trifulcas.hibernate.entidades.Alumnos;
import com.trifulcas.hibernate.entidades.Modulos;
import com.trifulcas.hibernate.entidades.Profesores;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class LeerModulo {
	public static void main(String[] args) {
		// Crear la configuraci�n cog�endola del xml y a�adiendo la clase Categorias
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Profesores.class).addAnnotatedClass(Modulos.class).addAnnotatedClass(Alumnos.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		
		// Crear la factor�a de sesiones
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		// Crear la sesi�n
		Session session = factory.getCurrentSession();
		try {
			// Iniciar transacci�n
			session.beginTransaction();
			
			Modulos mod = session.get(Modulos.class, 1);
			System.out.println(mod);
			mod = session.get(Modulos.class, 2);
			System.out.println(mod);
		
			// commit de la transacci�n
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}
}

