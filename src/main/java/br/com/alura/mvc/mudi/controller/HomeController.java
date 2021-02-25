package br.com.alura.mvc.mudi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.mvc.mudi.model.Pedido;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String home(Model model) {
		
		Pedido pedido = new Pedido();
		pedido.setNomeProduto("Iphone 11 Apple Preto, 128gb");
		pedido.setUrlProduto("pf_rd_m=A3RN7G7QC5MWSZ&pf_rd_p=da40754c-44c1-4214-8e5f-e03480961ec2&pf_rd_r=9ADTTJAR8RRD9JKN77Q3&pf_rd_s=merchandised-search-6&pf_rd_t=101&qid=1614257395&refinements=p_4%3AAPPLE%7CApple%7CiPhone%7CiPhone+7+4.7\"%7CiPhone+7+Plus&s=wireless&sr=1-20");
		pedido.setUrlImagem("https://images-na.ssl-images-amazon.com/images/I/41u6SlsJvLL._AC_.jpg");
		pedido.setDescricao("Uma descrição qualquer para esse pedido.");
		
		List<Pedido> pedidos = Arrays.asList(pedido);
		model.addAttribute("pedidos", pedidos);
		
		return "home";
	}
	
}
