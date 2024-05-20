package com.hanati.team1.parsers;

import com.hanati.team1.src.matches.entities.FieldPlayerRecord;
import com.hanati.team1.src.matches.repositories.FieldPlayerRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FieldPlayerRecordParser implements Parsable {
    private final BaseParser baseParser;
    private final FieldPlayerRecordRepository fieldPlayerRecordRepository;

    @Override
    public void parse() throws Exception {
        baseParser.parse(fieldPlayerRecordRepository,
                (csvRecord, list) -> {
                    FieldPlayerRecord record = new FieldPlayerRecord();
                    record.setRecordId(Long.parseLong(csvRecord.get(0)));
                    record.setMatchId(Long.parseLong(csvRecord.get(1)));
                    record.setGoalNum(Integer.parseInt(csvRecord.get(2)));
                    record.setShootNum(Integer.parseInt(csvRecord.get(3)));
                    record.setEffectiveShootNum(Integer.parseInt(csvRecord.get(4)));

                    record.setAssistNum(Integer.parseInt(csvRecord.get(5)));
                    record.setChanceCreateNum(Integer.parseInt(csvRecord.get(6)));
                    record.setPassWinNum(Integer.parseInt(csvRecord.get(7)));
                    record.setPassLossNum(Integer.parseInt(csvRecord.get(8)));

                    record.setTackleWinNum(Integer.parseInt(csvRecord.get(9)));
                    record.setTackleLossNum(Integer.parseInt(csvRecord.get(10)));
                    record.setHeaderWinNum(Integer.parseInt(csvRecord.get(11)));
                    record.setHeaderLossNum(Integer.parseInt(csvRecord.get(12)));

                    list.add(record);
                }
        );
    }
}
