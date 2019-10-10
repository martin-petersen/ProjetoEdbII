package br.com.projeto.edb.entits;

import java.io.*;
import java.util.HashMap;

public class Application implements CodeHuffman {
   // private BinaryTree tree;

    public Application() {
        //tree = new BinaryTree();
    }

    @Override
    public void compress() {

    }

    @Override
    public void decode() {

    }

    @Override
    public HashMap<Character, Integer> lettersFrequency(String fileName) throws IOException{
        HashMap<Character, Integer> charFrequency = new HashMap<Character, Integer>();

        FileReader rdr = new FileReader("src/arquivos-de-teste/testes/"+ fileName);
        BufferedReader brdr = new BufferedReader(rdr);
        int content = brdr.read();

        while (content != -1) {
            Character key = (char) content;

            charFrequency.computeIfPresent(key, (Character character, Integer frequency) -> ++frequency);
            charFrequency.computeIfAbsent(key, k -> 1);

            content = brdr.read();
        }

        return charFrequency;
    }
}
