package com.hanati.team1.parsers;

import com.hanati.team1.src.players.entities.TeamByPlayer;
import com.hanati.team1.src.players.repository.TeamByPlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeamByPlayerParser implements Parsable{
    private final BaseParser baseParser;
    private final TeamByPlayerRepository teamByPlayerRepository;

    @Override
    public void parse() throws Exception {
        baseParser.parse(
                "TeamByPlayer.csv",
                teamByPlayerRepository,
                (csvRecord, list) -> {
                    TeamByPlayer teamByPlayer = new TeamByPlayer();
                    teamByPlayer.setTbpId(Long.parseLong(csvRecord.get(0)));
                    teamByPlayer.setPlayerId(Long.parseLong(csvRecord.get(1)));
                    teamByPlayer.setTeamId(Long.parseLong(csvRecord.get(2)));
                    teamByPlayer.setPlayerBacknum(Integer.parseInt(csvRecord.get(3)));
                    teamByPlayer.setStartDate(baseParser.toLocalDateTime(csvRecord.get(4)));
                    teamByPlayer.setEndDate(baseParser.toLocalDateTime(csvRecord.get(5)));
                    list.add(teamByPlayer);
                }
        );
    }
}
