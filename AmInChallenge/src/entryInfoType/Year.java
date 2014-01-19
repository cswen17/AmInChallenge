package entryInfoType;

/**
 * An Entry Info class that records which year the torture incidence occurred
 * in. The database column is prefixed with TortureIncident just in case the
 * database is merged with other databases.
 * 
 * @author connie
 * 
 */
public class Year extends EntryInfo {
	public Year(String year) {
		super.columnName = "TortureIncidentYear";
		super.value = year;
	}
}