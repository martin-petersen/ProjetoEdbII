package br.com.projeto.edb.entits;

import java.io.*;
import java.util.*;

public class Compressor {

    public Compressor (String fileNameIn, String fileNameOut) throws IOException {

        HashMap<Character, Integer> hashmap = new HashMap<> (this.lettersFrequency(fileNameIn));
        Heap heap = new Heap();

        heap.insert(hashmap);

        Node root = heap.createBinaryTree();
        HashMap<Character, String> codeMap = gerateCode(root);
        String encrypted = generateEnchantedMail(fileNameIn, codeMap);
        System.out.println(encrypted);

    }

    private String generateEnchantedMail(String fileNameIn, HashMap<Character, String> codeMap) throws IOException {

        FileReader rdr = new FileReader(fileNameIn);
        BufferedReader brdr = new BufferedReader(rdr);
        int contentIn = brdr.read();

        StringBuffer contenteEncriptedOut = new StringBuffer();

        while (contentIn != -1) {
            Character key = (char) contentIn;
            contenteEncriptedOut.append(codeMap.get(key));
            contentIn = brdr.read();
        }

        rdr.close();
        brdr.close();

        return contenteEncriptedOut.toString();


    }

    private HashMap<Character, Integer> lettersFrequency(String fileName) throws IOException {
        HashMap<Character, Integer> charFrequency = new HashMap<>();

        FileReader rdr = new FileReader(fileName);
        BufferedReader brdr = new BufferedReader(rdr);
        int content = brdr.read();

        while (content != -1) {
            Character key = (char) content;

            charFrequency.computeIfPresent(key, (Character character, Integer frequency) -> ++frequency);
            charFrequency.putIfAbsent(key, 1);

            content = brdr.read();
        }

        rdr.close();
        brdr.close();

        return charFrequency;
    }

    private HashMap<Character, String> gerateCode (Node root){
        HashMap<Character, String> codeMap = new HashMap<>();
        String byteCode = new String();
        gerateNodeNumbers(codeMap, root, byteCode);
        return codeMap;
    }

    private void gerateNodeNumbers(HashMap<Character, String> codeMap , Node root, String byteCode){

        if (root.getLetter() != null) {
            codeMap.put(root.getLetter(), byteCode);
        }

        if (root.getLeft() != null) {
            String byteCodAux = byteCode + '0';
            gerateNodeNumbers(codeMap, root.getLeft(), byteCodAux);
        }

        if (root.getRight() != null) {
            String byteCodAux = byteCode + '1';
            gerateNodeNumbers(codeMap, root.getRight(), byteCodAux);
        }
    }

    private void generateNodeNumbersInBitCode(HashMap<Character, BitSet> codeMap , Node root, BitSet byteCode, int index){

        if (root.getLetter() != null) {
            codeMap.put(root.getLetter(), byteCode);
        }

        if (root.getLeft() != null) {
            BitSet byteCodAux = (BitSet) byteCode.clone();
            generateNodeNumbersInBitCode(codeMap, root.getLeft(), byteCodAux, ++index);
        }

        if (root.getRight() != null) {
            BitSet byteCodAux = (BitSet) byteCode.clone();
            byteCodAux.set(index);
            generateNodeNumbersInBitCode(codeMap, root.getRight(), byteCodAux, ++index);
        }
    }


}
