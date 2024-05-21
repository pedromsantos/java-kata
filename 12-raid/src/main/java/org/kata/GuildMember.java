package org.kata;

import java.util.ArrayList;
import java.util.List;

public class GuildMember {
    private final List<Raid> raids = new ArrayList<>();
    private final List<GuildMember> friends = new ArrayList<>();

    public List<GuildMember> getFriends() {
        return friends;
    }

    public void addFriend(GuildMember member) {
        friends.add(member);
    }

    public void addRaid(Raid raid) {
        raids.add(raid);
    }

    public List<Raid> getRaids() {
        return raids;
    }
}
