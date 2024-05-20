package com.hanati.team1.parsers;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class CsvParserAdapter implements CommandLineRunner {
    private final String path = "src/main/resources/";




    @Override
    @Transactional
    public void run(String... args) throws Exception {

    }
}
