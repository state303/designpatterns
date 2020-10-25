package io.dsub.structural.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SecurityProxy implements InvocationHandler {

    private final TwitterService service;

    public SecurityProxy(TwitterService service) {
        this.service = service;
    }

    public static TwitterService newInstance(TwitterService service) {
        return (TwitterService) java.lang.reflect.Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), new SecurityProxy(service));
    }

    /*
    Now we do not have to provide any auditing and security related things among business logic.
    We can simplify the business logics.
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        try {
            System.out.println("i am checking....");
            // we can actually restrict something...like...
            if (method.getName().matches("[p|P][o|O][s|S][t|T]")) {
                throw new IllegalAccessException("Posts are currently not allowed");
            }
            for (Object o : args) {
                if (o instanceof String) {
                    if (((String) o).matches("[p|P][o|O][s|S][t|T]")) {
                        throw new IllegalAccessException("Posts are currently not allowed");
                    }
                }
            }
            result = method.invoke(service, args);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (Exception e) {
            throw new RuntimeException("unexpected invocation exception: " + e.getMessage());
        }
        return result;
    }
}
