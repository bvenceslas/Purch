
package brain.controller;

import com.sun.jna.platform.win32.Advapi32Util;
import static com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Brain
 */
public class ConfigurationServeur 
{
    private String serverName, serverUser, serverPassword, confirPassword,databaseName;
    private final String Cle_Cryptage = "futhsftersopiu78";
    private static Cipher Crypt;
    SecretKey myKey = new SecretKeySpec(Cle_Cryptage.getBytes(), "AES");
    
    public String getServerName() {
        return serverName;
    }

    public String getServerUser() {
        return serverUser;
    }

    public String getServerPassword() {
        return serverPassword;
    }
    
    public String getConfirPassword() {
        return confirPassword;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public void setServerUser(String serverUser) {
        this.serverUser = serverUser;
    }

    public void setServerPassword(String serverPassword) {
        this.serverPassword = serverPassword;
    }
    
    public void setConfirPassword(String confirPassword) {
        this.confirPassword = confirPassword;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }
    
    public boolean ToValide_String(String input) throws Exception 
    {
        if (!input.equals("")) 
        {
            char[] monText = input.toCharArray();
            for (int i = 0; i < monText.length; i++) 
            {
                if (monText[i]=='/' | monText[i]=='\\' | monText[i]=='<' | monText[i]=='>' | monText[i]=='(' | monText[i]==')'
                        | monText[i]=='%' | monText[i]=='$' | monText[i]=='@' | monText[i]=='#' | monText[i]=='*' | monText[i]=='-' | monText[i]=='='
                        | monText[i]=='!' | monText[i]=='`' | monText[i]=='~' | monText[i]=='[' | monText[i]==']' | monText[i]=='{' | monText[i]=='}'
                        | monText[i]=='&' | monText[i]=='^') 
                {                      
                    throw new Exception("Erreur: un caractère non valide trouvé");
                }
            }
        }
        return true;        
    }
    
    public boolean creationDossier() throws Exception
    {
        try 
        {
            if(!Advapi32Util.registryKeyExists(HKEY_CURRENT_USER, "Software\\brain_purch"))
            {
                Advapi32Util.registryCreateKey(HKEY_CURRENT_USER, "Software\\brain_purch");
                Advapi32Util.registryCreateKey(HKEY_CURRENT_USER, "Software\\brain_purch\\Donnees");
            }
            else
            {
                if(!Advapi32Util.registryKeyExists(HKEY_CURRENT_USER, "Software\\brain_purch\\Donnees"))
                    Advapi32Util.registryCreateKey(HKEY_CURRENT_USER, "Software\\brain_purch\\Donnees");
            }
            return true;
        } 
        catch (Exception e) 
        {
            throw new Exception("Erreur lors de la création des dossiers");
        }   
    }
    
    private boolean Config() throws UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, Exception
    {
        String servername, username, password, database;
        try 
        {
            Crypt = Cipher.getInstance("AES");
            Crypt.init(Cipher.ENCRYPT_MODE, myKey);            
            // Cryptage de valeurs
            byte[] server = getServerName().getBytes("UTF-8");
            byte[] svr = Crypt.doFinal(server);
            servername = new sun.misc.BASE64Encoder().encode(svr);
            
            byte[] user = getServerUser().getBytes("UTF-8");
            byte[] userN = Crypt.doFinal(user);
            username = new sun.misc.BASE64Encoder().encode(userN);
            
            byte[] pass = getServerPassword().getBytes("UTF-8");
            byte[] passw = Crypt.doFinal(pass);
            password = new sun.misc.BASE64Encoder().encode(passw);
            
            byte[] data = getDatabaseName().getBytes("UTF-8");
            byte[] databas = Crypt.doFinal(data);
            database = new sun.misc.BASE64Encoder().encode(databas);
            
            Advapi32Util.registrySetStringValue(HKEY_CURRENT_USER, "Software\\brain_purch\\Donnees", "server", servername);
            Advapi32Util.registrySetStringValue(HKEY_CURRENT_USER, "Software\\brain_purch\\Donnees", "user", username);
            Advapi32Util.registrySetStringValue(HKEY_CURRENT_USER, "Software\\brain_purch\\Donnees", "password", password);
            Advapi32Util.registrySetStringValue(HKEY_CURRENT_USER, "Software\\brain_purch\\Donnees", "database", database);
         
            return true;
        } 
        catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e) 
        {
            throw new Exception("Erreur de chiffrement AES");
        }
    }
    
    public boolean Configuration() throws Exception
    {
        try 
        {
            if(creationDossier())
            {
                if(Config())
                {
                    return true;
                }
            }
        } 
        catch (Exception e)
        {
            throw new Exception(e.getMessage());
        }
        return false;        
    }
}