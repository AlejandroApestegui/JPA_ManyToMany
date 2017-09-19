package edu.dominio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_EMPLEADO")
public class Empleado {

	@Id
	@GeneratedValue
	@Column(name = "EMP_ID")
	private Long id;

	private String nombre;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "tb_emp_x_proy", joinColumns = @JoinColumn(name = "EMPID", referencedColumnName = "EMP_ID"), inverseJoinColumns = @JoinColumn(name = "PROYID", referencedColumnName = "PROY_ID"))
	private List<Proyecto> proyectos;

	public Empleado() {

	}

	public Empleado(String nombre) {
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + "]";
	}

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

}
