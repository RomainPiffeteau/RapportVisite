package sio2.rapportvisite.model;

import java.util.ArrayList;


public class PractitionerKnowingProduct {

    private int idPractitioner;
    private int idProduct;
    private boolean knowing;
    private int presc;
    private String presc25 = "";
    private String presc75 = "";
    private int[] instructions;
    private String instructionsComment = "";
    private String productComment = "";

    public static ArrayList<PractitionerKnowingProduct> allPractitionerKnowingProduct;
    public static void reset(){ allPractitionerKnowingProduct = new ArrayList<>(); }

    public PractitionerKnowingProduct(int idPractitioner, int idProduct, boolean knowing, int presc, String presc75, int[] instructions, String instructionsComment, String productComment, String presc25) {
        this.idPractitioner = idPractitioner;
        this.idProduct = idProduct;
        this.knowing = knowing;
        this.presc = presc;
        this.presc75 = presc75;
        this.instructions = instructions;
        this.instructionsComment = instructionsComment;
        this.productComment = productComment;
        this.presc25 = presc25;
        allPractitionerKnowingProduct.add(this);
    }

    public boolean isKnowing() {
        return knowing;
    }

    public int getPresc() {
        return presc;
    }

    public String getPresc25() {
        return presc25;
    }

    public String getPresc75() {
        return presc75;
    }

    public int[] getInstructions() {
        return instructions;
    }

    public String getInstructionsComment() {
        return instructionsComment;
    }

    public String getProductComment() {
        return productComment;
    }

    public PractitionerKnowingProduct getPractitionerKnowingProduct(int idPractitioner, int idProduct){
        for(PractitionerKnowingProduct pkp : allPractitionerKnowingProduct){
            if(pkp.idPractitioner == this.idPractitioner && pkp.idProduct == this.idProduct)
                return pkp;
        }
        return null;
    }
}
