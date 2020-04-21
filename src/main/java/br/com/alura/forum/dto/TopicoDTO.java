package br.com.alura.forum.dto;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import br.com.alura.forum.model.Topico;

public class TopicoDTO {

	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	
	public TopicoDTO(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
	}
	
	
	public Long getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	//METODO USADO ANTES DE IMPLEMENTAR A PAGINACAO
//	public static List<TopicoDTO> converter(List<Topico> topicos) {
//		return topicos.stream().map(TopicoDTO::new).collect(Collectors.toList());
//	}
	
	//METODO CRIADO PARA TRATAR TIPO PAGE USANDO PAGINACAO
	public static Page<TopicoDTO> converter(Page<Topico> topicos) {
		return topicos.map(TopicoDTO::new);
	}
	
	
	
	
	
	
	
}
