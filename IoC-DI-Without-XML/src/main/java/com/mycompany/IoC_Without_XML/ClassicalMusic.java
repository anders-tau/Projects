package com.mycompany.IoC_Without_XML;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class ClassicalMusic implements Music {
    @PostConstruct
    public void InitMethod() { System.out.println("Bean initialization"); }

    @PreDestroy
    public void DestroyMethod() {
        System.out.println("Bean destroy");
    }

    @Override
    public String getSong() {
        return "Fur Elise";
    }
}
