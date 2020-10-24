package io.dsub.creational.singleton;

public class Singleton {

        private Singleton(){}

        private Singleton singleton = new Singleton();

        public Singleton getSingleton() {
            return singleton;
        }

        public static void main(String[] args){
            Singleton singletonRuntime = new Singleton();

            System.out.println(singletonRuntime);

            Singleton anotherInstance = new Singleton();

            System.out.println(anotherInstance);

            if (singletonRuntime == anotherInstance) {
                System.out.println("They are the same instance");
            }
        }


}
