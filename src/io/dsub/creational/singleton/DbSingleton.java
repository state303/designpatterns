package io.dsub.creational.singleton;

public class DbSingleton {


    // eager loading
    // private static DbSingleton instance = new DbSingleton();

    // lazy loading
    // volatile means to have the instance to be in shared heap memory among many threads
    private static volatile DbSingleton instance = null;

    private DbSingleton(){
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to create");
        }
    }

    // this is lazy loading method... :)
    // this really helps performance improvement
    public static DbSingleton getInstance() {
        if (instance == null) {
            synchronized (DbSingleton.class) {
                // double check if it is REALLY the first time being called.
                // but this will add some overhead.
                if (instance == null) {
                    instance = new DbSingleton();
                }
            }
        }
        return instance;
    }
}
