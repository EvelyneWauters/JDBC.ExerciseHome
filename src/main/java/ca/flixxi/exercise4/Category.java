package ca.flixxi.exercise4;

/**
 * Created by Flyne on 14/06/2015.
 */
public enum Category {
    THRILLER("thriller"), COMEDY("comedy"), SERIE("serie"), DRAMA("drama"), NONFICION("non-fiction");

    private String label;

    Category(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
