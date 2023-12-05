package Visiulizer;
 class MergingIndex {

     int left;
     int right;

    public MergingIndex(int left, int right) {
        this.left = left;
        this.right = right;
        
        
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }
}

public class MergeSort {

     int[] array;
     int[] tempArray;
     int arraySize;
     MergingIndex mergingIndex;
    public MergeSort(int[] array) {
        this.array = array;
        this.arraySize = array.length;
        this.tempArray = new int[arraySize];
        this.mergingIndex=null;
    }
    public MergingIndex sortOneStep() {
        if (mergingIndex == null) {
            resetMergingIndex();
            mergeSort(0, arraySize - 1);
            setMergingIndex(new MergingIndex(0, arraySize - 1));
            return null;
        }

        int left = mergingIndex.getLeft();
        int right = mergingIndex.getRight();

        if (left < right) {
            int middle = (left + right) / 2;

            // Perform one step of the merge operation
            merge(left, middle, right);

            // Return the current merging indices
            return new MergingIndex(left, right);
        }
        resetMergingIndex();
        return null;
    }

    public void merge(int left, int middle, int right) {
        int leftSize = middle - left + 1;
        int rightSize = right - middle;

        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        for (int i = 0; i < leftSize; ++i)
            leftArray[i] = array[left + i];

        for (int j = 0; j < rightSize; ++j)
            rightArray[j] = array[middle + 1 + j];

        int i = 0, j = 0;
        int k = left;
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public void mergeSort(int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(left, middle);
            mergeSort(middle + 1, right);

            merge(left, middle, right);
        }
    }

    public int[] getArray() {
        return array;
    }
    public void setMergingIndex(MergingIndex mergingIndex) {
        this.mergingIndex = mergingIndex;
    }

    public MergingIndex getMergingIndex() {
        return this.mergingIndex;
    }

    public void resetMergingIndex() {
        this.mergingIndex = null;
    }
}
