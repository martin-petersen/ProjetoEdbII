package br.com.projeto.edb.entits.Testes;

import br.com.projeto.edb.entits.Compressor;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CompressorTest {

    @Test
    public void compressorTest() throws IOException {
        Compressor a = new Compressor(new String("/home/andrevms/Documents/Projeto-EDB-II/src/arquivos-de-teste/testes/teste1.txt"), "teste");
    }

}