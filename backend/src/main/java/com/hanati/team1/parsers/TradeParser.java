package com.hanati.team1.parsers;

import com.hanati.team1.src.customers.entities.Trade;
import com.hanati.team1.src.customers.repository.TradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class TradeParser implements Parsable{
    private final BaseParser baseParser;
    private final TradeRepository tradeRepository;

    @Override
    public void parse() throws Exception {
        System.out.println("pass : " + baseParser.toLocalDateTime("2020-03-08").getClass().toString());
        baseParser.parse(
                "Trade.csv",
                tradeRepository,
                (csvRecord, list) -> {
                    Trade trade = new Trade();
                    trade.setTradeId(Long.parseLong(csvRecord.get(0)));
                    trade.setUserId(Long.parseLong(csvRecord.get(1)));
                    trade.setPlayerId(Long.parseLong(csvRecord.get(2)));
                    trade.setTokenPrice(Long.parseLong(csvRecord.get(3)));
                    trade.setTokenNum(Integer.parseInt(csvRecord.get(4)));
//                    trade.setTradeDate(baseParser.toLocalDateTime(csvRecord.get(5)));
                    trade.setTradeDate(LocalDateTime.now());
                    list.add(trade);
                }
        );
    }
}
