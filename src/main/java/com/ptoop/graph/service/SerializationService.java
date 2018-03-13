package com.ptoop.graph.service;

import com.ptoop.graph.model.base.BaseFigure;

import java.io.*;
import java.util.List;

/**
 * @author: Alexey Storozhenko
 * @since: 13.03.2018
 */
public class SerializationService {

    private static final String filename = "figures.txt";

    //figure list serialization to text file
    public static void serializeFigures(List<BaseFigure> figures, String path) {
        if (figures.size() > 0) {
            System.out.println("Serialization of figures...");
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;
            try {
                fos = new FileOutputStream(new File(path + filename));
                oos = new ObjectOutputStream(fos);
                oos.writeObject(figures);
                oos.flush();
                oos.close();
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (oos != null) {
                    try {
                        oos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("Serialization completed.");
        } else {
            System.out.println("Figure list is empty");
        }
    }

    //deserialization from text file
    public static List<BaseFigure> deserializeFigures(String path) {
        System.out.println("Deserialization of figures...");
        List<BaseFigure> figures = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File(path + filename));
            ois = new ObjectInputStream(fis);
            figures = (List<BaseFigure>) ois.readObject();
            fis.close();
            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Deserialization completed.");
        return figures;
    }
}
