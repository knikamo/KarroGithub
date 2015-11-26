import java.util.concurrent.ForkJoinPool.*;
import java.util.concurrent.RecursiveAction;

public class ParQuicksort {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java recAct #<random elements>");
        }
	else {

            int no_elements = Integer.parseInt(args[0]);
            int[] elements = new int[no_elements];
            java.util.Random r = new java.util.Random();
            for (int i = 0; i < no_elements; ++i) {
                elements[i] = r.nextInt();
            }

            /// Here is where the work happens/is started
            long start = System.currentTimeMillis();
            

	    RecAct s1 = new RecAct(elements, 0, elements.length-1);
	    //s1.qsortSequential();
	    s1.qsortParallell();
	    
            long stop = System.currentTimeMillis();

            System.out.println("Wall-clock time: " + (stop - start) + " ms");

            /// Sanity check
            assert(isSorted(elements));
        }
    }



    /// You do not need to change this method
    public static boolean isSorted(int[] elements) {
        if (elements.length == 1) return true;
        for (int i = 1; i < elements.length; ++i)
            if (elements[i-1] > elements[i]) return false;
        return true;
    }

}
