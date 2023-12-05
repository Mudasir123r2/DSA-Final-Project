package Visiulizer;

public class InsertionSort {

     int[] array;
     int i;
     int j;
     int key;
     boolean startOfIteration = false;

    public InsertionSort(int[] array) {
        this.array = array;
        i = 1;
    }

    public int[] sortOnlyOneItem() {

        if (startOfIteration == false) {
            key = array[i];
            j = i - 1;
            startOfIteration = true;
        }

        if (j >= 0 && array[j] > key) {
            array[j + 1] = array[j];
            j--;
            return array;
        }
        else {
            array[j + 1] = key;
            i++;
        }

        
        startOfIteration = false;
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

    public boolean getStartOfIteration() {
        return startOfIteration;
    }

    public void setStartOfIteration(boolean startOfIteration) {
        this.startOfIteration = startOfIteration;
    }
}
