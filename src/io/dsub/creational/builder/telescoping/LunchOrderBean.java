package io.dsub.creational.builder.telescoping;

/**
 * now it has telescoped constructor.
 * as this telescoping may look viable, but what if i don't want bread?
 * now we have to make all the possible constructors.
 * and is not good at all.
 *
 * but is better than fail model, as it is now immutable.
 */
public class LunchOrderBean {
    private String bread;
    private String condiments;
    private String dressing;
    private String meat;

    public LunchOrderBean(String bread) {
        this.bread = bread;
    }

    public LunchOrderBean(String bread, String condiments) {
        this(bread);
        this.condiments = condiments;
    }

    public LunchOrderBean(String bread, String condiments, String dressing) {
        this(bread, condiments);
        this.dressing = dressing;
    }

    public LunchOrderBean(String bread, String condiments, String dressing, String meat) {
        this(bread, condiments, dressing);
        this.meat = meat;
    }

    public String getBread() {
        return bread;
    }

    public String getCondiments() {
        return condiments;
    }

    public String getDressing() {
        return dressing;
    }

    public String getMeat() {
        return meat;
    }
}
