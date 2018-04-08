import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
 public class ZipCodeRangeTest {

     ZipCodeRangeTest() {

     }

     @Test
   public  void condenseZipCodeRangeListTest()
    {
        ZipCodeRange zipCodeRange1 = new ZipCodeRange(91100, 91200);
        ZipCodeRange zipCodeRange2 = new ZipCodeRange(91150, 91250);
        ZipCodeRange zipCodeRange3 = new ZipCodeRange(91116, 91231);
        ZipCodeRange zipCodeRange4 = new ZipCodeRange(94566, 94566);
        ZipCodeRange zipCodeRange5 = new ZipCodeRange(94538, 94568);

        ZipCodeRange zipCodeRange6 = new ZipCodeRange(91100, 91250);
        ZipCodeRange zipCodeRange7 = new ZipCodeRange(94538, 94568);

        ArrayList<ZipCodeRange> input = new ArrayList<ZipCodeRange>();


        input.add(zipCodeRange1);
        input.add(zipCodeRange2);
        input.add(zipCodeRange3);
        input.add(zipCodeRange4);
        input.add(zipCodeRange5);
        ArrayList<ZipCodeRange> expected = new ArrayList<ZipCodeRange>();
        expected.add(zipCodeRange6);
        expected.add(zipCodeRange7);
        assertArrayEquals(expected.toArray(), Main.condenseZipCodeRangeList(input).toArray());
    }


}

