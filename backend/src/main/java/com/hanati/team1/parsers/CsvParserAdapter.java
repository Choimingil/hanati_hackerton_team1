package com.hanati.team1.parsers;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class CsvParserAdapter implements CommandLineRunner {
    private final UserParser userParser;
    private final TradeParser tradeParser;
    private final SubscribeParser subscribeParser;
    
    private final MatchParser matchParser;
    private final FieldPlayerRecordParser fieldPlayerRecordParser;
    private final GoalKeeperRecordParser goalKeeperRecordParser;
    
    private final PlayerParser playerParser;
    private final PositionParser positionParser;
    private final TeamParser teamParser;
    private final TeamByPlayerParser teamByPlayerParser;
    
    @Override
    @Transactional
    public void run(String... args) throws Exception {
//        userParser.parse();
//        tradeParser.parse();
//        subscribeParser.parse();
//
//        matchParser.parse();
//        fieldPlayerRecordParser.parse();
//        goalKeeperRecordParser.parse();
//
//        playerParser.parse();
//        positionParser.parse();
//        teamParser.parse();
//        teamByPlayerParser.parse();
    }
}
