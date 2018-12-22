package gof.creational.builder.solution4;

import java.util.Objects;

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

    public House(HouseBuilder houseBuilder)
    {
        Objects.requireNonNull(houseBuilder);

    }
}
