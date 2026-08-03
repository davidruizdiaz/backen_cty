package py.edu.lista_tareas.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import py.edu.lista_tareas.modelos.Tarea;

public interface TareaRepositorio extends JpaRepository<Tarea, Long> {

  @Query("SELECT t FROM Tarea t ORDER BY t.completada ASC, t.id DESC")
  List<Tarea> listar();
}
