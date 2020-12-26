
package brain.controller;

import com.sun.jna.platform.win32.Advapi32Util;
import static com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Brain
 */
public class ReadKeys
{
    private String server,user,password,database;
    private int bitTemporisation;    
    private static final String maCle = "futhsftersopiu78";

    public String getServer() {
        return server;
    }

   
    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getDatabase() {
        return database;
    }

    

    public int getBitTemporisation() {
        return bitTemporisation;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    
    public void setBitTemporisation(int bitTemporisation) {
        this.bitTemporisation = bitTemporisation;
    }

    public ReadKeys() throws Exception 
    {
        try 
        {
            SecretKey mKey = new SecretKeySpec(maCle.getBytes(), "AES");
            Cipher Decryp = Cipher.getInstance("AES");
            Decryp.init(Cipher.DECRYPT_MODE, mKey);
            
            if(!"".equals(getServer()) | !"".equals(getUser()) | !"".equals(getPassword()) | !"".equals(getDatabase()))
            {
                byte[] s = new sun.misc.BASE64Decoder().decodeBuffer(Advapi32Util.registryGetStringValue(HKEY_CURRENT_USER, "Software\\brain_purch\\Donnees", "server"));
                byte[] serv = Decryp.doFinal(s);
                setServer(new String(serv,"UTF-8"));
                
                byte[] us = new sun.misc.BASE64Decoder().decodeBuffer(Advapi32Util.registryGetStringValue(HKEY_CURRENT_USER, "Software\\brain_purch\\Donnees", "user"));
                byte[] usr = Decryp.doFinal(us);
                setUser(new String(usr,"UTF-8"));
                
                byte[] pw = new sun.misc.BASE64Decoder().decodeBuffer(Advapi32Util.registryGetStringValue(HKEY_CURRENT_USER, "Software\\brain_purch\\Donnees", "password"));
                byte[] pd = Decryp.doFinal(pw);
                setPassword(new String(pd,"UTF-8"));
                
                byte[] bs = new sun.misc.BASE64Decoder().decodeBuffer(Advapi32Util.registryGetStringValue(HKEY_CURRENT_USER, "Software\\brain_purch\\Donnees", "database"));
                byte[] data = Decryp.doFinal(bs);
                setDatabase(new String(data,"UTF-8"));               
                
            }
            else 
            {
                throw new Exception("L'un des fichiers de configuration est vide. Soit votre configuration n'est pas finie");
            }
        }
        catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e) 
        {
            throw new Exception("Erreur lors de la lecture des fichiers");
        }
    }    
}