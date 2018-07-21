import static org.junit.Assert.*;

import org.junit.Test;


public class ArrOperationTest {

	@Test
	public void test() {
		ArrOperation arrOperation=new ArrOperation();
		int[] array={5,4,9,4,9,5};
		int[] numClumps= arrOperation.fixXY(array,4,5);
		int[] arr={9,4,5,4,5,9};
		assertEquals(arr,numClumps);
	}

}
