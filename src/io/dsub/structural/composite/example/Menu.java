package io.dsub.structural.composite.example;

public class Menu extends MenuComponent {
    public Menu(String name, String url) {
        this.name = name;
        this.url = url;
    }

    @Override
    public MenuComponent add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
        return menuComponent;
    }

    @Override
    public MenuComponent remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
        return menuComponent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(print(this));

        for (MenuComponent menuComponent : menuComponents) {
            sb.append(menuComponent.toString());
        }

        return sb.toString();
    }
}
