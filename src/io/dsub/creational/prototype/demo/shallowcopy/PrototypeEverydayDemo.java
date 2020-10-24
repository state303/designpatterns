package io.dsub.creational.prototype.demo.shallowcopy;

import java.util.ArrayList;
import java.util.List;

/**
 * this example shows how the shallow clone being made.
 * as of the shallow copy literally shares the same object instance,
 * it is considered to be a dangerous operation.
 *
 * now, it you change secondStatement by any means,
 * the firstStatement will share the same changes that
 * being made to the secondStatement.
 */
public class PrototypeEverydayDemo {
    public static void main(String[] args) {
        String sql = "SELECT * FROM movies WHERE title = whatever";
        List<String> parameters = new ArrayList<>();
        parameters.add("Star wars");
        Record record = new Record();

        Statement firstStatement = new Statement(sql, parameters, record);

        System.out.println(firstStatement.getSql());
        System.out.println(firstStatement.getParameters());
        System.out.println(firstStatement.getRecord());

        Statement secondStatement = firstStatement.clone();

        System.out.println(secondStatement.getSql());
        System.out.println(secondStatement.getParameters());
        System.out.println(secondStatement.getRecord());
    }
}
