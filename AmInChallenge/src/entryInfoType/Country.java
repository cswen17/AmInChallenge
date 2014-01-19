package entryInfoType;

/**
 * An Entry Info class that records which country the torture incident occurred
 * in. The database column is prefixed with TortureIncident just in case the 
 * database is merged with other databases.
 * 
 * @author connie
 * 
 */
public class Country extends EntryInfo {
	public Country(String country) {
		super.columnName = "TortureIncidentCountry";
		super.value = country;
	}
}