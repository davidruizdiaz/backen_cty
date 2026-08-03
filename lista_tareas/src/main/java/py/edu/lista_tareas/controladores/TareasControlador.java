package py.edu.lista_tareas.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import py.edu.lista_tareas.modelos.Tarea;
import py.edu.lista_tareas.servicios.TareaServicio;

@Controller
public class TareasControlador {

  @Autowired
  private TareaServicio servicio;

  // Controlador para la página principal
  @GetMapping("/")
  public String mostrarIndex(Model m) {
    Tarea tarea = new Tarea();
    List<Tarea> listaTareas = servicio.listarTareas();

    m.addAttribute("tarea", tarea);
    m.addAttribute("titulo_de_la_pagina", ".:: Lista de Tareas ::.");
    m.addAttribute("todas_las_tareas", listaTareas);
    return "index";
  }

  // Controlador para guardar
  @PostMapping("/guardar")
  public String guardar(@ModelAttribute Tarea t) {
    servicio.guardarTarea(t);

    return "redirect:/";
  }

  @PostMapping("/completar/{id}")
  public String completar(@PathVariable Long id) {
    servicio.marcarCompletada(id);
    return "redirect:/";
  }

  @PostMapping("/eliminar/{id}")
  public String eliminar(@PathVariable Long id) {
    servicio.eliminarTarea(id);
    return "redirect:/";
  }

  @GetMapping("/tareas")
  public String mostrarTareas(@RequestParam String nombre, Model m) {
    m.addAttribute("saludo", "Hola " + nombre + "!!");
    return "prueba";
  }

}
