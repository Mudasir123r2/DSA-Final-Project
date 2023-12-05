package Visiulizer;

public class BubbleSort {
    
     int[] array;
     int i, j;

    public BubbleSort(int[] array) {
        this.array = array;
        i = 0;
        j = Integer.MAX_VALUE;
    }

    public int[] sortOnlyOneItem() {

        if (array[j] > array[j+1]) {
            int temp = array[j];
            array[j] = array[j+1];
            array[j+1] = temp;
        }
        
        if ((j+1) >= (array.length - i - 1)) {
            i++;
            j = 0;
        }
        
        else j++;

        return array;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getArrayIndex() {
        return i;
    }

    public void setArrayIndex(int i) {
        this.i = i;
    }

    public int getCompareIndex() {
        return j;
    }

    public void setCompareIndex(int j) {
        this.j = j;
    }
}
