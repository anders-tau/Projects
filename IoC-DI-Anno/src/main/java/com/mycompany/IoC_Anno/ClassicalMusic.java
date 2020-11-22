package com.mycompany.IoC_Anno;

import org.springframework.stereotype.Component;

@Component
public class ClassicalMusic implements Music {
    @Override
    public String getSong() {
        return "Fur Elise";
    }
}
