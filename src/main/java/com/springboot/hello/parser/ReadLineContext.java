package com.springboot.hello.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadLineContext <T>{
    private Parser<T> parser;

    public ReadLineContext(Parser<T> parser) {
        this.parser = parser;
    }

    public List<T> readByLine(String filename) throws IOException {
        List<T> result = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String str;
        reader.readLine();
        while((str = reader.readLine() ) != null){
            try {
                result.add(parser.parse(str));
            }catch (Exception e){
                System.out.printf("파싱 중 문제 발생 파일내용 : %s\n",str.substring(0,50));
            }
        }
        reader.close();
        return result;
    }
}
