# JDBC in Action

## Statement

1. It is the key interface to execute the DML and DQL statements from our jdbc client application.
2. We can create a statement object by calling the `Connection.createStatement();`.
3. Once we have a connection we will invoke the create statement method on it which will return as a statement from that point of time. 
   `Statement stmt = conn.CreateStatement();`.
4. There are to important methods in statement.
   1. `stmt.executeUpdate()`: It will take an sql DML statement that will insert, update, or delete against the database.
        - It returns an integer value which is the number of records that got inserted, updated or deleted.
   2. `ResultSet rs = stmt.executeQuery()`: It will take an sql DQL statement that will select data from the database.
        - It returns a list of rows which will be handled by the result set interface in the database.

## ResultSet

1. It is an interface in the database API and is used to handle the data that comes back when we execute a select query.
2. ResultSet is an object oriented representation of a table of records retrieved from the database.
3. It is logically represented as zero record area -> Record area -> No record Area.

### Important methods in ResultSet

1. There are almost 17 methods in ResultSet interface out of which are frequently used and important methods.
   - `rs.next();`: This points the cursor to next available record. It returns true value when there is a record and false when is not.
   - `rs.getXXX();`: These methods are used to retrieve data from the database when a record is found. Instead of xxx we use data types of record like int, String, and others.

