package 一周中的第几天_1185;

import java.time.LocalDate;

class Solution {
    private static String[] week =
            new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    public String dayOfTheWeek(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        return week[date.getDayOfWeek().getValue() - 1];
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.dayOfTheWeek(3, 1, 2022));
    }
}
