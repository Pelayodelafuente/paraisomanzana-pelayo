package com.dawes.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.ArbolVO;
import com.dawes.servicios.ServicioArbol;
import com.dawes.servicios.ServicioFinca;
import com.dawes.servicios.ServicioFoto;
import com.dawes.servicios.ServicioReposicion;
import com.dawes.servicios.ServicioTratamiento;
import com.dawes.servicios.ServicioVariedad;

@Controller
@RequestMapping("/arboles")
public class controladorArbol {
	
	@Autowired
	ServicioArbol sa;
	
	@Autowired
	ServicioFinca sf;
	
	@Autowired
	ServicioVariedad sv;
	
	@Autowired
	ServicioTratamiento st;
	
	@Autowired
	ServicioFoto sft;
	
	@Autowired
	ServicioReposicion sr;
	
	
	@RequestMapping("/mostrararboles")
	public String mostrar(Model modelo) {
		modelo.addAttribute("arboles", sa.findAll());
		return "arbol/mostrararboles";
	}
	
	
	@RequestMapping("forminsertar")
	public String forminsertar(@RequestParam("idfinca") int idfinca, Model modelo) {
		ArbolVO arbol = new ArbolVO();
		arbol.setFinca(sf.findById(idfinca).get());
		modelo.addAttribute("arbol", arbol);
		modelo.addAttribute("fincas", sf.findAll());
		modelo.addAttribute("variedades", sv.findAll());
		return "arbol/forminsertar";
	}
	
	
	@RequestMapping("/insertar")
	public String insertar(@ModelAttribute ArbolVO arbol, Model modelo) {
		sa.save(arbol);
		modelo.addAttribute("finca", sf.findById(arbol.getFinca().getIdfinca()).get());
		modelo.addAttribute("arboles", sa.findAllByFinca(sf.findById(arbol.getFinca().getIdfinca()).get()));
		return "arbol/mostrararboles";
	}
	
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("idarbol") int idarbol, @RequestParam("idfinca") int idfinca, Model modelo) {
		sa.deleteById(idarbol);
		modelo.addAttribute("arboles", sa.findAllByFinca(sf.findById(idfinca).get()));
		modelo.addAttribute("finca", sf.findById(idfinca).get());
		return "arbol/mostrararboles";
	}
	
	
	@RequestMapping("/formmodificar")
	public String formmodificar(@RequestParam("idarbol") int idarbol, Model modelo) {
		modelo.addAttribute("arbol", sa.findById(idarbol).get());
		modelo.addAttribute("fincas", sf.findAll());
		modelo.addAttribute("variedades", sv.findAll());
		return "arbol/formmodificar";
	}
	
	
	@RequestMapping("/tratamientosarbol")
	public String arboltratamientos(@RequestParam("idarbol") int idarbol, Model modelo) {
		modelo.addAttribute("arbol", sa.findById(idarbol).get());
		modelo.addAttribute("tratamientos", st.findAllByArbol(sa.findById(idarbol).get()));
		return "tratamiento/mostrararboltratamientos";
	}
	
	
	@RequestMapping("/reposicionesarbol")
	public String arbolreposiciones(@RequestParam("idarbol") int idarbol, Model modelo) {
		modelo.addAttribute("arbol", sa.findById(idarbol).get());
		modelo.addAttribute("reposiciones", sr.findAllByArbol(sa.findById(idarbol).get()));
		return "reposicion/mostrarreposiciones";
	}
	
	
	@RequestMapping("/fotosarbol")
	public String arbolfotos(@RequestParam("idarbol") int idarbol, Model modelo) {
		modelo.addAttribute("arbol", sa.findById(idarbol).get());
		modelo.addAttribute("fotos", sft.findAllByArbol(sa.findById(idarbol).get()));
		return "foto/mostrarfotos";
	}
	
	@RequestMapping("/planoforminsertar")
	public String planoforminsertar(@RequestParam("filax") int fila,@RequestParam("columnax")int columna, @RequestParam("idfincax") int idfinca, Model modelo) {
		ArbolVO a=new ArbolVO();
		a.setFila(fila);
		a.setColumna(columna);
		a.setFinca(sf.findById(idfinca).get());
		modelo.addAttribute("arbol", a);
		modelo.addAttribute("fincas", sf.findAll());
		modelo.addAttribute("variedades", sv.findAll());
		return "arbol/formmodificar";
	}

}
