package 模拟行走机器人II_2069;

class Robot {

    private int x, y;
    private int[] dir = new int[]{1, 0};
    private int width, height;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void step(int num) {
        while (num-- > 0){
            if(x + dir[0] >= width){
                dir[0] = 0; dir[1] = -1;
            }
            if(x + dir[0] < 0){
                dir[0] = 0; dir[1] = 1;
            }
            if(y + dir[1] >= height){
                dir[0] = -1; dir[1] = 0;
            }
            if(y + dir[1] < 0){
                dir[0] = 1; dir[1] = 0;
            }
            x += dir[0];
            y += dir[1];
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        if(dir[0] == 0){
            if(dir[1] == 1){
                return "North";
            }
            return "South";
        }
        else if(dir[0] == 1){
            return "East";
        }
        else {
            return "West";
        }
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
