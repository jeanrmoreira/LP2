public class ElipseApp {
    public static void main (String[] args) {
        Elip el1 = new Elip(30,30, 40,20);
        el1.print();
    }
}
class Elip {
    int x, y;
    int rx, ry;
    Elip (int x, int y, int rx, int ry) {
        this.x = x;
        this.y = y;
        this.rx = rx;
        this.ry = ry;
    }
    void print () {
        System.out.format("Elipse de raio horizontal (%d) e raio vertical (%d) na posicao (%d,%d).\n",
            this.rx, this.ry, this.x, this.y);
    }
}
