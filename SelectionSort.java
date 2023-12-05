package Visiulizer;
public class SelectionSort {
    
     int i, j, min_idx;
     int[] array;
     boolean findingMin;

    public SelectionSort(int[] array) {
        this.array = array;
        i = 0;
        j = 1;
        min_idx = 0;
        findingMin = false;
    }

    public void swap(int arr[], int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public int[] sortOnlyOneItem() {

        if (findingMin == false) {
            min_idx = i;
            findingMin = true;
        }

        if (array[j] < array[min_idx]) {
            min_idx = j;
        }

        j++;

        if (j >= array.length) {
            swap(array, min_idx, i);
            i++;
            j = i + 1;
            findingMin = false;
        }

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

    public int getMinIdx() {
        return min_idx;
    }

    public void setMinIdx(int min_idx) {
        this.min_idx = min_idx;
    } 
}
