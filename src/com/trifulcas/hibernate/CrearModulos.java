package com.trifulcas.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.trifulcas.hibernate.entidades.Profesores;
import com.trifulcas.hibernate.entidades.Alumnos;
import com.trifulcas.hibernate.entidades.Modulos;

public class CrearModulos {
	public static void main(String[] args) {
		// Crear la configuración cogíendola del xml y añadiendo la clase Categorias
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Profesores.class).addAnnotatedClass(Modulos.class).addAnnotatedClass(Alumnos.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		
		// Crear la factoría de sesiones
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		// Crear la sesión
		Session session = factory.getCurrentSession();
		try {
			// Iniciar transacción
			session.beginTransaction();
			
	// Creamos módulos y le asignamos un profesor diferente
			Modulos mod1 = new Modulos("JAVA");
			Profesores prof = session.get(Profesores.class, 1);
			mod1.setProfesor(prof);
			session.save(mod1);	
			
			Modulos mod2 = new Modulos("C#");
			prof = session.get(Profesores.class, 2);
			mod2.setProfesor(prof);
			session.save(mod2);	
			
	/*		System.out.println(mod1);
			System.out.println(mod2);	*/
	
			// commit de la transacción
			session.getTransaction().commit();
		} finally {
			factory.close();
			}
	}
}
