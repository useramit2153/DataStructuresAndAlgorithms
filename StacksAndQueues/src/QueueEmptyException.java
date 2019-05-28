/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
class QueueEmptyException extends Exception {

    public QueueEmptyException() {
        System.out.println("Queue is empty.");
    }
    
}
