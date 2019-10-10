package br.com.projeto.edb.entits;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public interface CodeHuffman {

    public void compress();
    public void decode();
    public HashMap<Character, Integer> lettersFrequency(String fileName) throws IOException;

}
