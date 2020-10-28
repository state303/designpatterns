package io.dsub.behavioral.iterator.example;

import java.util.Iterator;

public class BikeRepository implements Iterable<String> {
    private String[] bikes;
    private int index;

    public BikeRepository() {
        bikes = new String[10];
        index = 0;
    }

    public void addBike(String bike) {
        if (index == bike.length()) {
            String[] longer = new String[bikes.length + 5];
            System.arraycopy(bikes, 0, longer, 0, bikes.length);
            bikes = longer;
        }

        bikes[index] = bike;
        index++;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<>() {
            private int currIndex = 0;
            @Override
            public boolean hasNext() {
                return currIndex < bikes.length && bikes[currIndex] != null;
            }

            @Override
            public String next() {
                return bikes[currIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("remove is not yet implemented");
            }
        };
    }
}
