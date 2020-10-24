package io.dsub.creational.builder.telescoping;

public class LunchOrderBeanDemo {
    public static void main(String[] args) {
        LunchOrderBean lunchOrderBean = new LunchOrderBean("i don't want any bread...");

        System.out.println(lunchOrderBean.getBread());
        System.out.println(lunchOrderBean.getCondiments());
        System.out.println(lunchOrderBean.getDressing());
        System.out.println(lunchOrderBean.getMeat());
    }
}
