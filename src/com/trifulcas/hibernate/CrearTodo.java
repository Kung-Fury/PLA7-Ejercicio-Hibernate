// Esta clase realiza todo lo solicitado en la tarea.

package com.trifulcas.hibernate;

import com.trifulcas.hibernate.entidades.Alumnos;
import com.trifulcas.hibernate.entidades.Modulos;
import com.trifulcas.hibernate.entidades.Profesores;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class CrearTodo {
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
			
			// Creamos profesores
			Profesores prof1 = new Profesores("Profesor 1", "AAAA000", "AAA@GGG.com");
			session.save(prof1);
			Profesores prof2 = new Profesores("Profesor 2", "BBBB111", "BBB@GGG.com");
			session.save(prof2);
			
			// Crearmos módulos
			Modulos mod1 = new Modulos("JAVA");
			Profesores prof = session.get(Profesores.class, 1);
			mod1.setProfesor(prof);
			session.save(mod1);	
			
			Modulos mod2 = new Modulos("C#");
			prof = session.get(Profesores.class, 2);
			mod2.setProfesor(prof);
			session.save(mod2);	
			
			// Creamos alumnos
			Alumnos alu1 = new Alumnos("Alumno 1", "HHH111@LLL.com");
			Modulos mod = session.get(Modulos.class, 1);
			alu1.addModulo(mod);
			session.save(alu1);
			
			Alumnos alu2 = new Alumnos("Alumno 2", "GGG222@LLL.com");
			alu2.addModulo(mod);
			session.save(alu2);
			
			Alumnos alu3 = new Alumnos("Alumno 3", "III333@LLL.com");
			mod2 = session.get(Modulos.class, 2);
			alu3.addModulo(mod2);
			session.save(alu3);
	
			// commit de la transacción
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}
}