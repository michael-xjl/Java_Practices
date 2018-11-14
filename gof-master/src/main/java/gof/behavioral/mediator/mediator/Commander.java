package gof.behavioral.mediator.mediator;


import gof.behavioral.mediator.colleague.ArmedUnit;

public interface Commander {
   void registerArmedUnits(ArmedUnit soldierUnit, ArmedUnit tankUnit);
    void setAttackStatus(boolean attackStatus);
    boolean canAttack();
    void startAttack(ArmedUnit armedUnit);
    void ceaseAttack(ArmedUnit armedUnit);
}
