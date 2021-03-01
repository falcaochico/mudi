package br.com.alura.mvc.mudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.dto.PedidoDTO;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {

	@Autowired
	PedidoRepository pedidoRepository;
	
	@GetMapping("formulario")
	public String formulario() {
		return "pedido/formulario";
	}
	
	@PostMapping("novo")
	public String novo(PedidoDTO pedidoDto) {
		pedidoRepository.save(pedidoDto.toEntity());
		return "pedido/formulario";
	}
}
