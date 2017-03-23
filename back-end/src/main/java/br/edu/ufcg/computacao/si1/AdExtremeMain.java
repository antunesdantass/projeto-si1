package br.edu.ufcg.computacao.si1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(value="br.edu.ufcg.computacao.si1.security")
public class AdExtremeMain {

	public static void main(String[] args) {
		SpringApplication.run(AdExtremeMain.class, args);
	}
}
