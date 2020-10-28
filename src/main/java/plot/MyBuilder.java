package plot;

import javax.swing.*;
import java.util.ArrayList;
import java.io.*;

public class MyBuilder implements PlotBuilder{
	//метод принимает путь до файла
	//создает новый файл и записывает или записывает в существующий файл, если имеется, координаты в виде X	Y (два столбика. XтабуляцияY)
    public void functionGenerator(String path) {
    	try  {
    		File file = new File(path);
    		if (!file.exists())
				file.createNewFile();
    	}
    	catch (IOException exF) {
    		System.out.println(exF.getMessage());
    		return;
    	}

    	try (FileWriter fileWriter = new FileWriter(path)) {

			fileWriter.close();
		} 
		catch (IOException exW) {
			System.out.println(exW.getMessage()); 
			return;
		}
    }
	//метод принимает на вход путь до файла и возвращает ArrayList, который хранит в себе классы Pair (этот класс существет в Java)
	//ArrayList хранит Pair; Pair хранит координаты
    public ArrayList<Pair<Integer, Integer>> functionLoader(File file) {

    };
	//если panel == Null, то создать свой и вывести в него, если нет, то вывести в переданном
    public void plotPainter(ArrayList<Pair<Integer, Integer>> function, JPanel panel) {
        
    };
}