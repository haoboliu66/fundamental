package com.hbliu.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class StreamTest {

    @Test
    public void findOrMatch() {
        List<Integer> list = Arrays.asList(5, 7, 6, 1, 2, 3, 1, 8, 5);
        int[] res = list.stream().filter(x -> x < 3).mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(res));

        List<Integer> list2 = list.stream().filter(x -> x >= 4).collect(Collectors.toList());
        System.out.println(list2);

        Optional<Integer> any = list.stream().filter(x -> x > 3).findAny();
        System.out.println(any);

        boolean b = list.stream().anyMatch(x -> x >= 8);
        System.out.println(b);
    }


    @Test
    public void testList() {
        ArrayList<Integer> res = new ArrayList<Integer>() {
            {
                this.add(1);
                this.add(2);
                this.add(3);
                this.add(4);
                this.add(5);
            }
        };

        Integer[] arr = res.toArray(new Integer[0]);
        int[] arr2 = res.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }


    @Test
    public void testConsumer() {
        ArrayList<Integer> res = new ArrayList<Integer>() {
            {
                this.add(1);
                this.add(2);
                this.add(3);
                this.add(4);
                this.add(5);
            }
        };
        Integer[] arr = res.toArray(new Integer[0]);
        res.forEach(x -> print(x + 10));
    }

    public void print(int x) {
        System.out.println(x);
    }


    @Test
    public void testCF() throws ExecutionException, InterruptedException {
//        CompletableFuture<Void> res = CompletableFuture.runAsync(() -> action("action1"));

        // z  3     a  b  [c]
        // 25            -> 2

        System.out.println(getShift('a', 26));
    }

    public char getShift(char cur, int t) {

        return (char) ((((cur - 'a') + 26 + t) % 26) + 'a');


    }

    public void action(String name) {
        System.out.println(name + "\tstart");
        System.out.println(name + "\tend");
    }


    public static void main(String[] args) {

    }

}
