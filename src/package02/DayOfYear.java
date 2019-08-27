package package02;

import java.util.Scanner;

/**
 * 그 해 경과 일 수를 구함
 *
 * 윤년 : 4로 나누어 떨어지는 해를 윤년
 * 평년 : 100으로 나누어 떨이지고 400으로 나누어 떨어지지 않는 해는 평년
 */
public class DayOfYear {


    // 각 달의 일 수
    static int[][] mdays = {
            {31,28,31,30,31,30,31,31,30,31,30,31}, //평년
            {31,29,31,30,31,30,31,31,30,31,30,31}
    };

    // 서기 year년은 윤년인가? (윤년: 1/ 평년:0)
    static int isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
    }

    // 서기 y년 m월 d일의 그 해 경과 일 수를 구함
    static int dayOfYear(int y, int m, int d) {
        int days = d;

        for (int i = 1; i < m; i++)
            days += mdays[isLeap(y)][i - 1];
        return  days;
    }

    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);

        int retry;

        System.out.println("그 해 경과 일수를 구합니다.");

        do {

            System.out.println("년 : "); int year = stdIn.nextInt(); //년
            System.out.println("월 : "); int month = stdIn.nextInt(); //월
            System.out.println("일 : "); int day = stdIn.nextInt(); //일

            System.out.printf("그 해 %d일째입니다.\n", dayOfYear(year,month,day));

            System.out.print("한 번 더 할까요? (1.예/0.아니오) : ");
            retry = stdIn.nextInt();

        } while (retry == 1);

    }
}


