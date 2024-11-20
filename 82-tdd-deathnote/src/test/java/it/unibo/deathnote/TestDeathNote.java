package it.unibo.deathnote;

import it.unibo.deathnote.api.DeathNote;
import it.unibo.deathnote.impl.DeathNoteImplementation;

class TestDeathNote {
    public static void main(String[] args) {

       DeathNote deathNote = new DeathNoteImplementation();
       String name1 = "Giuseppe Fusco";
       String name2 = "Andrea Monti";
        
        deathNote.writeName(name1);
        System.out.println(deathNote.getDeathDetails(name1));
        System.out.println(deathNote.writeDetails("ran for too long"));
        System.out.println(deathNote.getDeathDetails(name1));
        deathNote.writeName(name2);
        System.out.println(deathNote.writeDetails("drank too many beers"));
        System.out.println(deathNote.getDeathDetails(name2));
        try {
            Thread.sleep(6100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        deathNote.writeDetails("ate too much bananas");
        System.out.println(deathNote.getDeathDetails(name2));

    }
}