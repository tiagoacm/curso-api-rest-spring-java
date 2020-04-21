package br.com.alura.forum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.dto.TokenDTO;
import br.com.alura.forum.form.LoginForm;
import br.com.alura.forum.security.ErroAutenticacaoDTO;
import br.com.alura.forum.security.TokenService;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<?> autenticar(@RequestBody @Valid LoginForm form){
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
		
		try {
			// Spring vai chamar AutenticacaoService
			Authentication authentication =  authManager.authenticate(dadosLogin); 
			//gerar token JWT
			String token = tokenService.gerarToken(authentication);
			return ResponseEntity.ok(new TokenDTO(token, "Bearer"));	
		} catch (AuthenticationException e) {
			return new ResponseEntity<>(new ErroAutenticacaoDTO("Email ou senha inválidos"), HttpStatus.BAD_REQUEST);
		}
		
		
	}

}
