package com.ptoop.graph.service;

import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;
import com.ptoop.graph.model.base.BaseFigure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.io.File.separator;

/**
 * @author: Alexey Storozhenko
 * @since: 13.03.2018
 */

@Service
public class SerializationService {

    @Autowired
    ResourceLoader resourceLoader;

    //deserialization to yml file
    public void serializeFiguresYaml(List<BaseFigure> figures, String path) {
        if (figures.size() > 0) {
            System.out.println("Serialization of figures...");
            FileWriter fw = null;
            try {
                fw = new FileWriter(path);
                YamlWriter writer = new YamlWriter(fw);
                writer.write(figures);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Serialization completed.");
        } else {
            System.out.println("Figure list is empty");
        }
    }

    //deserialization from yml file
    public List<BaseFigure> deserializeFiguresYaml(String path) {
        System.out.println("Deserialization of figures...");
        List<BaseFigure> figures = new ArrayList<BaseFigure>();
        YamlReader reader = null;
        try {
            reader = new YamlReader(new InputStreamReader(new FileInputStream(new File(path))));
            figures = (reader.read(figures.getClass()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Deserialization completed.");
        if (figures == null) {
            figures = new ArrayList<>();
        }
        return figures;
    }

    //figure list serialization to text file
    public static void serializeFigures(List<BaseFigure> figures, String path) {
        if (figures.size() > 0) {
            System.out.println("Serialization of figures...");
            FileOutputStream fos = null;
            OutputStream buffer = null;
            ObjectOutputStream oos = null;
            try {
                fos = new FileOutputStream(new File(path));
                buffer = new BufferedOutputStream(fos);
                oos = new ObjectOutputStream(buffer);
                oos.writeObject(figures);
                oos.flush();
                buffer.close();
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
                if (buffer != null) {
                    try {
                        buffer.close();
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
        InputStream buffer = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File(path));
            buffer = new BufferedInputStream(fis);
            ois = new ObjectInputStream(buffer);
            figures = (List<BaseFigure>) ois.readObject();
            fis.close();
            buffer.close();
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
            if (buffer != null) {
                try {
                    buffer.close();
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
        if (figures == null) {
            figures = new ArrayList<>();
        }
        return figures;
    }
}
