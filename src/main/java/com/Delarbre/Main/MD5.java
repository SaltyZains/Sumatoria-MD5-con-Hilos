package com.Delarbre.Main;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MD5 {

    public static String convertirPathArchivo(String path) {
        File archivo = new File(path);
        return obtenerMD5(archivo);
    }

    public static String obtenerMD5(File archivo) {
        String md5 = null;
        FileInputStream entradaArchivo = null;
        try {
            entradaArchivo = new FileInputStream(archivo);

            // md5Hex converts an array of bytes into an array of characters representing the hexadecimal values of each byte in order.
            // The returned array will be double the length of the passed array, as it takes two characters to represent any given byte.
            md5 = DigestUtils.md5Hex(IOUtils.toByteArray(entradaArchivo));
        } catch (IOException e) {
            System.out.println("Error: " + e);
        } finally {
            IOUtils.closeQuietly(entradaArchivo);
        }
        return md5;
    }
}
