package br.com.projeto.edb.entits.Testes;

import br.com.projeto.edb.entits.Application;
import br.com.projeto.edb.entits.Heap;
import org.junit.jupiter.api.Test;

import br.com.projeto.edb.entits.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {
/*
    @Test
    void compress() {
    }

    @Test
    void decode() {
    }

    @Test
    void CriaTree_Teste1() throws IOException {
        Application a = new Application();
        HashMap<Character, Integer> teste = new HashMap<Character, Integer> (a.lettersFrequency(new String("/home/andrevms/Documents/Projeto-EDB-II/src/arquivos-de-teste/testes/teste1.txt")));

        Heap t = new Heap();

        Iterator it = teste.entrySet().iterator();

        while(it.hasNext()){
            Map.Entry mapElement = (Map.Entry)it.next();
            t.insert(new Node(mapElement.getKey(), mapElement.getValue() ));
        }

        System.out.println(t);

    }

    @Test
    void teste1_lettersFrequency() throws IOException {

            Application a = new Application();
            System.out.println("Teste com lollapalooza");

            HashMap<Character, Integer> expectedTest1 = new HashMap<Character, Integer>();
            expectedTest1.put('p',1);
            expectedTest1.put('a',3);
            expectedTest1.put('l',4);
            expectedTest1.put('o',3);
            expectedTest1.put('z',1);
            expectedTest1.put('\n',1);

            HashMap<Character, Integer> teste = new HashMap<Character, Integer> (a.lettersFrequency("teste1.txt"));

            assertTrue( assertArrayEquals(expectedTest1, teste) );
    }

    @Test
    void teste2_lettersFrequency() throws IOException {
        Application a = new Application();
        System.out.println("Teste com \"O rato roeu a roupa do rei de roma\\n\"");

        HashMap<Character, Integer> expectedTest2 = new HashMap<Character, Integer>();
        expectedTest2.put('O',1);
        expectedTest2.put(' ',8);
        expectedTest2.put('r',5);
        expectedTest2.put('a',4);
        expectedTest2.put('t',1);
        expectedTest2.put('o',5);
        expectedTest2.put('e',3);
        expectedTest2.put('u',2);
        expectedTest2.put('p',1);
        expectedTest2.put('d',2);
        expectedTest2.put('m',1);
        expectedTest2.put('\n',1);
        expectedTest2.put('i',1);

        HashMap<Character, Integer> teste = new HashMap<Character, Integer> (a.lettersFrequency("teste2.txt"));

        assertTrue( assertArrayEquals(expectedTest2, teste) );
    }

    @Test
    void teste4_lettersFrequency() throws IOException {
        Application a = new Application();
        System.out.println("Teste com \"\"");

        HashMap<Character, Integer> expectedTest4 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> teste = new HashMap<Character, Integer> (a.lettersFrequency("teste4.txt"));

        assertTrue( assertArrayEquals(expectedTest4, teste) );
    }

    @Test
    void teste8_lettersFrequency() throws  IOException {
        Application a = new Application();
        System.out.println("Teste com 10 \\n");

        HashMap<Character, Integer> expectedTest8 = new HashMap<Character, Integer>();
        expectedTest8.put('\n',10);

        HashMap<Character, Integer> teste = new HashMap<Character, Integer> (a.lettersFrequency("teste8.txt"));

        assertTrue( assertArrayEquals(expectedTest8, teste) );
    }

    private boolean assertArrayEquals(HashMap<Character, Integer> expectedTest1, HashMap<Character, Integer> teste) {
        return expectedTest1.equals(teste);
    }

 */
}
