import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class RecAct extends RecursiveAction {
    private final int[] arr;
    private final int start;
    private final int end;
    private final int granularity;

    public RecAct(final int[] arr, int start, int end) {
	this.arr = arr;
	this.start = start;
	this.end = end;
	this.granularity = 700;
    }
    @Override
    public void compute() {
	if (end - start < 400) { //this.sequential_threshold) {
	    //sequential sort
	    qsortSequential(); 
	}
	else {
	    //parallel sort
	    int mid = (start + end) / 2; 
	    RecAct r1 = new RecAct(arr, start, mid);
	    r1.fork();
	    RecAct r2 = new RecAct(arr, mid+1, end); 
	    r2.compute();
	    r1.join();
	}
    } 

    // ---------------------------------------------------------
    // ---------------------------------------------------------
    // ---------------------------------------------------------
    // ---------------------------------------------------------

    public void qsortParallell() {
      
	ForkJoinPool p = new ForkJoinPool();
	p.invoke(this); //invoke also calls compute
    }
    // ---------------------------------------------------------
    // ---------------------------------------------------------
    // ---------------------------------------------------------
    // ---------------------------------------------------------   
    private void insertionSort(final int[] arr, final int start, final int end) {

        for (int i = start + 1; i < end; ++i) {
            int j = i;
            int tmp = arr[i];
            while (j > 0 && arr[j-1] > tmp) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = tmp;
        }
    }
    public void qsortSequential() {
        int left = start;
        int right = end + 1;
        // We simply pick the first element as pivot..

	final int pivot = arr[this.start];
        int tmp;

        // Rearranging the elements around the pivot, so that
        // elements smaller than the pivot end up to the left
        // and elements bigger than the pivot end up to the
        // right.
        do {

            // As long as elements to the left are less than
            // the pivot we just continue.
            do {
                left++;
            } while (left <= end && arr[left] < pivot);

            // As long as the elements to the right are
            // greater than the pivot we just continue.
            do {
                right--;
            } while (arr[right] > pivot);

            // If left is less than right we have values on
            // the wrong side of the pivot, so we swap them.
            if (left < right) {
                tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }

            // We continue doing this until all elements are
            // arranged correctly around the pivot.
        } while (left <= right);

        // Now put the pivot in the right place.
        tmp = arr[start];
        arr[start] = arr[right];
        arr[right] = tmp;

        // We have now "split" the range arr[start, end] into
        // two parts around the pivot value. We recurse to
        // sort those parts.
        if (start < right) {
            if (end - start < this.granularity) {
	  	insertionSort(arr, start, right); //right or left
	    }
            else {
		(new RecAct(arr, start, right)).qsortSequential();
		
	    }//todo: create new task with appropriate bounds and compute it .compute()
        }
        if (left < end) {
            if (end - start < this.granularity) {
		insertionSort(arr, left, end);
	    }
            else {
		(new RecAct(arr, left, end)).qsortSequential();
	    }
	    //todo: see above
        }
    }
}
