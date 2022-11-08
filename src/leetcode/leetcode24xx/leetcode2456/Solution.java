package leetcode.leetcode24xx.leetcode2456;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        HashMap<String, CreatorStats> map = new HashMap<>();
        int n = creators.length;
        for (int i = 0; i < n; i++) {
            int j = i;
            map.compute(
                    creators[i],
                    (k, v) -> {
                        int view = views[j];
                        String id = ids[j];
                        if (v == null) return new CreatorStats(view, id, view);
                        return v.maxView < view || v.maxView == view && v.maxVideo.compareTo(id) > 0 ?
                                new CreatorStats(v.totalViews + view, id, view)
                                : new CreatorStats(v.totalViews + view, v.maxVideo, v.maxView);
                    }
            );
        }
        long maxTotalViews = 0;
        for (CreatorStats value : map.values()) maxTotalViews = Math.max(maxTotalViews, value.totalViews);
        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<String, CreatorStats> entry : map.entrySet()) {
            if (entry.getValue().totalViews == maxTotalViews)
                ans.add(List.of(entry.getKey(), entry.getValue().maxVideo));
        }
        return ans;
    }

    private static class CreatorStats {
        long totalViews;
        String maxVideo;
        int maxView;

        public CreatorStats(long totalViews, String maxVideo, int maxView) {
            this.totalViews = totalViews;
            this.maxVideo = maxVideo;
            this.maxView = maxView;
        }
    }
}
