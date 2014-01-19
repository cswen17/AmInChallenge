package entryInfoType;

/**
 * Class to represent a generic entry for the MySQL database, in case we want to
 * extend the types of data we're storing inside. All we require is a value
 * serialized as a String, and a corresponding column name to insert into in the
 * MySQL database.
 * 
 * @author connie
 * 
 */
public abstract class EntryInfo {
	protected String columnName;
	protected String value;
}