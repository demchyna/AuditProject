package edu.project.yevhenaudit.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "indicator_1", nullable = false)
    private double indicator1;

    @Column(name = "indicator_2", nullable = false)
    private double indicator2;

    @Column(name = "indicator_3", nullable = false)
    private double indicator3;

    @Column(name = "indicator_4", nullable = false)
    private double indicator4;

    @Column(name = "indicator_5", nullable = false)
    private double indicator5;

    @Column(name = "indicator_6", nullable = false)
    private double indicator6;

    @Column(name = "energy_efficiency")
    @Enumerated(EnumType.STRING)
    private EnergyEfficiency  energyEfficiency;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    public Report() {
    }

    public Report(double indicator1, double indicator2, double indicator3, double indicator4, double indicator5, double indicator6, EnergyEfficiency energyEfficiency) {
        this.indicator1 = indicator1;
        this.indicator2 = indicator2;
        this.indicator3 = indicator3;
        this.indicator4 = indicator4;
        this.indicator5 = indicator5;
        this.indicator6 = indicator6;
        this.energyEfficiency = energyEfficiency;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getIndicator1() {
        return indicator1;
    }

    public void setIndicator1(double indicator1) {
        this.indicator1 = indicator1;
    }

    public double getIndicator2() {
        return indicator2;
    }

    public void setIndicator2(double indicator2) {
        this.indicator2 = indicator2;
    }

    public double getIndicator3() {
        return indicator3;
    }

    public void setIndicator3(double indicator3) {
        this.indicator3 = indicator3;
    }

    public double getIndicator4() {
        return indicator4;
    }

    public void setIndicator4(double indicator4) {
        this.indicator4 = indicator4;
    }

    public double getIndicator5() {
        return indicator5;
    }

    public void setIndicator5(double indicator5) {
        this.indicator5 = indicator5;
    }

    public double getIndicator6() {
        return indicator6;
    }

    public void setIndicator6(double indicator6) {
        this.indicator6 = indicator6;
    }

    public EnergyEfficiency getEnergyEfficiency() {
        return energyEfficiency;
    }

    public void setEnergyEfficiency(EnergyEfficiency energyEfficiency) {
        this.energyEfficiency = energyEfficiency;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Report {" +
                "id = " + id +
                ", indicator1 = " + indicator1 +
                ", indicator2 = " + indicator2 +
                ", indicator3 = " + indicator3 +
                ", indicator4 = " + indicator4 +
                ", indicator5 = " + indicator5 +
                ", indicator6 = " + indicator6 +
                ", energyEfficiency = " + energyEfficiency +
                ", owner = " + owner +
                " }";
    }
}
