package br.com.projeto.edb.entits;

import java.io.*;
import java.util.*;

public class Extrator {
    private String code;
    private String mensagem;
    private HashMap<String,Character> map;

    public Extrator (String fileTxT, String fileEDZ, String fileEDT) throws IOException {
        readTableFile(fileEDT);
        convertMail(readFileToByteArray(fileEDZ));
        decode(getCode(), getMap());
        generateTXT(fileTxT);

    }

    public String getCode() {
        return code;
    }

    public HashMap<String, Character> getMap() {
        return map;
    }

    public String getMensagem() {
        return mensagem;
    }

    private void generateTXT(String fileTXT) throws IOException {
        FileOutputStream fileOutEDT = new FileOutputStream(fileTXT);
        for (int i = 0; i < getMensagem().length(); ++i){
            fileOutEDT.write(getMensagem().charAt(i));
        }
        fileOutEDT.close();
    }

    private void readTableFile (String fileEDT) throws IOException {
        FileReader rdr = new FileReader(fileEDT);
        BufferedReader brdr = new BufferedReader(rdr);

        ArrayList<String> str = new ArrayList<>();
        HashMap<String, Character> mapa = new HashMap<>();

        StringBuffer st = new StringBuffer();
        st.append((char)brdr.read());

        while()

        while((st = brdr.readLine()) != null) {
            str.add(st);
        }

        for(int i = 0; i<str.size(); ++i) {
            StringBuffer sb = new StringBuffer();
            for(int j = 1; j<str.get(i).length(); ++j) {
                sb.append(str.get(i).charAt(j));
            }
            System.out.println("Tabela: " + sb + " -> " + str.get(i).charAt(0));
            mapa.put(sb.toString(), str.get(i).charAt(0));
        }
        this.map = mapa;
    }

    private void decode(String code, HashMap<String,Character> codeMap) {
        StringBuffer sb = new StringBuffer();
        StringBuffer mensagem = new StringBuffer();
        for(int i=0; i<code.length(); ++i) {
            sb.append(code.charAt(i));
            if(codeMap.containsKey(sb.toString()) && codeMap.get(sb.toString()) != (char)3) {
                mensagem.append(codeMap.get(sb.toString()));
                sb.setLength(0);
            }
        }
        this.mensagem = mensagem.toString();
    }

    private byte[] readFileToByteArray (String fileEDZ){
        File file = new File(fileEDZ);
        FileInputStream fis = null;
        byte[] bArray = new byte[(int) file.length()];
        try{
            fis = new FileInputStream(file);
            fis.read(bArray);
            fis.close();

        }catch(IOException ioExp){
            ioExp.printStackTrace();
        }

        return bArray;
    }

    private void convertMail (byte[] bytes) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < bytes.length; i++) {
            str.append(new StringBuilder(String.format("%8s", Integer.toBinaryString(bytes[i] & 0xFF)).replace(" ", "0")).reverse());
        }
        this.code = str.toString();
    }
}
