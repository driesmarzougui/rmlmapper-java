package be.ugent.rml.records;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class is a specific implementation of a record for CSV.
 * Every record corresponds with a row of the CSV data source.
 */
public class CSVRecord extends Record {

    // The CSV record that is provided by the Apache CSVParser.
    private org.apache.commons.csv.CSVRecord record;
    private Map<String, String> datatypes;

    CSVRecord(org.apache.commons.csv.CSVRecord record, Map<String, String> datatypes) {
        this.record = record;
        this.datatypes = datatypes;
    }

    /**
     * This method returns the datatype of a reference in the record.
     * @param value the reference for which the datatype needs to be returned.
     * @return the IRI of the datatype.
     */
    public String getDataType(String value) {
        String datatype = null;

        if (datatypes != null) {
            datatype = datatypes.get(value);
        }

        return datatype;
    }

    /**
     * This method returns the objects for a column in the CSV record (= CSV row).
     * @param value the column for which objects need to be returned.
     * @return a list of objects for the column.
     */
    @Override
    public List<Object> get(String value) {
        List<Object> result = new ArrayList<>();
        Object obj;

        try {
            obj = this.record.get(value);
            result.add(obj);
        } catch (Exception e) {
            return result;
        }

        return result;
    }
}
