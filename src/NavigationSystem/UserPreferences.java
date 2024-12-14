package NavigationSystem;

public class UserPreferences {
    private String preferredMode;
    private boolean avoidTraffic;

    public UserPreferences(String preferredMode, boolean avoidTraffic) {
        this.preferredMode = preferredMode;
        this.avoidTraffic = avoidTraffic;
    }

    public String getPreferredMode() {
        return preferredMode;
    }

    public boolean isAvoidTraffic() {
        return avoidTraffic;
    }
}
