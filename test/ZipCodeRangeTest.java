class ZipCodeRangeTest {

	@Test
	void condenseZipCodeRangeListTest()
       {	
               ArrayList<ZipCodeRangeList> input = {"(91100,91200)", "(91150,91250)", "(91116,91231)","(94566,94566)","(94538,94568)"};
	        ZipCodeRange obj= new ZipCodeRange();
                ArrayList<ZipCodeRange>expected = {"(91100,91250)", "(94538,94568)"};
		assertArrayEquals(expected, obj.condenseZipCodeRangeList(input));
	}
	

}

