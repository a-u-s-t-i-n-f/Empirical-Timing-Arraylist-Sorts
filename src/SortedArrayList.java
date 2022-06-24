import java.util.*;

class SortedArrayList<E> {
    private E[] oArray;
    public int capacity;
    public int size;

    public SortedArrayList() {    //constructor

        size = 0;
        capacity = 5;
        oArray = (E[]) new Object[capacity];  //new object
        this.capacity = capacity;
    }

    private void capacityCheck(int capacity) {

        E[] oArr = Arrays.copyOf(oArray, capacity);
        oArray = oArr;
        this.capacity = capacity;
    }


    public boolean add(E item) {
        if(size >= capacity) {
            capacityCheck(capacity * 2);
        }

        if(size == 0) {
            oArray[0] = item;
        }

        else {
            for(int x = size - 1; x >= 0; x--) {
                if (((Comparable<E>)item).compareTo(oArray[x]) < 0) {
                    oArray[x + 1] = oArray[x];

                }
                else {
                    oArray[x + 1] = item;
                    size++;
                    return true;
                }
            }
        }
        return false;
    }

    public int capacity() {

        return capacity;
    }

    public void clear() {
        for (int x = 0; x < capacity; x++) {
            oArray[x] = null;

            capacity = 0;
        }
    }

    public E get(int index) {

        return oArray[index];

    }

    public boolean isEmpty() {
        if (size == 0)
            return true;
        else
            return false;
    }

    public E remove(int index) {

        if (index < 0 || index >= size) {
            return null;
        }

        if((size * 2) < capacity) {
            capacityCheck(capacity / 2);

        }

        E itemDel = oArray[index];
        for(int x = index; x < size - 1; x++) {
            oArray[x + 1] = oArray[x];

        }

        size--;
        return itemDel;

    }

    public int size() {

        return size;
    }
}

class mainTest {
    public static void main(String[] args) {


        int testSize = 6;

        for(int x = 1; x < 7; x++) {

            SortedArrayList<Integer> oArray = new SortedArrayList<>();


            long startTime = System.nanoTime();

            //Uncomment each test method for testing

            testAddOrder(oArray, testSize);
            //testAddReverse(oArray, testSize);
            //testRemove(oArray, testSize);
            //testClear(oArray);


            long endTime = System.nanoTime();

            long totalTime = endTime - startTime;

            System.out.println("Test Number : " + x);
            System.out.println("Total time: " + (endTime - startTime) + " nanoseconds");
            long oldTime = (endTime - startTime);
            System.out.println();
            testSize *= 2;

            //long oldTime = (endTime - startTime);

            if(x >= 1) {

                long timeDisparity = totalTime / oldTime;
                System.out.println("Time Disparity: " + timeDisparity);
            }

        }
    }

    public static void testAddOrder(SortedArrayList<Integer> oArray, int testSize) {
        for(int x = 0; x < testSize; x++ ) {
            oArray.add(x);
        }
    }

    public static void testAddReverse(SortedArrayList<Integer> oArray, int testSize) {
        for(int x = testSize; x < 0; x--) {
            oArray.add(x);
        }
    }

    public static void testRemove(SortedArrayList<Integer> oArray, int testSize) {

        for(int y = 0; y < testSize; y++ ) {
            oArray.add(y);
        }

        for(int x = 0; x < testSize; x++ ) {
            oArray.remove(0);
        }
    }

    public static void testClear(SortedArrayList<Integer> oArray) {

        oArray.clear();
    }
}