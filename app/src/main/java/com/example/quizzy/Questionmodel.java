package com.example.quizzy;

public class Questionmodel {

    private  String question;
    private String optiona;

    private String optionb;
    private String optionc;
    private String optiond;
    private String coorectans;

    public Questionmodel(String question, String optiona, String optionb, String optionc, String optiond, String coorectans) {

        this.question = question;
        this.optiona = optiona;
        this.optionb = optionb;
        this.optionc = optionc;
        this.optiond = optiond;
        this.coorectans = coorectans;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptiona() {
        return optiona;
    }

    public void setOptiona(String optiona) {
        this.optiona = optiona;
    }

    public String getOptionb() {
        return optionb;
    }

    public void setOptionb(String optionb) {
        this.optionb = optionb;
    }

    public String getOptionc() {
        return optionc;
    }

    public void setOptionc(String optionc) {
        this.optionc = optionc;
    }

    public String getOptiond() {
        return optiond;
    }

    public void setOptiond(String optiond) {
        this.optiond = optiond;
    }

    public String getCoorectans() {
        return coorectans;
    }

    public void setCoorectans(String coorectans) {
        this.coorectans = coorectans;
    }
}
