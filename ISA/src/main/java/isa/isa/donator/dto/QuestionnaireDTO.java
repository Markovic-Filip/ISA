package isa.isa.donator.dto;

public class QuestionnaireDTO {

    private String username;
    private Boolean q1;
    private Boolean q2;
    private Boolean q3;
    private Boolean q4;
    private Boolean q5;
    private Boolean q6;
    private Boolean q7;
    private Boolean q8;
    private Boolean q9;
    private Boolean q10;
    private Boolean q11;
    private Boolean q12;

    public QuestionnaireDTO(){}

    public QuestionnaireDTO(String username, Boolean q1, Boolean q2, Boolean q3, Boolean q4, Boolean q5, Boolean q6, Boolean q7, Boolean q8, Boolean q9, Boolean q10, Boolean q11, Boolean q12) {
        this.username = username;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
        this.q5 = q5;
        this.q6 = q6;
        this.q7 = q7;
        this.q8 = q8;
        this.q9 = q9;
        this.q10 = q10;
        this.q11 = q11;
        this.q12 = q12;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getQ1() {
        return q1;
    }

    public void setQ1(Boolean q1) {
        this.q1 = q1;
    }

    public Boolean getQ2() {
        return q2;
    }

    public void setQ2(Boolean q2) {
        this.q2 = q2;
    }

    public Boolean getQ3() {
        return q3;
    }

    public void setQ3(Boolean q3) {
        this.q3 = q3;
    }

    public Boolean getQ4() {
        return q4;
    }

    public void setQ4(Boolean q4) {
        this.q4 = q4;
    }

    public Boolean getQ5() {
        return q5;
    }

    public void setQ5(Boolean q5) {
        this.q5 = q5;
    }

    public Boolean getQ6() {
        return q6;
    }

    public void setQ6(Boolean q6) {
        this.q6 = q6;
    }

    public Boolean getQ7() {
        return q7;
    }

    public void setQ7(Boolean q7) {
        this.q7 = q7;
    }

    public Boolean getQ8() {
        return q8;
    }

    public void setQ8(Boolean q8) {
        this.q8 = q8;
    }

    public Boolean getQ9() {
        return q9;
    }

    public void setQ9(Boolean q9) {
        this.q9 = q9;
    }

    public Boolean getQ10() {
        return q10;
    }

    public void setQ10(Boolean q10) {
        this.q10 = q10;
    }

    public Boolean getQ11() {
        return q11;
    }

    public void setQ11(Boolean q11) {
        this.q11 = q11;
    }

    public Boolean getQ12() {
        return q12;
    }

    public void setQ12(Boolean q12) {
        this.q12 = q12;
    }
}
