package org.problems.patterns;

public final class Singelton {

    private static volatile Singelton instance = null;

    private Singelton() {
    }

    public static Singelton getInstance() {
        if (instance == null) {
            synchronized (Singelton.class) {
                if (instance == null) {
                    instance = new Singelton();
                }
            }
        }
        return instance;
    }
}
