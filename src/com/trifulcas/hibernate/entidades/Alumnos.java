package com.trifulcas.hibernate.entidades;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "alumnos")
public class Alumnos {
	@Id
	@Column(name = "idalumno")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idalumno;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "email")
	private String email;
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinTable(name = "mod_alu", joinColumns = @JoinColumn(name="idalumno"), inverseJoinColumns = @JoinColumn(name="idmodulo"))
	
	private List<Modulos> modulos;
	public List<Modulos> getModulos() {
		return modulos;
	}
	public void setModulos(List<Modulos> modulos) {
		this.modulos = modulos;
	}
	public void addModulo(Modulos modulo) {
		if (modulos == null) {
			modulos = new ArrayList<Modulos>();
		}
	modulos.add(modulo);
	}
	
	public Alumnos() {
	}
	public Alumnos(String nombre, String email) {
		super();
		this.nombre = nombre;
		this.email = email;
	}
	public int getIdalumno() {
		return idalumno;
	}
	public void setIdalumno(int idalumno) {
		this.idalumno = idalumno;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		return "Alumno [IDalumno=" + idalumno + ", Nombre alumno=" + nombre + ", eMail=" + email + ", "
				+ ", Módulos=" + mods + "]";
		}
}


