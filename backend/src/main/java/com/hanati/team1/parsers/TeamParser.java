package com.hanati.team1.parsers;

import com.hanati.team1.src.players.entities.Team;
import com.hanati.team1.src.players.repository.TeamRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeamParser implements Parsable{
    private final BaseParser baseParser;
    private final TeamRepository teamRepository;

    @Override
    public void parse() throws Exception {
        baseParser.parse(teamRepository,
                (csvRecord, list) -> {
                    Team team = new Team();
                    team.setTeamId(Long.parseLong(csvRecord.get(0)));
                    team.setTeamName(csvRecord.get(1));
                    team.setTeamNation(csvRecord.get(2));
                    list.add(team);
                }
        );
    }
}
