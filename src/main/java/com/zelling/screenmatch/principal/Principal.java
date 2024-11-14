package com.zelling.screenmatch.principal;

import java.util.Scanner;

public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private final String ENDERECO = "http://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=e4e7f21a";

    public void exibeMenu(){
        System.out.println("Digite a série para busca");
        String nomeSerie = scanner.nextLine();
    }
}
