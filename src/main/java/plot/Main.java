package plot;

import javafx.util.Pair;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PlotBuilder builder = new MyBuilder();

        builder.functionGenerator("test.txt");
        ArrayList<Pair<Integer, Integer>> XY = builder.functionLoader("test.txt");
        //builder.plotPainter(XY, null);
    }
}
