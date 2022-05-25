package telran.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MessageBox {
    private String message;
    Lock lock;
    Condition conditionSend;
    Condition conditionReceive;

    public MessageBox() {
        lock = new ReentrantLock();
        conditionSend = lock.newCondition();
        conditionReceive = lock.newCondition();
    }

  public void putMessage(String message) {
      try {
          lock.lock();
          while (this.message != null) {
              try {
                  conditionSend.await();
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
          this.message = message;
          conditionReceive.signal();
      } finally {
          lock.unlock();
      }

    }

    public String takeMessage() {
        try {
            lock.lock();
            while(message == null) {
                try {
                    conditionReceive.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String res = message;
            message = null;
            conditionSend.signalAll();
            return res;
        } finally {
            lock.unlock();
        }
    }
}
