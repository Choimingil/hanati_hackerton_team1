package com.hanati.team1.parsers;

import com.hanati.team1.src.players.entities.Position;
import com.hanati.team1.src.players.repository.PositionRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PositionParser implements Parsable{
    private final BaseParser baseParser;
    private final PositionRepository positionRepository;

    @Override
    public void parse() throws Exception {
        baseParser.parse(
                "Position.csv",
                positionRepository,
                (csvRecord, list) -> {
                    Position position = new Position();
                    position.setPositionId(Long.parseLong(csvRecord.get(0)));
                    position.setPlayerId(Long.parseLong(csvRecord.get(1)));
                    position.setPositionName(csvRecord.get(2));
                    position.setPositionLevel(Integer.parseInt(csvRecord.get(3)));
                    list.add(position);
                }
        );
    }
}
