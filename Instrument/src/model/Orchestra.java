package model;

import model.instruments.BrassInstrument;
import model.instruments.StringInstrument;

import java.util.ArrayList;

public class Orchestra {

    private ArrayList<BrassInstrument> brassInstruments = new ArrayList<>();
    private ArrayList<StringInstrument> stringInstruments = new ArrayList<>();

    public Orchestra(ArrayList<BrassInstrument> brassInstruments, ArrayList<StringInstrument> stringInstruments) {
        this.brassInstruments = brassInstruments;
        this.stringInstruments = stringInstruments;
    }

    public Orchestra() {}

    public void addBrassInstrument(BrassInstrument instrument) {
        if (!this.brassInstruments.contains(instrument)) {
            brassInstruments.add(instrument);
            instrument.setOrchestra(this);
        }
    }

    public void addStringInstrument(StringInstrument instrument) {
        if (!this.stringInstruments.contains(instrument)) {
            stringInstruments.add(instrument);
            instrument.setOrchestra(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orchestra orchestra = (Orchestra) o;

        if (brassInstruments != null ? !brassInstruments.equals(orchestra.brassInstruments) : orchestra.brassInstruments != null)
            return false;
        return stringInstruments != null ? stringInstruments.equals(orchestra.stringInstruments) : orchestra.stringInstruments == null;
    }

    @Override
    public int hashCode() {
        int result = brassInstruments != null ? brassInstruments.hashCode() : 0;
        result = 31 * result + (stringInstruments != null ? stringInstruments.hashCode() : 0);
        return result;
    }
}
