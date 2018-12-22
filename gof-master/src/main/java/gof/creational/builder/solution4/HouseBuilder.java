package gof.creational.builder.solution4;

/**
 * usually , build pattern will have this feature:
 * private the set methods
 * private class construct
 *
 * inner Builder class is the only way to get class instance
 * make the mandatory fields as the parameters to inner Builder class contructure.
 */
public class HouseBuilder
{

        private String foundation;
        private String structure;
        private String roof;
        private boolean furnished;
        private boolean painted;

        public HouseBuilder(String fuundation, String structure, String roof)
        {
            this.foundation = fuundation;
            this.structure = structure;
            this.roof = roof;
        }

        public HouseBuilder furnished(boolean isFurnished)
        {
            this.furnished = isFurnished;
            return this;
        }


        public HouseBuilder painted(boolean isPainted)
        {
            this.painted = isPainted;
            return this;
        }

        public House build()
        {
            House house = new House(this);
            house.setFoundation(this.foundation);
            house.setStructure(this.structure);
            house.setRoof(this.roof);
            house.setFurnished(this.furnished);
            house.setPainted(this.painted);

            return house;
        }

}
