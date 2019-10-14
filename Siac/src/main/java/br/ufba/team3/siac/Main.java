package br.ufba.team3.siac;

import br.ufba.team3.siac.model.*;
import java.io.FileNotFoundException;

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
