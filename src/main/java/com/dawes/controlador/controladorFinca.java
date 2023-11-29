package com.dawes.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.FincaVO;
import com.dawes.servicios.ServicioArbol;
import com.dawes.servicios.ServicioFinca;

@Controller
@RequestMapping("/fincas")
public class controladorFinca {
	
	@Autowired
	ServicioFinca sf;
	
	@Autowired
	ServicioArbol sa;
	
	
	@RequestMapping("mostrarfincas")
	public String mostrar(Model modelo) {
		modelo.addAttribute("fincas", sf.findAll());
		return "finca/mostrarfincas";
	}
	
	
	@RequestMapping("/forminsertar")
	public String forminsertar(Model modelo) {
		modelo.addAttribute("finca", new FincaVO());
		return "finca/forminsertar";
	}
	
	
	@RequestMapping("/insertar")
	public String insertar(@ModelAttribute FincaVO finca, Model modelo) {
		sf.save(finca);
		modelo.addAttribute("fincas", sf.findAll());
		return "finca/mostrarfincas";
	}
	
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("idfinca") int idfinca, Model modelo) {
		sf.deleteById(idfinca);
		modelo.addAttribute("fincas", sf.findAll());
		return "finca/mostrarfincas";
	}
	
	
	@RequestMapping("/formmodificar")
	public String modificar(@RequestParam("idfinca") int idfinca, Model modelo) {
		modelo.addAttribute("finca", sf.findById(idfinca).get());
		return "finca/formmodificar";
	}
	
	
	@RequestMapping("/arbolesfinca")
	public String arbolesfinca(@RequestParam("idfinca") int idfinca, Model modelo) {
		modelo.addAttribute("finca", sf.findById(idfinca).get());
		modelo.addAttribute("arboles",sa.findAllByFinca(sf.findById(idfinca).get()));
		return "arbol/mostrararboles";
	}
	
	@RequestMapping("/fincaplano")
	public String plano(@RequestParam("idfinca") int idfinca, Model modelo) {
		FincaVO finca = sf.findById(idfinca).get();
		modelo.addAttribute("finca", finca);
		return "finca/fincaplano";
	}

}
