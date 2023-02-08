package HW4;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class task4 {
    public static class Main {
        public static void main(String[] args) {
            Homework hw = new Homework();
            System.out.println(hw.multiple(new ArrayDeque<>(Arrays.asList(5, 2)), new ArrayDeque<>(Arrays.asList(4))));
            System.out.println(hw.sum(new ArrayDeque<>(Arrays.asList(5, -2)), new ArrayDeque<>(Arrays.asList(5))));
        }
    }
}

class Homework {

    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2) {
        return getDeque(getInteger(d1) * getInteger(d2));
    }

    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) {
        return getDeque(getInteger(d1) + getInteger(d2));
    }

    private Deque<Integer> getDeque(int inputInteger) {
        int localInt = inputInteger;
        ArrayDeque<Integer> rezDeq = new ArrayDeque<>();
        while (Math.abs(localInt) > 0) {
            rezDeq.add(localInt % 10);
            localInt /= 10;
        }
        return rezDeq;
    }

    private int getInteger(Deque<Integer> inputDeque) {
        ArrayDeque<Integer> localDeque = new ArrayDeque<>(inputDeque);
        int num = 0;
        int i = 0;
        while (localDeque.size() > 0) {
            if (localDeque.getFirst() > 0)
                num += localDeque.removeFirst() * Math.pow(10, i++);
            else if (localDeque.getFirst() < 0) {
                num = -num;
                num += localDeque.removeFirst() * Math.pow(10, i++);
            }
        }
        return num;
    }


}