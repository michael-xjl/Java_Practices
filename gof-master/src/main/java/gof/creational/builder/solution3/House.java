package gof.creational.builder.solution3;

/**
 * usually , build pattern will have this feature:
 * private the set methods
 * private class construct
 *
 * inner Builder class is the only way to get class instance
 * make the mandatory fields as the parameters to inner Builder class contructure.
 */
public class House
{
    private String foundation;
    private String structure;
    private String roof;
    private boolean furnished;
    private boolean painted;

    public void setFoundation(String foundation) {
        this. foundation = foundation;
    }
    public void setStructure(String structure) {
        this.structure = structure;
    }
    public void setRoof(String roof) {
        this.roof = roof;
    }
    public void setFurnished(boolean furnished) {
        this.furnished = furnished;
    }
    public void setPainted(boolean painted) {
        this.painted = painted;
    }
    @Override
    public String toString() {
        return "Foundation - " + foundation + " Structure - " + structure + " Roof - " + roof +" Is Furnished? "+furnished+" Is Painted? "+painted;
    }

    private House()
    {

    }

    public static class Builder
    {
        private String foundation;
        private String structure;
        private String roof;
        private boolean furnished;
        private boolean painted;

        public Builder(String fuundation, String structure, String roof)
        {
            this.foundation = fuundation;
            this.structure = structure;
            this.roof = roof;
        }

        public Builder furnished(boolean isFurnished)
        {
            this.furnished = isFurnished;
            return this;
        }


        public Builder painted(boolean isPainted)
        {
            this.painted = isPainted;
            return this;
        }

        public House build()
        {
            House house = new House();
            house.setFoundation(this.foundation);
            house.setStructure(this.structure);
            house.setRoof(this.roof);
            house.setFurnished(this.furnished);
            house.setPainted(this.painted);

            return house;
        }
    }



}
