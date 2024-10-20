package com.github.pritam11638.bedwarsPlus.Players;

import java.util.UUID;

public class Profile {
    private final UUID uuid;

    public Profile(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUUID() {
        return uuid;
    }
}
