package br.com.bma.fluxosCobranca11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bma.fluxosCobranca11.model.dto.EmitirFaturaDTO;
import br.com.bma.fluxosCobranca11.model.form.EmitirFaturaForm;
import br.com.bma.fluxosCobranca11.service.EmitirFaturaService;
import net.java.dev.jaxb.array.StringArrayArray;

@RestController
@RequestMapping("/emitirfatura")
public class EmitirFaturaController {
	
	@Autowired
	private EmitirFaturaService emitirFaturaService;
	
	@PutMapping("/{id}")
	public ResponseEntity<?> emitirFatura(@PathVariable("id") Integer id){
		
		try {		
			
			EmitirFaturaDTO dto = emitirFaturaService.findByIdFluig(id);
			//return ResponseEntity.ok().body(dto);
			if(dto != null){				
				StringArrayArray atualizado = emitirFaturaService.inserirNovaFatura(dto);
				return ResponseEntity.ok().body(atualizado);
			}
			return ResponseEntity.notFound().build();
			
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findByIdFluig(@PathVariable("id") Integer id){
		 
		EmitirFaturaDTO dto = emitirFaturaService.findByIdFluig(id);
		return ResponseEntity.ok(dto);
	}
	
	@PutMapping("/atualizarFatura/{id}")
	public ResponseEntity<?> atualizarFatura(@PathVariable("id") Integer id,
											 @RequestBody EmitirFaturaForm emitirFatura){		
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Task enviada para o outro sistema");
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
