package net.impactdev.reforged.mixins.api.forms;

public class FormTarget {

    private final String name;
    private final Destination destination;

    public static FormTarget of(final String name, final Destination destination) {
        return new FormTarget(name, destination);
    }

    private FormTarget(String name, Destination destination) {
        this.name = name;
        this.destination = destination;
    }

    public final String name() {
        return this.name;
    }

    public final Destination destination() {
        return this.destination;
    }

}
