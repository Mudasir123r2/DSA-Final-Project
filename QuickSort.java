package Visiulizer;
public class QuickSort {
    
     int[] array, stack;
     int low, high, sp, i, j, x, partition;
    boolean isPartioning = false;

    public QuickSort(int[] array) {
        this.array = array;
        stack = new int[array.length];
        low = 0;
        high = array.length-1;
        i = 0;
        j = 0;
        x = 0;
        partition = -1;
        sp = -1;
        stack[++sp] = 0;
        stack[++sp] = array.length-1;
    }

    public void swap(int arr[], int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
  
    // Sorts arr[l..h] using iterative QuickSort
    public int[] sortOnlyOneItem() {
  
        // keep popping elements until stack is not empty
        if (sp >= 0) {

            if (isPartioning == false) {
                high = stack[sp--];
                low = stack[sp];
                i = low - 1;
                x = array[high];
                j = low;
                isPartioning = true;
            }
  
            // set pivot element at it's proper position
            
            if (j <= high - 1) {

                if (array[j] <= x) {
                    i++;
                    swap(array, i, j);
                }
                
                j++;
                return array;
            }
    
            swap(array, i + 1, high);
    
            partition = i + 1;
            
            sp--;
  
            // If there are elements on left side of pivot,
            // then push left side to stack
            if (partition - 1 > low) {
                stack[++sp] = low;
                stack[++sp] = partition - 1;
            }
  
            // If there are elements on right side of pivot,
            // then push right side to stack
            if (partition + 1 < high) {
                stack[++sp] = partition + 1;
                stack[++sp] = high;
            }

            isPartioning = false;
        }

        return array;
    }

    public void push(int val) {
        sp++;
        stack[sp] = val;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
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

    public int getPartition() {
        return partition;
    }

    public void setPartition(int partition) {
        this.partition = partition;
    }

    public int getSP() {
        return sp;
    }

    public void setSP(int sp) {
        this.sp = sp;
    }

    public boolean getIsPartitioning() {
        return isPartioning;
    }

    public void setIsPartioning(boolean isPartioning) {
        this.isPartioning = isPartioning;
    }
}