package gof.structural.adapter.csvadapter;

import gof.structural.adapter.adaptee.CsvFormattable;
import gof.structural.adapter.source.TextFormattable;

public class CsvAdapterImpl implements TextFormattable {
    CsvFormattable csvFormatter;
    public CsvAdapterImpl(CsvFormattable csvFormatter){
        this.csvFormatter=csvFormatter;
    }
    @Override
    public String formatText(String text)
    {
        String formattedText=csvFormatter.formatCsvText(text);
        return formattedText;
    }
}
