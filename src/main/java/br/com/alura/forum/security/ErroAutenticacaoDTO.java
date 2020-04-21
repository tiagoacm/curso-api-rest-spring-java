package br.com.alura.forum.security;

public class ErroAutenticacaoDTO {
	
	private String mensagem;
	
	public ErroAutenticacaoDTO(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	
}
