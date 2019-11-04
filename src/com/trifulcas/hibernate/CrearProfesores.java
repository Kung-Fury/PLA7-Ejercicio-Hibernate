package com.trifulcas.hibernate;
import com.trifulcas.hibernate.entidades.Alumnos;
import com.trifulcas.hibernate.entidades.Modulos;
import com.trifulcas.hibernate.entidades.Profesores;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class CrearProfesores {
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
			
			// Creamos profesores
			Profesores prof1 = new Profesores("Profesor 1", "AAAA000", "AAA@GGG.com");
			session.save(prof1);
			Profesores prof2 = new Profesores("Profesor 2", "BBBB111", "BBB@GGG.com");
			session.save(prof2);
	
			// commit de la transacci�n
			session.getTransaction().commit();
			
			
		} finally {
			factory.close();
		}
	}
}
