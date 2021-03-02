package br.com.alura.mvc.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.alura.mvc.mudi.dto.PedidoDTO;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {

	@Autowired
	PedidoRepository pedidoRepository;
	
	@GetMapping("formulario")
	public ModelAndView formulario() {
		ModelAndView mv = new ModelAndView("pedido/formulario");
		return mv;
	}
	
	@PostMapping("novo")
	public String novo(@Valid PedidoDTO pedidoDto, BindingResult result) {
		
		if(result.hasErrors()) {
			return "pedido/formulario";
		}
		
		pedidoRepository.save(pedidoDto.toEntity());
		return "pedido/formulario";
	}
}
