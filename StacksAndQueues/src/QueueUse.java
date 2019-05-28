
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class QueueUse {
    public static void main(String[] args) throws QueueEmptyException, QueueFullException {
        QueueUsingArray queue = new QueueUsingArray(3);
        for(int i = 0; i < 5; i ++) {
            try {
                queue.enqueue(i);
            } catch(QueueFullException e) {
                e.printStackTrace();
            }
        }
        
        while(!queue.isEmpty()) {
            try {
                System.out.println(queue.dequeue());
            } catch (QueueEmptyException ex) {
                Logger.getLogger(QueueUse.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
//        QueueUsingLL<Integer> queue = new QueueUsingLL<Integer>();
//        for(int i = 0; i <= 5; i ++) {
//            queue.enqueue(i);
//        }
//        System.out.println(queue.size());
//        System.out.println(queue.front());
//        while(!queue.isEmpty()) {
//            try {
//                System.out.println(queue.dequeue());
//            } catch (QueueEmptyException ex) {
//                Logger.getLogger(QueueUse.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        for(int i = 0; i <= 5; i ++) {
//            queue.enqueue(i);
//        }
//        while(!queue.isEmpty()) {
//            try {
//                System.out.println(queue.dequeue());
//            } catch (QueueEmptyException ex) {
//                Logger.getLogger(QueueUse.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        
    }
}
