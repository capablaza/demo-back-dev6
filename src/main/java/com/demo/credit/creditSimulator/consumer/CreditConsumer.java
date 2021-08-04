package com.demo.credit.creditSimulator.consumer;

import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
public class CreditConsumer {

    private String name;
    private String email;
    private Integer amount;
    private Integer quotas;
    private Integer income;

    private Map<String, Ranges> amountRanges;
    private Map<String, Ranges> quotasRanges;
    private Map<String, Ranges> incomeRanges;

    List<SimulationRule> rules = new ArrayList<>();

    public CreditConsumer(@NonNull String name, @NonNull String email, @NonNull Integer amount, @NonNull Integer quotas, @NonNull Integer income) {
        this.name = name;
        this.email = email;
        this.amount = amount;
        this.quotas = quotas;
        this.income = income;
    }

    private void prepareRanges() {
        rules.add(new SimulationRule(100000, 1000000, 3, 36, 300000, 1000000));
        //rules.add(new SimulationRule(100000, 3000000, 3, 36, 500000, 1000000));
        //rules.add(new SimulationRule(300000, 5000000, 13, 36, 500000, 1000000));
    }

    public boolean evaluate() {
        this.prepareRanges();

        for (SimulationRule rule : rules) {
            if (rule.check(amount, quotas, income)) {
                return true;
            }
        }

        return false;
    }
/*
    public boolean evaluation(){
        int amount = 150000;
        int quotas = 13;
        int incomes = 650000;

        if(amount >= 100000 && amount <= 1000000 && quotas >= 3 && quotas <= 36 && incomes >= 300000 && incomes <= 1000000){
            return true;
        }else if(amount >= 1000000 && amount <= 3000000 && quotas >= 3 && quotas <= 36 && incomes >= 500000 && incomes <= 1000000){
            return true;
        }else if(amount >= 3000000 && amount <= 5000000 && quotas >= 13 && quotas <= 36 && incomes >= 500000 && incomes <= 1000000){
            return true;
        }else if(amount >= 7000000 && amount <= 9000000 && quotas >= 13 && quotas <= 36 && incomes >= 500000 && incomes <= 1000000){
            return true;
        }

        return false;
    }
*/
}
