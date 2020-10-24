package io.dsub.creational.builder.fail;

/**
 * Problem of this class is..
 *
 * 1. we may or may not know whether the variables are present or null.
 * 2. getters and setters are all exposed; hence not immutable.
 * 3. it is unclear whether what is Required, or Not required (meaning mandate)
 *
 */

public class LunchOrderBean {
    private String bread;
    private String condiments;
    private String dressing;
    private String meat;

    public LunchOrderBean() {

    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public String getCondiments() {
        return condiments;
    }

    public void setCondiments(String condiments) {
        this.condiments = condiments;
    }

    public String getDressing() {
        return dressing;
    }

    public void setDressing(String dressing) {
        this.dressing = dressing;
    }

    public String getMeat() {
        return meat;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }
}
