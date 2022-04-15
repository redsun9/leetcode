package help_requests.scaler;

public class Scaler {
    // scale picture or video to fit screen, as close as possible to original ratio
    public static int[] scale(int[] screenSize, int[] videoRatio) {
        // screen size = w*h
        // video ration = rw * rh
        // ans = sw*sh

        // scale = min (w/rw, h/rh)
        // sw = scale*rw, sh = scale*rh

        double scale = Math.min((double) screenSize[0] / videoRatio[0], (double) screenSize[1] / videoRatio[1]);

        int sw = (int) Math.round(scale * videoRatio[0]);
        if (sw > screenSize[0]) sw--;

        int sh = (int) Math.round(scale * videoRatio[1]);
        if (sh > screenSize[1]) sh--;

        return new int[]{sw, sh};
    }
}
