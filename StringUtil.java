import java.security.MessageDigest;

public class StringUtil {
    public static String applySha256(String input) {
     try{
        MessageDigest digest= MessageDigest.getInstance("SHA-256");
        /*MEssageDigest is a java class that helps to create hash value and  "SHA-256" is hashing logorithm*/

        byte[] hash=digest.digest(input.getBytes("UTF-8"));


        
        StringBuffer hexString= new StringBuffer();//This will contain digital fingerprint
        for(int i=0;i<hash.length;i++){
            String hex= Integer.toHexString(0xff & hash[i]);
            if(hex.length()==1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();

     }catch(Exception e){
        throw new RuntimeException(e);
     }
    }
}
