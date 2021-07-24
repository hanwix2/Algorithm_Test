// 같은 숫자는 싫어
// https://programmers.co.kr/learn/courses/30/lessons/12906

package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HateSameNumber {

    public static void main(String[] args) {
        HateSameNumber test = new HateSameNumber();

        int[] arr1 = {1, 1, 3, 3, 0, 1, 1};
        int[] arr2 = {4, 4, 4, 3, 3};

        System.out.println(Arrays.toString(test.solution(arr1)));
        System.out.println(Arrays.toString(test.solution(arr2)));
    }

    public int[] solution(int[] arr) {

        List<Integer> numList = new ArrayList<>();

        int pre = arr[0];

        for (int num : arr) {
            if (pre == num)
                continue;

            numList.add(pre);
            pre = num;
        }

        numList.add(pre);

        int size = numList.size();
        int[] answer = new int[size];

        for (int i = 0; i < size; i++)
            answer[i] = numList.get(i);

        return answer;
    }

}
