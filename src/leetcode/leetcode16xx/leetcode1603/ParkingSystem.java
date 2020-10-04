package leetcode.leetcode16xx.leetcode1603;

public class ParkingSystem {
    private int[] left;

    public ParkingSystem(int big, int medium, int small) {
        left = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        return left[carType - 1]-- > 0;
    }
}
