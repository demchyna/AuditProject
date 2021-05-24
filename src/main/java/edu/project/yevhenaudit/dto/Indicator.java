package edu.project.yevhenaudit.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Indicator {

    @NotBlank(message = "Введіть коректну адресу досліджуваного об'єкта")
    private String address;
    private double parameter1;
    private double parameter2;
    private double parameter3;
    private double parameter4;
    private double parameter5;
    private double parameter6;
    private double parameter7;
    private double parameter8;
    private double parameter9;
    private int parameter10;

    public Indicator() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getParameter1() {
        return parameter1;
    }

    public void setParameter1(double parameter1) {
        this.parameter1 = parameter1;
    }

    public double getParameter2() {
        return parameter2;
    }

    public void setParameter2(double parameter2) {
        this.parameter2 = parameter2;
    }

    public double getParameter3() {
        return parameter3;
    }

    public void setParameter3(double parameter3) {
        this.parameter3 = parameter3;
    }

    public double getParameter4() {
        return parameter4;
    }

    public void setParameter4(double parameter4) {
        this.parameter4 = parameter4;
    }

    public double getParameter5() {
        return parameter5;
    }

    public void setParameter5(double parameter5) {
        this.parameter5 = parameter5;
    }

    public double getParameter6() {
        return parameter6;
    }

    public void setParameter6(double parameter6) {
        this.parameter6 = parameter6;
    }

    public double getParameter7() {
        return parameter7;
    }

    public void setParameter7(double parameter7) {
        this.parameter7 = parameter7;
    }

    public double getParameter8() {
        return parameter8;
    }

    public void setParameter8(double parameter8) {
        this.parameter8 = parameter8;
    }

    public double getParameter9() {
        return parameter9;
    }

    public void setParameter9(double parameter9) {
        this.parameter9 = parameter9;
    }

    public int getParameter10() {
        return parameter10;
    }

    public void setParameter10(int parameter10) {
        this.parameter10 = parameter10;
    }
}
