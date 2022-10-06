/*
 * This file defines an abstract class named Bag.
 * In this exercise, you will be writing a larger class according to
 * the TODOs we have left you. You may find the readings in chapter
 * 1. Introduction to Java helpful.
 */

public abstract class Bag {

    private String color;
    private int numberOfContents;
    private int capacity;
    private String[] contents;


    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.numberOfContents = 0;
        this.contents = new String[]{};
    }


    public String getColor() {
        return this.color;
    }

    public int getNumberOfContents() {
        return this.numberOfContents;
    }

    public int getCapacity() {
        return this.capacity;
    }


    public void setColor(String color) {
        this.color = color;
    }


    public boolean addItem(String item) {
        if (this.numberOfContents < this.capacity) {
            int initialLength = this.contents.length;
            String[] newContents = new String[initialLength + 1];
            for (int i = 0; i < initialLength; i++) {
                newContents[i] = this.contents[i];
            }

            newContents[initialLength] = item;

            this.contents = newContents;
            this.numberOfContents++;
            return true;

        }
        return false;
    }


    public String popItem() {
        if (this.numberOfContents > 0) {
            int initialLength = this.contents.length;
            String[] newContents = new String[initialLength - 1];
            String poppedItem = this.contents[initialLength - 1];

            for (int i = 0; i < initialLength - 1; i++) {
                newContents[i] = this.contents[i];
            }

            this.contents = newContents;
            this.numberOfContents--;
            return poppedItem;
        } else {
            return null;
        }
    }





    /**
     * Increase this bag's capacity by n.
     *
     * @param n the amount to increase this Bag's capacity by
     */
    public void increaseCapacity(int n) {
        this.capacity += n;

    }

    /**
     * Return the details of this Bag.
     * This method requires you to have created the private
     * instance variables mentioned above.
     *
     * @return
     */
    @Override
    public String toString() {
        return this.color + " Bag (" + this.numberOfContents + " / " +
                this.capacity + ")";
    }

    /*
     * Below we have defined an abstract method.
     * This method takes no arguments and does not return anything.
     * It increases the capacity of this Bag.
     *
     * You will need to implement this method in
     * HandBag.java and CrossbodyBag.java.
     *
     * We recommend you look at HandBag.java first.
     */
    public abstract void enhance();
}