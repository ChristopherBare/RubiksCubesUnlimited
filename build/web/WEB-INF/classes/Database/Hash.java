/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Christopher
 */
public class Hash {
    
    public static String SHA_256(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return DatatypeConverter.printHexBinary( 
           MessageDigest.getInstance("SHA-256").digest(text.getBytes("UTF-8")));
    }
    
}