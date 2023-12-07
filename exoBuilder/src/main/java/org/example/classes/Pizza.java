package org.example.classes;



import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private SizePizza sizePizza;
    private PastryType pastryType;
    private Cheese cheese;
    private List<String> garnitures;
    private SauceType sauceType;

    private Pizza(Builder builder) {
        this.sizePizza = builder.sizePizza;
        this.pastryType = builder.pastryType;
        this.cheese = builder.cheese;
        this.garnitures = builder.garnitures;
        this.sauceType = builder.sauceType;


    }

    public static class Builder {
        private SizePizza sizePizza;
        private PastryType pastryType;
        private Cheese cheese;
        private List<String> garnitures = new ArrayList<>();
        private SauceType sauceType;

        public Builder sizePizza(SizePizza sizePizza) {
            this.sizePizza = sizePizza;
            return this;


        }

        public Builder pastryType(PastryType pastryType) {
            this.pastryType = pastryType;
            return this;
        }

        public Builder cheese(Cheese cheese) {
            if (this.cheese != null  ) {
                throw new IllegalStateException("Vous ne pouvez pas selectionner plusieurs fromages");
            } else {
                this.cheese = cheese;

                return this;
            }
        }

        public Builder garnitures(String garniture) {
            this.garnitures.add(garniture);
            return this;
        }

        public Builder sauceType(SauceType sauceType) {
            this.sauceType = sauceType;
            return this;
        }

        public Pizza build() {

            return new Pizza(this);
        }




    }

    @Override
    public String toString() {
        return "Builder{" +
                "sizePizza=" + sizePizza +
                ", pastryType=" + pastryType +
                ", cheese=" + cheese +
                ", garniture='" + garnitures + '\'' +
                ", sauceType=" + sauceType +
                '}';
    }
}