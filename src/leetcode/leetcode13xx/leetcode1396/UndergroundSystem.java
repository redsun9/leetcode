package leetcode.leetcode13xx.leetcode1396;

import java.util.HashMap;
import java.util.Objects;

public class UndergroundSystem {
    private final HashMap<Integer, CheckIn> activeCheckIns = new HashMap<>();
    private final HashMap<Route, Long> totalTime = new HashMap<>();
    private final HashMap<Route, Integer> totalTravels = new HashMap<>();

    public UndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        activeCheckIns.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn checkIn = activeCheckIns.remove(id);
        Route route = new Route(checkIn.stationName, stationName);
        totalTravels.put(route, totalTravels.getOrDefault(route, 0) + 1);
        totalTime.put(route, totalTime.getOrDefault(route, 0L) + t - checkIn.t);
    }

    public double getAverageTime(String startStation, String endStation) {
        Route route = new Route(startStation, endStation);
        Long a = totalTime.get(route);
        Integer b = totalTravels.get(route);
        return (double) a / b;
    }

    private static class Route {
        String startStation, endStation;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Route route = (Route) o;
            return startStation.equals(route.startStation) &&
                    endStation.equals(route.endStation);
        }

        @Override
        public int hashCode() {
            return Objects.hash(startStation, endStation);
        }

        public Route(String startStation, String endStation) {
            this.startStation = startStation;
            this.endStation = endStation;
        }
    }

    private static class CheckIn {
        String stationName;
        int t;

        public CheckIn(String stationName, int t) {
            this.stationName = stationName;
            this.t = t;
        }
    }
}
