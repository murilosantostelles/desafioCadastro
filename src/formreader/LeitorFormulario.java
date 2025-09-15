package formreader;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class LeitorFormulario {
    Scanner leitor = new Scanner(System.in);
    public void lerFormulario(){
        File file = new File("src/resources/formulario.txt");
        try(FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr)){
            String linha;
            while((linha = br.readLine()) != null){
                System.out.println(linha);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public String[] lerPerguntaForm (int contador) {
        File file = new File("src/resources/formulario.txt");
        String[] perguntas = null;
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            String linha;
            perguntas = new String[13];
            contador = 0;
            while ((linha = br.readLine()) != null) {
                perguntas[contador] = linha;
                contador++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return perguntas;
    }
}

