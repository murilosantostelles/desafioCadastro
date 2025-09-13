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
    public BufferedReader abrirLeitor() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/formulario.txt");
        if (inputStream == null) {
            throw new IOException("Arquivo 'formulario.txt' não encontrado nos resources.");
        }
        return new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
    }

    public BufferedReader lerFormulario2(){
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
        return null;
    }
}

