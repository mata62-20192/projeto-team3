package br.ufba.team3.siac;

import br.ufba.team3.siac.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
       Universidade universidade = new Universidade();
       try{
           LeDados dados = new LeDados();
           dados.Leitura(universidade);
       } catch (Exception e) {
           e.printStackTrace();
       }
        System.out.println(universidade);
    }
}
