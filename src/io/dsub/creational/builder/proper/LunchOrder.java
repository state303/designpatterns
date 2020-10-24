package io.dsub.creational.builder.proper;

/**
 * now it has telescoped constructor.
 * as this telescoping may look viable, but what if i don't want bread?
 * now we have to make all the possible constructors.
 * and is not good at all.
 *
 * but is better than fail model, as it is now immutable.
 */
public class LunchOrder {

    /**
     * Builder has its own container to determine what to make.
     */
    public static class Builder {
        private String bread;
        private String condiments;
        private String dressing;
        private String meat;

        // you can restrict stuffs in here
        public Builder() {

        }

        public LunchOrder build() {
            return new LunchOrder(this);
        }

        public Builder bread(String bread) {
            this.bread = bread;
            return this;
        }

        public Builder condiments(String condiments) {
            this.condiments = condiments;
            return this;
        }

        public Builder dressing(String dressing) {
            this.dressing = dressing;
            return this;
        }

        public Builder meat(String meat) {
            this.meat = meat;
            return this;
        }
    }

    private final String bread;
    private final String condiments;
    private final String dressing;
    private final String meat;

    private LunchOrder(Builder builder) {
        this.bread = builder.bread;
        this.condiments = builder.condiments;
        this.dressing = builder.dressing;
        this.meat = builder.meat;
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
