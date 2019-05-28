
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class Priority_Queue_Max {
    private ArrayList<Integer> heap;
    public Priority_Queue_Max() {
        heap = new ArrayList<>();
    }
    boolean isEmpty() {
        return heap.size() == 0;
    }
    int getSize() {
        return heap.size();
    }
    int getMax() throws PriorityQueueException {
        if(heap.isEmpty())
            throw new PriorityQueueException();
        return heap.get(0);
    }
    void insert(int element) {
        heap.add(element);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;
        
        while(childIndex > 0) {
            if(heap.get(childIndex) > heap.get(parentIndex)) {
                int temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(childIndex));
                heap.set(childIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
                System.out.println("hello");
            } else
                return;
        }
    }
    int removeMax() throws PriorityQueueException {
        if(heap.size() == 0)
            throw new PriorityQueueException();
        if(heap.size() == 1)
            return heap.remove(0);
        int temp = heap.remove(heap.size() - 1);
        int ans = heap.get(0);
        heap.set(0, temp);
        int parentIndex = 0;
        int leftChildIndex = 0 * 2 + 1;
        int rightChildIndex = 0 * 2 + 2;
        while(leftChildIndex < heap.size() || rightChildIndex < heap.size()) {
            if(leftChildIndex < heap.size() && rightChildIndex >= heap.size()) {
                if(heap.get(parentIndex) < heap.get(leftChildIndex)) {
                    // Swap Left Child With Parent
                    temp = heap.get(leftChildIndex);
                    heap.set(leftChildIndex, heap.get(parentIndex));
                    heap.set(parentIndex, temp);
                    parentIndex = leftChildIndex;
                } else
                    return ans;
            } else if(leftChildIndex < heap.size() && rightChildIndex < heap.size()) {
                if(heap.get(parentIndex) < heap.get(leftChildIndex) || heap.get(parentIndex) < heap.get(rightChildIndex)) {
                    if(heap.get(leftChildIndex) >= heap.get(rightChildIndex)) {
                        // Swap Left Child With Parent
                        temp = heap.get(leftChildIndex);
                        heap.set(leftChildIndex, heap.get(parentIndex));
                        heap.set(parentIndex, temp);
                        parentIndex = leftChildIndex;
                    } else if(heap.get(rightChildIndex) > heap.get(leftChildIndex)) {
                        // Swap Right ChildWith Parent
                        temp = heap.get(rightChildIndex);
                        heap.set(rightChildIndex, heap.get(parentIndex));
                        heap.set(parentIndex, temp);
                        parentIndex = rightChildIndex;
                    } else
                        return ans;
                }
            }
            leftChildIndex = parentIndex * 2 + 1;
            rightChildIndex = parentIndex * 2 + 2;
        }
        return ans;
    }
}
