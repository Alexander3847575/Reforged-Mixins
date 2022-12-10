package net.impactdev.reforged.mixins.api.registry;

public class Delegator<T extends Registry> {

    private T instance;

    public Delegator(Class<T> ignored) {}

    public boolean set(T instance) {
        if(this.instance != null) {
            return false;
        }

        this.instance = instance;
        return true;
    }

    public T get() {
        return this.instance;
    }

}
