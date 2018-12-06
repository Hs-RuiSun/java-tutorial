package com.ruby.sun.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class JCallable implements Callable<Integer> {
    Integer operand1;
    Integer operand2;

    JCallable(Integer operand1, Integer operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    @Override
    public Integer call() throws Exception {
        return operand1 + operand2;
    }
}

/**
 * divide and conquer
 */
public class CallableParallelSum {
    public static void main(String[] args) {
        parallel();
    }

    public static Integer parallel() {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<Integer>> list = new ArrayList<Future<Integer>>();
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 1) { //grouping
                Future<Integer> future = executor.submit(new JCallable(i + 1, i));
                list.add(future);
                continue;
            }
        }
        int totsum = 0;
        for (Future<Integer> fut : list) {
            try {
                totsum = totsum + fut.get();
            } catch (InterruptedException e) {
            } catch (ExecutionException e) {
            }
        }
        System.out.println("Total Sum is " + totsum);
        return totsum;
    }
}
