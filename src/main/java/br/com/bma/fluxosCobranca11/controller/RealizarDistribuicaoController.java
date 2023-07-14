package br.com.bma.fluxosCobranca11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bma.fluxosCobranca11.model.dto.RealizarDistribuicaoDTO;
import br.com.bma.fluxosCobranca11.service.RealizarDistribuicaoService;
import net.java.dev.jaxb.array.StringArrayArray;

@RestController
@RequestMapping("/realizardistribuicao")
public class RealizarDistribuicaoController {
	
	@Autowired
	private RealizarDistribuicaoService realizarDistribuicaoService;
	
	@PutMapping("/{id}")
	public ResponseEntity<?> realizarDistribuicao(@PathVariable("id") Integer id){
		try {
			
			RealizarDistribuicaoDTO dto = realizarDistribuicaoService.findByIdFluig(id);
			//return ResponseEntity.ok().body(dto);
			if(dto != null){
				StringArrayArray atualizado = realizarDistribuicaoService.inserirNovaDistribuicao(dto);
				return ResponseEntity.ok().body(atualizado);
			}
			return ResponseEntity.notFound().build();
			
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping
	public String teste(){
		String a = "Teste atualizado em (versão gerada em 23/09/2022 às 16:45)";
		
		return a;
	}
	
	@PostMapping
	public String teste2(){
		String a = "Teste atualizado em (versão gerada em 23/09/2022 às 16:45)";
		
		return a;
	}
	
	@PutMapping
	public String teste3(){
		String a = "Teste atualizado em (versão gerada em 23/09/2022 às 16:45)";
		
		return a;
	}

}
