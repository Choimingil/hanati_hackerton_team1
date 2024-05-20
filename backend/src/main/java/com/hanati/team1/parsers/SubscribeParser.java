package com.hanati.team1.parsers;

import com.hanati.team1.src.customers.entities.Subscribe;
import com.hanati.team1.src.customers.repository.SubscribeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubscribeParser implements Parsable{
    private final BaseParser baseParser;
    private final SubscribeRepository subscribeRepository;

    @Override
    public void parse() throws Exception {
        baseParser.parse(subscribeRepository,
                (csvRecord, list) -> {
                    Subscribe subscribe = new Subscribe();
                    subscribe.setSubscribeId(Long.parseLong(csvRecord.get(0)));
                    subscribe.setUserId(Long.parseLong(csvRecord.get(1)));
                    subscribe.setPlayerId(Long.parseLong(csvRecord.get(2)));
                    subscribe.setSubscribeStatus(Integer.parseInt(csvRecord.get(3)));
                    subscribe.setSubscribeDate(baseParser.toLocalDateTime(csvRecord.get(4)));
                    list.add(subscribe);
                }
        );
    }
}
