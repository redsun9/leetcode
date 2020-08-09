package other;

import java.util.*;
import java.util.function.ToLongFunction;

public class Taxi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = Integer.parseInt(scanner.nextLine());
        for (int t = 0; t < x; t++) {
            int e = scanner.nextInt(); // events number
            int n = scanner.nextInt();
            int k = Integer.parseInt(scanner.nextLine().trim()) * 60; // in seconds
            HashMap<String, Ride> rideHashMap = new HashMap<>();
            for (int i = 0; i < e; i++) {
                String[] split = scanner.nextLine().split(" ");
                Ride ride;
                if (rideHashMap.containsKey(split[1])) {
                    ride = rideHashMap.get(split[1]);
                } else {
                    ride = new Ride();
                    rideHashMap.put(split[1], ride);
                }
                switch (split[0]) {
                    case "ordered":
                        ride.userId = split[2];
                        ride.orderedAt = Long.parseLong(split[3]);
                        ride.expectedArriveTime = Long.parseLong(split[4]);
                        ride.expectedRideTime = Long.parseLong(split[5]);
                        break;
                    case "arrived":
                        ride.arrivedAt = Long.parseLong(split[2]);
                        break;
                    case "started":
                        ride.startedAt = Long.parseLong(split[2]);
                        break;
                    case "finished":
                        ride.finishedAt = Long.parseLong(split[2]);
                        break;
                    default:
                        throw new RuntimeException("unknown command");
                }
            }
            HashMap<String, Long> userLateTime = new HashMap<>();
            for (Ride ride : rideHashMap.values()) {
                if (
                        ride.orderedAt != null &&
                                ride.arrivedAt != null &&
                                ride.startedAt != null &&
                                ride.finishedAt != null
                ) {
                    long expected = ride.orderedAt + 60 * ride.expectedArriveTime + k + 60 * ride.expectedRideTime;
                    if (
                            expected < ride.finishedAt &&
                                    ride.arrivedAt + k >= ride.startedAt
                    ) {
                        userLateTime.put(
                                ride.userId,
                                userLateTime.getOrDefault(ride.userId, 0L) + ride.finishedAt - expected
                        );
                    }
                }
            }
            PriorityQueue<Map.Entry<String, Long>> pq = new PriorityQueue<>(
                    n + 1,
                    Comparator.comparingLong((ToLongFunction<Map.Entry<String, Long>>) Map.Entry::getValue)
                            .thenComparing(Map.Entry.<String, Long>comparingByKey().reversed())
            );
            for (Map.Entry<String, Long> entry : userLateTime.entrySet()) {
                pq.offer(entry);
                if (pq.size() > n) pq.poll();
            }
            LinkedList<String> list = new LinkedList<>();
            for (Map.Entry<String, Long> entry : pq) {
                list.addFirst(entry.getKey());
            }
            System.out.println(String.join(" ", list));
        }
    }

    private static class Ride {
        String orderId;
        String userId;
        Long orderedAt;
        Long arrivedAt;
        Long startedAt;
        Long finishedAt;
        Long expectedArriveTime;
        Long expectedRideTime;
    }
}
