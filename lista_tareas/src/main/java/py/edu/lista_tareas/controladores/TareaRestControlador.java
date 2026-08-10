package py.edu.lista_tareas.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import py.edu.lista_tareas.modelos.Tarea;
import py.edu.lista_tareas.servicios.TareaServicio;

@RestController
public class TareaRestControlador {

  // Servicio que recupera los datos de la db
  @Autowired
  private TareaServicio servicio;

  // Los endpoints

  // Para listar las tareas
  @GetMapping("/listar")
  public List<Tarea> lista() {
    return servicio.listarTareas();
  }

  @PostMapping("/crear")
  public Tarea guardar(@RequestBody Tarea tareaAGuardar) {
    return servicio.guardarTarea(tareaAGuardar);
  }

  @PutMapping("/completar")
  public Boolean completar(@RequestBody Long id) {
    return servicio.marcarCompletada(id);
  }

  @DeleteMapping("/eliminar")
  public void eliminar(@RequestBody Long id) {
    servicio.eliminarTarea(id);
  }

}
