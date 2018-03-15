package com.ptoop.graph.service;

import com.ptoop.graph.model.base.BaseFigure;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static java.io.File.separator;

/**
 * @author: Alexey Storozhenko
 * @since: 15.03.2018
 */
public class CryptoService {

    private static final SecretKey key = new SecretKeySpec("1234123412341234".getBytes(), "AES");
    private static final IvParameterSpec IV = new IvParameterSpec(new byte[] { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06,
                                                                0x07, 0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f });
    protected final String serialPath;
    protected Cipher encryptCipher = null;
    protected Cipher decryptCipher = null;

    public CryptoService () {
        try {
            encryptCipher = Cipher.getInstance("AES/CFB8/NoPadding");
            encryptCipher.init(Cipher.ENCRYPT_MODE, key, IV);
            decryptCipher = Cipher.getInstance("AES/CFB8/NoPadding");
            decryptCipher.init(Cipher.DECRYPT_MODE, key, IV);
        } catch (Exception e) {
            e.printStackTrace();
        }
        serialPath = prepareSerialPath();
    }

    private static String prepareSerialPath() {
        String serialPath = System.getProperty("user.dir") + separator + "serialized";
        if (!serialPath.endsWith(separator)) {
            serialPath = serialPath.concat(separator);
        }
        final File directory = new File(serialPath);
        if (!directory.exists()) {
            directory.mkdir();
        }
        return serialPath + "encr_figures.txt";
    }

    public void encryptAndSerializeFigures(List<BaseFigure> figures) {
        if (encryptCipher != null) {
            if (figures.size() > 0) {
                System.out.println("CryptoSerialization of figures...");
                try {
                    OutputStream out = new FileOutputStream(new File(serialPath));
                    out = new CipherOutputStream(out, encryptCipher);
                    ObjectOutputStream oos = new ObjectOutputStream(out);
                    oos.writeObject(figures);
                    out.flush();
                    out.close();
                    oos.close();
                } catch (java.io.IOException ex) {
                    System.out.println("Exception: " + ex.getMessage());
                }
                System.out.println("CryptoSerialization completed.");
            } else {
                System.out.println("Figure list is empty");
            }
        } else {
            System.out.println("Encryption key was not initialized");
        }

    }

    //deserialization from text file
    public List<BaseFigure> decryptAndDeserializeFigures() {
        List<BaseFigure> figures = null;
        if (decryptCipher != null) {
            System.out.println("CryptoDeserialization of figures...");

            FileInputStream fis = null;
            InputStream buffer = null;
            ObjectInputStream ois = null;
            try {
                fis = new FileInputStream(new File(serialPath));
                buffer = new BufferedInputStream(fis);
                buffer = new CipherInputStream(buffer, decryptCipher);
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
            System.out.println("CryptoDeserialization completed.");
        } else {
            System.out.println("Decryption key was not initialized");
        }
        if (figures == null) {
            figures = new ArrayList<>();
        }
        return figures;
    }
}
