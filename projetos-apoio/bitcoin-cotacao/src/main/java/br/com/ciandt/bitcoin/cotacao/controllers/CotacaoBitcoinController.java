package br.com.ciandt.bitcoin.cotacao.controllers;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cotacao/")
public class CotacaoBitcoinController {
	
	@GetMapping("/bitcoin/{moeda}")
	public ResponseEntity<BigDecimal> getCotacao(@PathVariable String moeda){
		return ResponseEntity.ok(new BigDecimal(14221.61).setScale(2, RoundingMode.UP));
	}

}
