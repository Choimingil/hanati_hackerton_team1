package com.hanati.team1.parsers;

import com.hanati.team1.src.matches.entities.GoalKeeperRecord;
import com.hanati.team1.src.matches.repositories.GoalKeeperRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GoalKeeperRecordParser implements Parsable {
    private final BaseParser baseParser;
    private final GoalKeeperRecordRepository goalKeeperRecordRepository;

    @Override
    public void parse() throws Exception {
        baseParser.parse(goalKeeperRecordRepository,
                (csvRecord, list) -> {
                    GoalKeeperRecord record = new GoalKeeperRecord();
                    record.setRecordId(Long.parseLong(csvRecord.get(0)));
                    record.setMatchId(Long.parseLong(csvRecord.get(1)));
                    record.setConcededNum(Integer.parseInt(csvRecord.get(2)));
                    record.setSaveNum(Integer.parseInt(csvRecord.get(3)));
                    list.add(record);
                }
        );
    }
}
