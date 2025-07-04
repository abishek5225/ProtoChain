import java.util.Date;

public class Block{

    public String hash;
    public String previousHash;
    private String data;
    private long timeStamp;
    private int nonce;

    //block constructor
    public Block(String data, String previousHash){
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculatedHash();
    }

    public String calculatedHash(){
        String calculatedhash = StringUtil.applySha256(
            previousHash + Long.toString(timeStamp)+ Integer.toString(nonce)+ data
        );
        return calculatedhash;
    }
    public void mineBlock(int difficulty){
        String target = new String(new char[difficulty]).replace('\0', '0');
        while (!hash.substring(0,difficulty).equals(target)) {
            nonce ++;
            hash= calculatedHash();
        }
        System.out.println("Blocked MIned: "+hash);
    }


}