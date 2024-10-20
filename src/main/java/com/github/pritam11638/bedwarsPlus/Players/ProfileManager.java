package com.github.pritam11638.bedwarsPlus.Players;

import java.util.HashSet;
import java.util.UUID;

public class ProfileManager {
    private final HashSet<Profile> profiles = new HashSet<>();

    public ProfileManager() {

    }

    public Profile getProfile(UUID uuid) {
        for (Profile profile : profiles) {
            if (profile.getUUID().equals(uuid)) {
                return profile;
            }
        }
        return null;
    }

    public boolean createNewProfile(UUID uuid) {
        Profile profile = getProfile(uuid);

        if (profile != null) return false;

        profiles.add(new Profile(uuid));

        return true;
    }
}
