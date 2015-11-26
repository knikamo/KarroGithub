public class SeqQuicksort {
    /// You do not need to change this method
	private final int[] arr;
	private final int start;
	private final int end;
	private final int granularity;
	
	public void SeqQuicksort(final int[] arr, int start, int end) {
		this.arr = arr;
		this.start = start;
		this.end = end;
		this.granularity = 700;

	}    
private void insertionSort() {

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
        int left = this.start;
        int right = this.end + 1;
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
            insertionSort();
            }
            else qsortSequential();
        }
        if (left < end) {
            if (end - start < this.granularity) {
            insertionSort();
            }
            else
            qsortSequential();
        }
    }
}
