package br.com.alura.mvc.mudi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.alura.mvc.mudi.model.Oferta;

public class OfertaDTO {

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private Long idPedido;
	@NotNull
	@Pattern(regexp = "^\\d+(\\.\\d+{2})?$")
	private String valor;
	@NotNull
	@Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
	private String dataDeEntrega;
	private String comentario;
	
	public Long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getDataDeEntrega() {
		return dataDeEntrega;
	}
	public void setDataDeEntrega(String dataDeEntrega) {
		this.dataDeEntrega = dataDeEntrega;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public Oferta toEntity() {
		Oferta oferta = new Oferta();
		oferta.setComentario(this.comentario);
		oferta.setDataDeEntrega(LocalDate.parse(this.dataDeEntrega, formatter));
		oferta.setValor(new BigDecimal(this.valor));
		return oferta;
	}
}
