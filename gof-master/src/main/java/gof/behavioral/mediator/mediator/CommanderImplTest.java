package gof.behavioral.mediator.mediator;

import gof.behavioral.mediator.colleague.ArmedUnit;
import gof.behavioral.mediator.colleague.SoldierUnit;
import gof.behavioral.mediator.colleague.TankUnit;
import org.junit.Test;

public class CommanderImplTest {

    @Test
    public void testMediator() throws Exception {
        Commander commander= new CommanderImpl();
        ArmedUnit soldierUnit=new SoldierUnit(commander);
        ArmedUnit tankUnit=new TankUnit(commander);
        commander.registerArmedUnits(soldierUnit, tankUnit);
        commander.startAttack(soldierUnit);
        commander.startAttack(tankUnit);
        commander.ceaseAttack(soldierUnit);
        commander.startAttack(tankUnit);
    }
}