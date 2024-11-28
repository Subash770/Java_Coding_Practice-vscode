package programs;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

enum Season {
    SPRING, SUMMER, AUTUMN, WINTER;
}

enum Activity {
    HIKING, SWIMMING, SKIING, PUMPKIN_CARVING;
}

public class SeasonalActivityOrganizer {
    private final Map<Season, EnumSet<Activity>> seasonActivities;

    public SeasonalActivityOrganizer() {
        seasonActivities = new HashMap<>();
        // Initialize each season with an empty EnumSet
        for (Season season : Season.values()) {
            seasonActivities.put(season, EnumSet.noneOf(Activity.class));
        }
    }

    public Set<Activity> getActivitiesForSeason(Season season) {
        EnumSet<Activity> activities = seasonActivities.get(season);
        if (activities == null) {
            throw new IllegalArgumentException("Unknown season: " + season);
        }
        return activities;
    }

    public Set<Activity> addActivityForSeason(Activity activity, Season season) {
        EnumSet<Activity> activities = seasonActivities.get(season);
        if (activities == null) {
            throw new IllegalArgumentException("Unknown season: " + season);
        }
        activities.add(activity);
        return activities;
    }

    public Set<Activity> removeActivityFromAllSeasons(Activity activity) {
        for (EnumSet<Activity> activities : seasonActivities.values()) {
            activities.remove(activity);
        }
        return getAllActivities();
    }

    public Set<Activity> getAllActivities() {
        EnumSet<Activity> allActivities = EnumSet.noneOf(Activity.class);
        for (EnumSet<Activity> activities : seasonActivities.values()) {
            allActivities.addAll(activities);
        }
        return allActivities;
    }

    public static void main(String[] args) {
        SeasonalActivityOrganizer organizer = new SeasonalActivityOrganizer();

        // Adding activities to specific seasons
        organizer.addActivityForSeason(Activity.HIKING, Season.SPRING);
        organizer.addActivityForSeason(Activity.SWIMMING, Season.SUMMER);
        organizer.addActivityForSeason(Activity.SKIING, Season.WINTER);

        // Retrieve all activities
        System.out.println(organizer.getAllActivities()); // [HIKING, SWIMMING, SKIING]

        // Get activities for specific seasons
        System.out.println(organizer.getActivitiesForSeason(Season.SPRING)); // [HIKING]
        System.out.println(organizer.getActivitiesForSeason(Season.SUMMER)); // [SWIMMING]
        System.out.println(organizer.getActivitiesForSeason(Season.WINTER)); // [SKIING]

        // Remove an activity from all seasons
        organizer.removeActivityFromAllSeasons(Activity.HIKING);

        // Verify removal
        System.out.println(organizer.getActivitiesForSeason(Season.SPRING)); // []
    }
}
