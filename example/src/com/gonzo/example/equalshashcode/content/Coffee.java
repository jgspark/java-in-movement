package com.gonzo.example.equalshashcode.content;

public abstract class Coffee {

    private final String name;

    private final String size;

    private final Long liter;

    protected Coffee(String name, String size, Long liter) {
        this.name = name;
        this.size = size;
        this.liter = liter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coffee)) return false;

        Coffee coffee = (Coffee) o;

        if (name != null ? !name.equals(coffee.name) : coffee.name != null) return false;
        if (size != null ? !size.equals(coffee.size) : coffee.size != null) return false;
        return liter != null ? liter.equals(coffee.liter) : coffee.liter == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (liter != null ? liter.hashCode() : 0);
        return result;
    }
}
