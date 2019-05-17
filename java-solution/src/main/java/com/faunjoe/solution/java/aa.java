package com.faunjoe.solution.java;


/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-26 13:35
 */
public class aa {


    public static void main(String[] args) {

        double base = 22000 - 5000 - (1896.08 + 477.02 + 47.40 + 2844) - 3500;
        double one = base * 0.03;
        System.out.println("one : " + one);

        double two1 = base * 2;
        System.out.println("two1 : " + two1);
        double two = two1 * 0.03 - one;
        System.out.println("two : " + two);

        double three1 = base * 3;
        System.out.println("three1 : " + three1);
        double three = three1 * 0.03 - two - one;
        System.out.println("three : " + three);

        double four1 = base * 4;
        System.out.println("four1 : " + four1);
        double four = four1 * 0.03 - three - two - one;
        System.out.println("four : " + four);

        double five1 = base * 5;
        System.out.println("five1 : " + five1);
        double five = five1 * 0.1 - 2520 - four - three - two - one;
        System.out.println("five : " + five);

        double six1 = base * 6;
        System.out.println("six1 : " + six1);
        double six = six1 * 0.1 - 2520 - five - four - three - two - one;
        System.out.println("six : " + six);

        double seven1 = base * 7;
        System.out.println("seven1 : " + seven1);
        double seven = seven1 * 0.1 - 2520 - six - five - four - three - two - one;
        System.out.println("seven : " + seven);

        double eight1 = base * 8;
        System.out.println("eight1 : " + eight1);
        double eight = eight1 * 0.1 - 2520 - seven - six - five - four - three - two - one;
        System.out.println("eight : " + eight);

        double nine1 = base * 9;
        System.out.println("nine1 : " + nine1);
        double nine = nine1 * 0.1 - 2520 - eight - seven - six - five - four - three - two - one;
        System.out.println("nine : " + nine);

        double ten1 = base * 10;
        System.out.println("ten1 : " + ten1);
        double ten = ten1 * 0.1 - 2520 - nine - eight - seven - six - five - four - three - two - one;
        System.out.println("ten : " + ten);

        double tenone1 = base * 11;
        System.out.println("tenone1 : " + tenone1);
        double tenone = tenone1 * 0.1 - 2520 - ten - nine - eight - seven - six - five - four - three - two - one;
        System.out.println("tenone : " + tenone);

        double tentwo1 = base * 12;
        System.out.println("tentwo1 : " + tentwo1);
        double tentwo = tentwo1 * 0.2 - 16920 - tenone - ten - nine - eight - seven - six - five - four - three - two - one;
        System.out.println("tentwo : " + tentwo);
    }
}
