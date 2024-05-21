package com.hanati.team1.parsers;

import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.BiConsumer;

@Component
@RequiredArgsConstructor
public class BaseParser {

    public <T> void parse(String csvName, JpaRepository<T, Long> repository, BiConsumer<CSVRecord,List<T>> consumer) throws IOException {
        String csvPath = "src/main/resources/data/";
        try (Reader reader = new FileReader(csvPath+csvName);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {
            List<T> list = new ArrayList<>();

            for (CSVRecord csvRecord : csvParser) consumer.accept(csvRecord,list);
            repository.saveAll(list);
        }
    }

    public LocalDateTime toLocalDateTime(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localdate = LocalDate.parse(date, formatter);
        return LocalDateTime.of(localdate, LocalDateTime.now().toLocalTime());
    }
}
