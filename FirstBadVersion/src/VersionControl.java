public class VersionControl {
    private char [] products;

    public VersionControl() {
        this.products = new char []{' ', ' ', ' ', ' ', 'b', 'b'};
    }


    public boolean isBadVersion(int v) {
        if(v > this.products.length - 1) {
            return false;
        }
        else if(this.products[v] == 'b') {
            return true;
        }

        return false;
    }
}
