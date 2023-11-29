package com.dawes.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.VariedadVO;
import com.dawes.servicios.ServicioVariedad;

@Controller
@RequestMapping("/variedades")
public class controladorVariedad {
	
	
	@Autowired
	ServicioVariedad sv;
	
	
	@RequestMapping("/mostrarvariedades")
	public String mostrar(Model modelo) {
		modelo.addAttribute("variedades", sv.findAll());
		return "variedad/mostrarvariedades";
	}
	
	
	@RequestMapping("/forminsertar")
	public String forminsertar(Model modelo) {
		modelo.addAttribute("variedad", new VariedadVO());
		return "variedad/forminsertar";
	}
	
	
	@RequestMapping("/insertar")
	public String insertar(@ModelAttribute VariedadVO variedad, Model modelo) {
		sv.save(variedad);
		modelo.addAttribute("variedades", sv.findAll());
		return "variedad/mostrarvariedades";
	}
	
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("idvariedad") int idvariedad, Model modelo) {
		sv.deleteById(idvariedad);
		modelo.addAttribute("variedades", sv.findAll());
		return "variedad/mostrarvariedades";
	}
	
	
	@RequestMapping("/formmodificar")
	public String modificar(@RequestParam("idvariedad") int idvariedad, Model modelo) {
		modelo.addAttribute("variedad", sv.findById(idvariedad).get());
		return "variedad/formmodificar";
	}

}
