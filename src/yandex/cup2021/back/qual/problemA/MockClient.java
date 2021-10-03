package yandex.cup2021.back.qual.problemA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

class MockClient implements Main.Client {
    final Map<String, String> map;

    MockClient(
            String[] k,
            String v1, String v2, String v3, String v4
    ) {
        map = Map.of(k[0], v1, k[1], v2, k[2], v3, k[3], v4);
    }

    MockClient(
            String[] k,
            String[] v
    ) {
        map = Map.of(k[0], v[0], k[1], v[1], k[2], v[2], k[3], v[3]);
    }

    @Override
    public List<String> get(List<String> list) {
        List<String> result = new ArrayList<>();
        for (String s : list) result.add(map.get(s));
        Collections.sort(result);
        return result;
    }
}
