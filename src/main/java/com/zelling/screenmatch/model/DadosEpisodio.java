package com.zelling.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodio(@JsonAlias("Title") String titulo,
                            @JsonAlias("Episode") int numero,
                            @JsonAlias("Released") String avaliacao,
                            @JsonAlias("imdbRating") String dataDeLancamento) {
}
