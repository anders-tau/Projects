package com.mycompany.IoC;

public class RockMusic implements Music {
    private RockMusic() {}

    public static RockMusic getRockMusic() {
        return new RockMusic();
    }

    public void initMethod() {
        System.out.println("Bean initialization");
    }

    public void destroyMethod() {
        System.out.println("Bean destroy");
    }

    @Override
    public String getSong() {
        return "Castle of Glass";
    }
}
