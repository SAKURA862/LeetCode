package 在圆内随机生成点_478;

class Solution {

    private double r, x, y;

    public Solution(double radius, double x_center, double y_center) {
        this.r = radius;
        this.x = x_center;
        this.y = y_center;

    }

    public double[] randPoint() {
        double d = r * Math.sqrt(Math.random());
        double theta = Math.random() * 2 * Math.PI;
        return new double[]{d * Math.cos(theta) + x, d * Math.sin(theta) + y};
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
