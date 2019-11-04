package com.trifulcas.hibernate;
import com.trifulcas.hibernate.entidades.Alumnos;
import com.trifulcas.hibernate.entidades.Modulos;
import com.trifulcas.hibernate.entidades.Profesores;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class CrearAlumnos {
	public static void main(String[] args) {
		// Crear la configuración cogíendola del xml y añadiendo la clase Categorias
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alumnos.class).addAnnotatedClass(Modulos.class).addAnnotatedClass(Profesores.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		
		// Crear la factoría de sesiones
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		// Crear la sesión
		Session session = factory.getCurrentSession();
		try {
			// Iniciar transacción
			session.beginTransaction();
			

			Alumnos alu1 = new Alumnos("Alumno 1", "HHH111@LLL.com");
			Modulos mod = session.get(Modulos.class, 1);
			alu1.addModulo(mod);
			session.save(alu1);
			
			Alumnos alu2 = new Alumnos("Alumno 2", "GGG222@LLL.com");
			alu2.addModulo(mod);
			session.save(alu2);
			
			Alumnos alu3 = new Alumnos("Alumno 3", "III333@LLL.com");
			Modulos mod2 = session.get(Modulos.class, 2);
			alu3.addModulo(mod2);
			session.save(alu3);
			
			
			// commit de la transacción
				session.getTransaction().commit();	
			
			} finally {
				factory.close();
			}
	
	}
}