package services;

import pet.Pet;
import pet.PetAddress;
import pet.PetGender;
import pet.PetType;

import javax.swing.text.DateFormatter;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PetStorage {
    public void salvarPet(Pet pet01 , PetAddress adress){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
        String timestamp = localDateTime.format(dtf);
        String nomeFileFormatado = pet01.getNomeCompleto().toUpperCase().replaceAll("\\s+","");
        String nomeCompletoFile = timestamp+"-"+nomeFileFormatado+".txt";
        File fileFinal = new File(System.getProperty("user.dir") + "/src/petsCadastrados", nomeCompletoFile);

        try(FileWriter fw = new FileWriter(fileFinal);
            BufferedWriter bw = new BufferedWriter(fw)){
            bw.write(pet01.getNomeCompleto());
            bw.newLine();
            bw.write(pet01.getPetType().toString());
            bw.newLine();
            bw.write(pet01.getPetGender().toString());
            bw.newLine();
            bw.write(adress.getRua() +", "+ adress.getNumeroCasa()+", "+adress.getCidade());
            bw.newLine();
            bw.write(pet01.getIdade());
            bw.newLine();
            bw.write(pet01.getPeso());
            bw.newLine();
            bw.write(pet01.getRaca());
            bw.newLine();

            System.out.println("Pet salvo no arquivo "+fileFinal);
        } catch (IOException e){
            throw new RuntimeException("Erro ao salvar pet no arquivo."+ e);
        }
    }

    public List<Pet> carregarTodosOsPets(){
        List<Pet> petsEncontrados = new ArrayList<>();
        File diretorio = new File(System.getProperty("user.dir") + "/src/petsCadastrados");
        if (!diretorio.exists() || !diretorio.isDirectory()) {
            System.out.println("Ainda não há pets cadastrados (diretório não encontrado).");
            return petsEncontrados;
        }

        File[] arquivosDosPets = diretorio.listFiles();
        if (arquivosDosPets == null){
            return petsEncontrados;
        }
        for (File arquivo : arquivosDosPets) {
            try(BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
                Pet pet01 = new Pet();
                PetAddress adress01 = new PetAddress();

                pet01.setNomeCompleto(br.readLine());
                pet01.setPetType(PetType.fromString(br.readLine()));
                pet01.setPetGender(PetGender.fromChar(br.readLine().charAt(0)));
                String linhaEndereco = br.readLine();
                if (linhaEndereco != null && !linhaEndereco.equalsIgnoreCase("NAO INFORMADO")){
                    String[] enderecoSeparado = linhaEndereco.split(",\\s*");
                    if(enderecoSeparado.length == 3){
                        adress01.setRua(enderecoSeparado[0].trim());
                        adress01.setNumeroCasa(enderecoSeparado[1].trim());
                        adress01.setCidade(enderecoSeparado[2].trim());
                    }
                }
                pet01.setEndereco(adress01);
                pet01.setIdade(br.readLine());
                pet01.setPeso(br.readLine());
                pet01.setRaca(br.readLine());

                pet01.setFileName(arquivo.getName());

                petsEncontrados.add(pet01);
                br.readLine();
            }catch (Exception e){
                System.out.println("Ocorreu um erro ao ler o arquivo.");
                e.printStackTrace();
            }
        }
        return petsEncontrados;
    }

    public void atualizarPet (Pet petAtualizado) throws IOException{
        String nomeAntigoDoArquivo = petAtualizado.getFileName();
        if(nomeAntigoDoArquivo == null || nomeAntigoDoArquivo.isEmpty()){
            throw new IOException("Não há arquivos para esse Pet");
        }
        File arquivoAntigo = new File(System.getProperty("user.dir") + "/src/petsCadastrados", nomeAntigoDoArquivo);
        if (arquivoAntigo.exists()){
            if (!arquivoAntigo.delete()){
                throw new IOException("Não foi possível atualizar. Não consegui deletar o arquivo antigo.");
            }
        }
        try{
            salvarPet(petAtualizado, petAtualizado.getEndereco());
        }catch (Exception e){
            throw new IOException("Falha ao salvar novo arquivo após atualização.", e);
        }
    }

    public void deletarPet(Pet petParaDeletar) throws IOException{
        String nomeArquivo = petParaDeletar.getFileName();
         if(nomeArquivo == null || nomeArquivo.isEmpty()){
             throw new IOException("Não há arquivos para esse pet.");
         }
        File arquivo = new File(System.getProperty("user.dir") + "/src/petsCadastrados", nomeArquivo);
         if(arquivo.exists()){
             if(!arquivo.delete()){
                 throw new IOException("Não foi possível deletar "+petParaDeletar.getNomeCompleto());
             }
         }
    }
}

