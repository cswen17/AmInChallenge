package entryInfoType;

/**
 * An Entry Info class that records method was used to torture the victim(s).
 * The database column is prefixed with TortureIncident just in case the
 * database is merged with other databases.
 * 
 * @author connie
 * 
 */
public class TortureMethod extends EntryInfo {
	public TortureMethod(String tortureMethod) {
		super.columnName = "TortureIncidentTortureMethod";
		super.value = tortureMethod;
	}
}