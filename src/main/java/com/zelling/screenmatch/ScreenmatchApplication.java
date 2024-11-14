package com.zelling.screenmatch;

import com.zelling.screenmatch.model.DadosEpisodio;
import com.zelling.screenmatch.model.DadosSerie;
import com.zelling.screenmatch.model.DadosTemporada;
import com.zelling.screenmatch.service.ConsumoApi;
import com.zelling.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var api = new ConsumoApi();
		var conversor = new ConverteDados();
		// pega dados de uma serie
		var json = api.obterDados("http://www.omdbapi.com/?t=gilmore+girls&apikey=e4e7f21a");
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);

		// pega dados de um episodio
		json = api.obterDados("http://www.omdbapi.com/?t=gilmore+girls&Season=1&Episode=2&apikey=e4e7f21a");
		DadosEpisodio dadosEps = conversor.obterDados(json, DadosEpisodio.class);
		System.out.println(dadosEps);

		List<DadosTemporada> listaTemporadas = new ArrayList<>();

		// pega dados de todas temporadas
		for (int i = 1; i <= dados.totalTemporadas(); i++) {
			json = api.obterDados("http://www.omdbapi.com/?t=gilmore+girls&Season=" + i + "&apikey=e4e7f21a");
			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			listaTemporadas.add(dadosTemporada);
		}

		System.out.println(listaTemporadas);
	}
}
