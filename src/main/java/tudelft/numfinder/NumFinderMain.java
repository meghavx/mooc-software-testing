package tudelft.numfinder;

public class NumFinderMain {

    public static void main (String[] args) {
        NumFinder nf = new NumFinder();

        nf.find(new int[] {4, 3, 2, 1});

        System.out.println(nf.getLargest());
        System.out.println(nf.getSmallest());

        nf.find(new int[] {});

        System.out.println(nf.getLargest());
        System.out.println(nf.getSmallest());

        nf.find(null);

        System.out.println(nf.getLargest());
        System.out.println(nf.getSmallest());
    }
}
