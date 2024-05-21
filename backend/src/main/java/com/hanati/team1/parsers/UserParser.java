package com.hanati.team1.parsers;

import com.hanati.team1.src.customers.entities.User;
import com.hanati.team1.src.customers.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserParser implements Parsable{
    private final BaseParser baseParser;
    private final UserRepository userRepository;

    @Override
    public void parse() throws Exception {
        baseParser.parse(
                "User.csv",
                userRepository,
                (csvRecord, list) -> {
                    User user = new User();
                    user.setUserId(Long.parseLong(csvRecord.get(0)));
                    user.setUserName(csvRecord.get(1));
                    user.setUserProfile(csvRecord.get(2));
                    list.add(user);
                }
        );
    }
}
