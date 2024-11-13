package com.zelling.screenmatch;

import com.zelling.screenmatch.model.DadosEpisodio;
import com.zelling.screenmatch.model.DadosSerie;
import com.zelling.screenmatch.service.ConsumoApi;
import com.zelling.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var api = new ConsumoApi();
		var json = api.obterDados("http://www.omdbapi.com/?t=gilmore+girls&apikey=e4e7f21a");
		System.out.println(json);
		var conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
		json = api.obterDados("http://www.omdbapi.com/?t=gilmore+girls&Season=1&Episode=2&apikey=e4e7f21a");
		DadosEpisodio dadosEps = conversor.obterDados(json, DadosEpisodio.class);
		System.out.println(dadosEps);
	}
}
