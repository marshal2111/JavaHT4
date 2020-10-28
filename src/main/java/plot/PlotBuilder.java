package plot;

import javafx.util.Pair;
import javax.swing.*;
import java.util.ArrayList;
import java.io.*;

public interface PlotBuilder {
	//метод принимает путь до файла
	//создает новый файл и записывает или записывает в существующий файл, если имеется, координаты в виде X	Y (два столбика. XтабуляцияY)
    void functionGenerator(String path);
	//метод принимает на вход путь до файла и возвращает ArrayList, который хранит в себе классы Pair (этот класс существет в Java)
	//ArrayList хранит Pair; Pair хранит координаты
    ArrayList<Pair<Integer, Integer>> functionLoader(String path);
	//если panel == Null, то создать свой и вывести sв него, если нет, то вывести в переданном
    //void plotPainter(ArrayList<Pair<Integer, Integer>> function, JPanel panel);
}
