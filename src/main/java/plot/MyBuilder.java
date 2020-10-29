package plot;

import javafx.util.Pair;
import javax.swing.*;
import java.util.ArrayList;
import java.io.*;
import java.awt.Color;

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
            int[] x = new int[50];
            int[] y = new int[50];

            for (int i = 0; i < 50; ++i) {
                x[i] = (int) (Math.random() * 50);
                y[i] = (int) (Math.random() * 50);
            }

            for (int i = 0; i < x.length; ++i) {
                fileWriter.write(Integer.toString(x[i]) + "\t" + Integer.toString(y[i]) + "\n");
            }

			fileWriter.close();
		} 
		catch (IOException exW) {
			System.out.println(exW.getMessage()); 
			return;
		}
    }
	//метод принимает на вход путь до файла и возвращает ArrayList, который хранит в себе классы Pair (этот класс существет в Java)
	//ArrayList хранит Pair; Pair хранит координаты
    public ArrayList<Pair<Integer, Integer>> functionLoader(String path) {
        ArrayList<Pair<Integer, Integer>> coords = new ArrayList<>();
        try (FileReader fileReader = new FileReader(path)) {
            BufferedReader reader = new BufferedReader(fileReader);

            String str = null;
            while ((str = reader.readLine()) != null) {
                String[] arrStr = str.split("\t");
                Pair<Integer, Integer> newPair = new Pair<>(Integer.parseInt(arrStr[0]),
                                                            Integer.parseInt(arrStr[1]));
                coords.add(newPair);
            }
            fileReader.close();
            reader.close();
        } 
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return coords;
    }
	//если panel == Null, то создать свой и вывести в него, если нет, то вывести в переданном
    public void plotPainter(ArrayList<Pair<Integer, Integer>> function, JPanel panel) {
        JFrame frame = new JFrame("plot");
        panel = new JPanel(); 
        JLabel label = new JLabel(function.toString()); 

        panel.setBackground(Color.black);
        frame.add(panel); 
        frame.add(label);
        frame.setSize(800, 800);

        frame.show(); 
    }
}