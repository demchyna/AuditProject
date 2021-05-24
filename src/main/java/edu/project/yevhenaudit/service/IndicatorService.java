package edu.project.yevhenaudit.service;

import edu.project.yevhenaudit.dto.Indicator;
import edu.project.yevhenaudit.model.EnergyEfficiency;
import edu.project.yevhenaudit.model.Report;
import org.springframework.stereotype.Service;

@Service
public class IndicatorService {

    public Report calculate(Indicator indicator) {

        double Qh_nd = indicator.getParameter1();
        double Qc_nd = indicator.getParameter2();
        double Qdhw_nd = indicator.getParameter3();
        double Af = indicator.getParameter4();
        double Qh_use = indicator.getParameter5();
        double Qc_use = indicator.getParameter6();
        double Qdhw_use = indicator.getParameter7();
        double Qv_use = indicator.getParameter8();
        double Wuse = indicator.getParameter9();
        int n = indicator.getParameter10();

        double EN = (Qh_nd + Qc_nd + Qdhw_nd) / Af;
        double EPh_use = Qh_use / Af;
        double EPc_use = Qc_use / Af;
        double EPdhw_use = Qdhw_use / Af;
        double EPv_use = Qv_use / Af;
        double EPw_use = Wuse / Af;

        int EPp = 0;

        if (n >= 1 && n < 4) EPp = 120;
        if (n >= 4 && n < 9) EPp = 85;
        if (n >= 10 && n < 16) EPp = 75;
        if (n >= 17) EPp = 70;

        double Cenergy = ((EPh_use + EPc_use) - EPp) / EPp * 100;
        EnergyEfficiency energyEfficiency = null;

        if (Cenergy < -50)  energyEfficiency = EnergyEfficiency.A;
        if (Cenergy >= -50 && Cenergy < -20)  energyEfficiency = EnergyEfficiency.B;
        if (Cenergy >= -20 && Cenergy <= 0)  energyEfficiency = EnergyEfficiency.C;
        if (Cenergy > 0 && Cenergy <= 20)  energyEfficiency = EnergyEfficiency.D;
        if (Cenergy > 20 && Cenergy <= 35)  energyEfficiency = EnergyEfficiency.E;
        if (Cenergy > 35 && Cenergy <= 50)  energyEfficiency = EnergyEfficiency.F;
        if (Cenergy > 50)  energyEfficiency = EnergyEfficiency.G;

        return new Report(EN, EPh_use, EPc_use, EPdhw_use, EPv_use, EPw_use, energyEfficiency);
    }
}
