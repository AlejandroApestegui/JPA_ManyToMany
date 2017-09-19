package edu.main;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.dominio.Empleado;
import edu.dominio.Proyecto;

public class GestorEntidades {

	private EntityManager entityManager;

	public GestorEntidades(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public static void main(String[] args) {

		Logger.getLogger("org.hibernate").setLevel(Level.OFF);

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ManyToMany");
		EntityManager manager = factory.createEntityManager();
		GestorEntidades gestor = new GestorEntidades(manager);

		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		gestor.entityManager.persist(new Empleado("Alejandro"));
		gestor.crearProyectosDesdeUnEmpleado();
		transaction.commit();

	}

	public void crearProyectosDesdeUnEmpleado() {
		Empleado empleado = entityManager.find(Empleado.class, new Long(1));

		Proyecto proy1 = new Proyecto("Market Place");
		Proyecto proy2 = new Proyecto("e-commerce");

		List<Proyecto> proyectos = Arrays.asList(proy1, proy2);

		empleado.setProyectos(proyectos);
		entityManager.persist(empleado);

	}
}
