/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package exercise14;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Nils Kimman s1007368
 * @author Ole ten Hove s1007616
 */
public class BoundedBuffer<E> {

    public Queue<E> source;
    final int MAX;
    private Lock myLock;
    private Condition full, empty;

    public BoundedBuffer(int size) {
        this.MAX = size;
        this.source = new LinkedList<>();
        myLock = new ReentrantLock();
        full = myLock.newCondition();
        empty = myLock.newCondition();
    }

    public void put(E element) {
        myLock.lock();
        try {
            while (source.size() >= MAX) {
                System.out.println("Waiting to write: " + element);
                full.await();
            }
            source.add(element);
            empty.signalAll();
        } catch (Exception e) {
            System.out.println("Interrupted 'put' with: " + element);
        } finally {
            myLock.unlock();
        }
    }

    public E get() {
        myLock.lock();
        E result = null;
        try {
            while (source.isEmpty()) {
                System.out.println("Waiting to get");
                empty.await();
            }
            result = source.poll();
            full.signalAll();
        } catch (Exception e) {
            System.out.println("Interrupted 'get'");
        } finally {
            myLock.unlock();
        }
        return result;
    }
}
