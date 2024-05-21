package com.hanati.team1.parsers;

import com.hanati.team1.src.players.entities.Player;
import com.hanati.team1.src.players.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlayerParser implements Parsable{
    private final BaseParser baseParser;
    private final PlayerRepository playerRepository;

    @Override
    public void parse() throws Exception {
        baseParser.parse(
                "Player.csv",
                playerRepository,
                (csvRecord, list) -> {
                    Player player = new Player();
                    player.setPlayerId(Long.parseLong(csvRecord.get(0)));
                    player.setPlayerName(csvRecord.get(1));
                    player.setPlayerNation(csvRecord.get(2));
                    player.setPlayerBirth(baseParser.toLocalDateTime(csvRecord.get(3)));
                    player.setPlayerHeight(Integer.parseInt(csvRecord.get(4)));
                    player.setPlayerWeight(Integer.parseInt(csvRecord.get(5)));
                    player.setPlayerProfile(csvRecord.get(6));
                    player.setPlayerYouth(csvRecord.get(7));
                    player.setPlayerStatus(Integer.parseInt(csvRecord.get(8)));

                    String playerVision = csvRecord.get(9);
                    if(!playerVision.equals("null")) player.setPlayerVision(playerVision);

                    String playerEffort = csvRecord.get(10);
                    if(!playerEffort.equals("null")) player.setPlayerEffort(playerEffort);

                    String playerAdvantage = csvRecord.get(11);
                    if(!playerAdvantage.equals("null")) player.setPlayerAdvantage(playerAdvantage);

                    String playerVideo = csvRecord.get(12);
                    if(!playerVideo.equals("null")) player.setPlayerVideo(playerVideo);

                    list.add(player);
                }
        );
    }
}
