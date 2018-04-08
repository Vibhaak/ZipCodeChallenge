import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void Main(String[] args) {

        /*Sample input
        ZipCodeRange zipCodeRange1 = new ZipCodeRange(94113, 94113);
        ZipCodeRange zipCodeRange2 = new ZipCodeRange(94200, 94299);
        ZipCodeRange zipCodeRange3 = new ZipCodeRange(94226, 94399);*/

        ZipCodeRange zipCodeRange1 = new ZipCodeRange(91100, 91200);
        ZipCodeRange zipCodeRange2 = new ZipCodeRange(91150, 91250);
        ZipCodeRange zipCodeRange3 = new ZipCodeRange(91116, 91231);
        ZipCodeRange zipCodeRange4 = new ZipCodeRange(94566, 94566);
        ZipCodeRange zipCodeRange5 = new ZipCodeRange(94538, 94568);

        ArrayList<ZipCodeRange> zipCodeRangeList = new ArrayList<ZipCodeRange>();
        ArrayList<ZipCodeRange> condensedZipCodeRangeList = new ArrayList<ZipCodeRange>();
        zipCodeRangeList.add(zipCodeRange1);
        zipCodeRangeList.add(zipCodeRange2);
        zipCodeRangeList.add(zipCodeRange3);
        zipCodeRangeList.add(zipCodeRange4);
        zipCodeRangeList.add(zipCodeRange5);

        condensedZipCodeRangeList=condenseZipCodeRangeList(zipCodeRangeList);

        for(ZipCodeRange zipCodeRange: condensedZipCodeRangeList)
        {
            System.out.println("("+zipCodeRange.getLow()+", "+zipCodeRange.getHigh()+")");
        }


    }

    //Logic for merging zipcode tuples
    private static ArrayList<ZipCodeRange> condenseZipCodeRangeList(ArrayList<ZipCodeRange> zipCodeRangeList) {

        ArrayList<ZipCodeRange> condensedZipCodeRangeList = new ArrayList<ZipCodeRange>();
        if(zipCodeRangeList.size()>0) {
            sortRange(zipCodeRangeList);
            ZipCodeRange temp_obj = zipCodeRangeList.get(0);

            for (int i = 0; i < zipCodeRangeList.size(); i++) {
                if ((temp_obj.getHigh() + 1 == zipCodeRangeList.get(i).getLow())
                        || (temp_obj.getHigh() >= zipCodeRangeList.get(i).getLow())) {
                    if ((temp_obj.getHigh() < zipCodeRangeList.get(i).getHigh())
                            && (temp_obj.getLow() != zipCodeRangeList.get(i).getLow())) {
                        temp_obj.setHigh(zipCodeRangeList.get(i).getHigh());
                    }

                } else {
                    condensedZipCodeRangeList.add(temp_obj);
                    temp_obj = zipCodeRangeList.get(i);
                }
            }
            condensedZipCodeRangeList.add(temp_obj);
        }

    return condensedZipCodeRangeList;
    }

//Sorting with Comparator
    public static void sortRange(ArrayList<ZipCodeRange> rangeList) {
        Collections.sort(rangeList, new Comparator<ZipCodeRange>() {

            public int compare(ZipCodeRange range1, ZipCodeRange range2) {
                String low1 = String.valueOf(range1.getLow());
                String low2 = String.valueOf(range2.getLow());
                int comp = low1.compareTo(low2);

                if (comp != 0) {
                    return comp;
                } else {
                    String high1 = String.valueOf(((ZipCodeRange) range1).getHigh());
                    String high2 = String.valueOf(((ZipCodeRange) range2).getHigh());
                    return high1.compareTo(high2);
                }
            }
        });
    }
}

