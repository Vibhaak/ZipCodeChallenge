public class ZipCodeRange {
    int low;
    int high;

    ZipCodeRange(int low, int high) {
        this.low=low;
        this.high=high;
    }

    void setLow(int low) {
        this.low=low;
    }
    void setHigh(int high) {
        this.high=high;
    }

    int getLow(){
        return this.low;
    }

    int getHigh(){
        return this.high;
    }

}