package com.trifulcas.hibernate.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "profesores")
public class Profesores {
	@Id
	@Column(name = "idprofesor")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idprofesor;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "dni")
	private String dni;
	
	@Column(name = "email")
	private String email;
	
	@OneToMany(mappedBy="profesor", cascade= {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Modulos> modulos;
	public List<Modulos> getModulos() {
		return modulos;
	}
	public void setModulos(List<Modulos> modulos) {
		this.modulos = modulos;
	}
	public void addModulos(Modulos modulo) {
		if (modulos ==null) {
			modulos =new ArrayList<Modulos>();
		}
		modulos.add(modulo);
		modulo.setProfesor(this);
	}
	
//	private Modulos modulo;

	public Profesores() {
	}
		public Profesores(String nombre, String dni, String email) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.email = email;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getIdprofesor() {
		return idprofesor;
	}
	public void setIdprofesor(int idprofesor) {
		this.idprofesor = idprofesor;
	}

	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		String mods="";
		for(Modulos m:modulos) {
			mods+=m.getNombre()+"|";
		}
		return "Profesor [IDprofesor=" + idprofesor + ", Nombre=" + nombre + ", DNI= "+ dni + ", email= " + email +  ", Módulos=" + mods + "]";
	}
}