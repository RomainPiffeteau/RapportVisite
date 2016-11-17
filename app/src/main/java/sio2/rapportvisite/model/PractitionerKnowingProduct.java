package sio2.rapportvisite.model;

import java.util.ArrayList;

public class
        PractitionerKnowingProduct {
    private int idVisit;
    private int idProduct;
    private int idPractitioner;
    private boolean knowing;
    private int prescriptionPercent;
    private String precisionsLess25Percent = "";
    private String precisionsMore75Percent = "";
    private int[] instructions;
    private String instructionsComment = "";
    private String productComment = "";

    public static ArrayList<PractitionerKnowingProduct> allPractitionerKnowingProduct = new ArrayList<>();

    public PractitionerKnowingProduct(int idVisit, int idProduct, int idPractitioner, boolean knowing, int prescriptionPercent, String precisionsLess25Percent, String precisionsMore75Percent, int[] instructions, String instructionsComment, String productComment) {
        this.idVisit = idVisit;
        this.idProduct = idProduct;
        this.idPractitioner = idPractitioner;
        this.knowing = knowing;
        this.prescriptionPercent = prescriptionPercent;
        this.precisionsLess25Percent = precisionsLess25Percent;
        this.precisionsMore75Percent = precisionsMore75Percent;
        this.instructions = instructions;
        this.instructionsComment = instructionsComment;
        this.productComment = productComment;
        allPractitionerKnowingProduct.add(this);
    }

    public boolean getKnowing(int idVisit){
        for(PractitionerKnowingProduct pkp : allPractitionerKnowingProduct){
            if(pkp.idVisit == idVisit)
                return pkp.knowing;
        }
        return false;
    }

    public int getPrescriptionPercent(int idVisit){
        for(PractitionerKnowingProduct pkp : allPractitionerKnowingProduct){
            if(pkp.idVisit == idVisit)
                return pkp.prescriptionPercent;
        }
        return -1;
    }

    public String getPrecisionsLess25Percent(int idVisit){
        for(PractitionerKnowingProduct pkp : allPractitionerKnowingProduct){
            if(pkp.idVisit == idVisit)
                return pkp.precisionsLess25Percent;
        }
        return "Less25PercentNoSuchId";
    }

    public String getPrecisionsMore75Percent(int idVisit){
        for(PractitionerKnowingProduct pkp : allPractitionerKnowingProduct){
            if(pkp.idVisit == idVisit)
                return pkp.precisionsMore75Percent;
        }
        return "More75PercentNoSuchId";
    }

    public Object[] getInstructionsOpinion(int idVisit){
        Object[] found = new Object[2];
        int[] idsInstructions = new int[1];
        idsInstructions[0] = -1;
        found[0] = idsInstructions;
        found[1] = "";
        for(PractitionerKnowingProduct pkp : allPractitionerKnowingProduct){
            if(pkp.idVisit == idVisit){
                found[0] = pkp.instructions;
                found[1] = instructionsComment;
            }
        }
        return found;
    }

    public String getProductComment(int idVisit){
        for(PractitionerKnowingProduct pkp : allPractitionerKnowingProduct){
            if(pkp.idVisit == idVisit)
                return pkp.productComment;
        }
        return "ProductCommentNoSuchId";
    }
}
