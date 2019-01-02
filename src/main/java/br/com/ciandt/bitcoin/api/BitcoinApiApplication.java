package br.com.ciandt.bitcoin.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BitcoinApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BitcoinApiApplication.class, args);
		System.out.println("Projeto Bitcoin");
	}

}

