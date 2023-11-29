package com.dawes.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.FotoVO;
import com.dawes.servicios.ServicioArbol;
import com.dawes.servicios.ServicioFoto;

@Controller
@RequestMapping("/fotos")
public class controladorFoto {
	
	@Autowired
	ServicioFoto sf;
	
	@Autowired
	ServicioArbol sa;
	
	
	@RequestMapping("/mostrarfotos")
	public String mostrar(Model modelo,@RequestParam("idarbol") int idarbol) {
		modelo.addAttribute("fotos",sf.findAllByArbol(sa.findById(idarbol).get()));
		modelo.addAttribute("arbol",sa.findById(idarbol).get());
		return "foto/mostrarfotos";
	}
	
	
	@RequestMapping("/forminsertar")
	public String forminsertar(Model modelo, @RequestParam("idarbol") int idarbol) {
		FotoVO foto = new FotoVO();
		foto.setArbol(sa.findById(idarbol).get());
		modelo.addAttribute("foto", foto);
		modelo.addAttribute("arboles", sa.findAll());
		return "foto/forminsertar";
	}
	
	
	@RequestMapping("/insertar")
	public String Insertar(@ModelAttribute FotoVO foto, Model modelo) {
		sf.save(foto);
		modelo.addAttribute("fotos", sf.findAllByArbol(foto.getArbol()));
		modelo.addAttribute("arbol", foto.getArbol());
		return "foto/mostrarfotos";
	}
	
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("idfoto") int idfoto, Model modelo, @RequestParam("idarbol") int idarbol) {
		sf.deleteById(idfoto);
		modelo.addAttribute("fotos", sf.findAllByArbol(sa.findById(idarbol).get()));
		modelo.addAttribute("arbol", sa.findById(idarbol).get());
		return "foto/mostrarfotos";
	}
	
	
	@RequestMapping("/formmodificar")
	public String modificar(@RequestParam("idfoto") int idfoto, Model modelo) {
		modelo.addAttribute("foto", sf.findById(idfoto).get());
		modelo.addAttribute("arboles", sa.findAll());
		return "foto/formmodificar";
	}

}
