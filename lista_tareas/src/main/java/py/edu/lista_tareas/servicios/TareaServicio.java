package py.edu.lista_tareas.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.edu.lista_tareas.modelos.Tarea;
import py.edu.lista_tareas.repositorios.TareaRepositorio;

@Service
public class TareaServicio {

  @Autowired
  private TareaRepositorio repo;

  public Tarea guardarTarea(Tarea tareaAGuardar) {
    Tarea tareaGuardada = repo.save(tareaAGuardar);
    return tareaGuardada;
  }

  public List<Tarea> listarTareas() {
    return repo.listar();
  }

  public void eliminarTarea(Long idAEliminar) {
    repo.deleteById(idAEliminar);
  }

  public Boolean marcarCompletada(Long idACompletar) {
    Tarea tareaRecuperada = repo.findById(idACompletar).get();
    if (tareaRecuperada == null) {
      return false;
    }
    tareaRecuperada.setCompletada(true);
    repo.save(tareaRecuperada);
    return true;
  }

}
