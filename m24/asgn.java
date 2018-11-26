import java.lang.Math.*;
public class asgn {
	public static void main(String[] args) {
		BinarySearchST bsst = new BinarySearchST<Integer, Integer>();
        SequentialSearchST ssst = new SequentialSearchST<Integer, Integer>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            bsst.put(i, i);
            ssst.put(i, i);
            bsst.get(i+1);
            if (i == bsst.count() * 10) {
                System.out.println("10 times faster when array size is  " + i);
            }
            if (i == bsst.count() * 100) {
                System.out.println("100 times faster when array size is  " + i);
            }
            if (i == bsst.count() * 1000) {
                System.out.println("1000 times faster when array size is  " + i);
                // break;
            }
            for (int j = 0; j < i; j++) {
                bsst.get(j);
                ssst.get(j);
                if (ssst.count() == bsst.count() * 10) {
                    continue;
                }
                if (ssst.count() == bsst.count() * 100) {
                    continue;
                }
                if (ssst.count() == bsst.count() * 1000) {
                    break;
                }
            }
        }
        for (float i = 10.0f; i <= 100000000.0; i++) {
			float j = i / 10;
			float k = i / 100;
			float l = i / 1000;
			if (Math.abs(Math.pow(2.0, j) - i) <= 1.0) {
				System.out.println("10 times faster if size is" +i);
			}
			if (Math.abs(Math.pow(2.0, k) - i) <= 1.0) {
				System.out.println("100 times faster if size is" +i);
			}
			if (Math.abs(Math.pow(2.0, l) - i) <= 1.0) {
				System.out.println("1000 times faster if size is" +i);
				break;
			}
		}
	}
}