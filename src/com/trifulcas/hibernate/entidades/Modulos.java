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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "modulos")
public class Modulos {
	@Id
	@Column(name = "idmodulo")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idmodulo;
	@Column(name = "nombre")
	private String nombre;		
	
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH,	 CascadeType.REFRESH}, fetch=FetchType.LAZY)
	@JoinColumn(name="idprofesor")
	private Profesores profesor;
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinTable(name = "mod_alu", joinColumns = @JoinColumn(name="idmodulo"), inverseJoinColumns = @JoinColumn(name="idalumno"))
	private List<Alumnos> alumnos;
	public List<Alumnos> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(List<Alumnos> alumnos) {
		this.alumnos = alumnos;
	}
	public void addAlumno(Alumnos alumno) {
		if (alumnos == null) {
			alumnos = new ArrayList<Alumnos>();
		}
	alumnos.add(alumno);
	}	
	
	public Modulos() {
	}
	public Modulos(String nombre) {
		super();
		this.nombre = nombre;
	}
	public int getIdmodulo() {
		return idmodulo;
	}
	public void setIdmodulo(int idmodulo) {
		this.idmodulo = idmodulo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Profesores getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesores profesor) {
		this.profesor = profesor;
	}

	@Override
	public String toString() {
		return "Módulo [IDmodulo=" + idmodulo + ", Nombre módulo=" + nombre + ", IDProfesor="+profesor.getIdprofesor() 
		+ ", Nombre Profesor="+profesor.getNombre()+"]";
	}
}


