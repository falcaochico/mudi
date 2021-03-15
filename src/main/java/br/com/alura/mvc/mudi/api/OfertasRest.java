package br.com.alura.mvc.mudi.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mvc.mudi.dto.OfertaDTO;
import br.com.alura.mvc.mudi.dto.PedidoDTO;
import br.com.alura.mvc.mudi.model.Oferta;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {

	@Autowired
	PedidoRepository pedidoRepository;
	
	@PostMapping
	public Oferta criaOferta(OfertaDTO ofertaDto) {
		
		Optional<Pedido> pedidoCadastrado = pedidoRepository.findById(ofertaDto.getIdPedido());
		if(pedidoCadastrado.isEmpty()) {
			return null;
		}
		
		Pedido pedido = pedidoCadastrado.get();
		
		Oferta oferta = ofertaDto.toEntity();
		oferta.setPedido(pedido);
		pedido.getOfertas().add(oferta);
		pedidoRepository.save(pedido);
		
		return oferta;
	}
	
}
