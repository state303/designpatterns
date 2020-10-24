package io.dsub.creational.builder.fail;

public class LunchOrderBeanDemo {
    public static void main(String[] args) {
        LunchOrderBean lunchOrderBean = new LunchOrderBean();

        // see, not immutable.
        // now we cannot signify what makes a valid LunchOrderBean.
        // we have no idea what our order should be.
        // it will work without the setters below, but that is not the issue.
        // the issue is, what is it to be a valid one to signify the contract.

//        lunchOrderBean.setBread("Wheat");
//        lunchOrderBean.setCondiments("Lettuce");
//        lunchOrderBean.setDressing("Mustard");
//        lunchOrderBean.setMeat("Ham");

        System.out.println(lunchOrderBean.getBread());
        System.out.println(lunchOrderBean.getCondiments());
        System.out.println(lunchOrderBean.getDressing());
        System.out.println(lunchOrderBean.getMeat());
    }
}
