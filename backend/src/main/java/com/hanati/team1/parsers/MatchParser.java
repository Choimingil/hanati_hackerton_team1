package com.hanati.team1.parsers;

import com.hanati.team1.parsers.BaseParser;
import com.hanati.team1.parsers.Parsable;
import com.hanati.team1.src.matches.entities.Match;
import com.hanati.team1.src.matches.repositories.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MatchParser implements Parsable {
    private final BaseParser baseParser;
    private final MatchRepository matchRepository;

    @Override
    public void parse() throws Exception {
        baseParser.parse(matchRepository,
                (csvRecord, list) -> {
                    Match match = new Match();
                    match.setMatchId(Long.parseLong(csvRecord.get(0)));
                    match.setPlayerId(Long.parseLong(csvRecord.get(1)));
                    match.setMatchDate(baseParser.toLocalDateTime(csvRecord.get(2)));
                    match.setPlayerStatus(Integer.parseInt(csvRecord.get(3)));
                    match.setPlayerPlaytime(Integer.parseInt(csvRecord.get(4)));
                    match.setPlayerScore(Double.parseDouble(csvRecord.get(5)));
                    match.setPlayerYcardNum(Integer.parseInt(csvRecord.get(6)));
                    list.add(match);
                }
        );
    }
}
