package it.unibo.deathnote.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import it.unibo.deathnote.api.DeathNote;

public class DeathNoteImplementation implements DeathNote {

    private final Map<String,Death> deathList;
    private long time = 0;
    private String lastName;

    public DeathNoteImplementation() {
        deathList = new LinkedHashMap<>();
    }

    @Override
    public String getRule(int ruleNumber) {
        if(ruleNumber<1 || ruleNumber>RULES.size()) {
            throw new IllegalArgumentException("Couldn't find any rule for index: " + ruleNumber);
        }
        return RULES.get(ruleNumber-1);
    }

    @Override
    public void writeName(String name) {
        if(name == null) {
            throw new NullPointerException("Name can't be empty");
        }
        else {
            lastName = name;
            deathList.put(name, new Death());
            time = System.currentTimeMillis();
        }
    }

    @Override
    public boolean writeDeathCause(String cause) {
        if(time != 0 && cause != null) {
            if(System.currentTimeMillis() < time + 40) {
                deathList.get(lastName).setDeathCause(cause);
                return true;
            } 
            return false;
        }
        else {
            throw new IllegalStateException("This name is not written in this DeathNote, or the details are null");
        }
    }

    @Override
    public boolean writeDetails(String details) {
        if(time != 0 && details != null) {
            if(System.currentTimeMillis() < time + 6040) {
                deathList.get(lastName).setDeathDetails(details);
                return true;
            }
            return false;
        }
        else {
            throw new IllegalStateException("This name is not written in this DeathNote, or the details are null");
        }
    }

    @Override
    public String getDeathCause(String name) {
        if(deathList.get(name) != null) {
            return deathList.get(name).getDeathsCause();
        }
        else {
            throw new IllegalArgumentException("The provided name is not written in this DeathNote");
        }
    }

    @Override
    public String getDeathDetails(String name) {
        if(deathList.get(name) != null) {
            return deathList.get(name).getDeathsDetails();
        }
        else {
            throw new IllegalArgumentException("The provided name is not written in this DeathNote");
        }
    }

    @Override
    public boolean isNameWritten(String name) {
        if(deathList.get(name) != null) {
            return true;
        }
        return false;
    }

    public class Death {

        private String deathCause;
        private String deathDetails;

        public Death() {
            this.deathCause = "Heart attack";
            this.deathDetails = "";
        }
        public String getDeathsCause() {
            return this.deathCause;
        }
        public String getDeathsDetails() {
            return this.deathDetails;
        }
        public void setDeathCause(String deathCause) {
            this.deathCause = deathCause;
        }
        public void setDeathDetails(String deathDetails) {
            this.deathDetails = deathDetails;
        }

    }

}