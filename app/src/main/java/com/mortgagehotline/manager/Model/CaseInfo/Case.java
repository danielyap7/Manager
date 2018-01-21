package com.mortgagehotline.manager.Model.CaseInfo;


public class Case {

    private String L1;
    private String L2;
    private String L3;
    private String R1;
    private String R2;

    public Case(String L1, String L2, String L3, String R1, String R2) {

        this.L1 = L1;

        this.L2 = L2;

        this.L3 = L3;

        this.R1 = R1;

        this.R2 = R2;

    }

    public String getL1() {
        return L1;
    }

    public void setL1(String l1) {
        this.L1 = l1;
    }

    public String getL2() {
        return L2;
    }

    public void setL2(String l2) {
        this.L2 = l2;
    }

    public String getL3() {
        return L3;
    }

    public void setL3(String l3) {
        L3 = l3;
    }

    public String getR1() {
        return R1;
    }

    public void setR1(String r1) {
        R1 = r1;
    }

    public String getR2() {
        return R2;
    }

    public void setR2(String r2) {
        R2 = r2;
    }


}
