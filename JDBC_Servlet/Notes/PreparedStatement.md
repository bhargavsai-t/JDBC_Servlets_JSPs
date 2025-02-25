# Prepared Statement

1. It is a child interface of the statement interface.
2. It is a precompiled version of a sequel statement.

## Flow of statement object

- If you use the statement object to execute a select query or an update or insert statement, the first thing the that happens in the flow is that the JDBC client sends these statements through the driver one at a time to the database . The database will compile these statements.
- If there are any checks like syntax checking, if the queries are following sql specification; these checks are done during the compile time then it will execute that statement and sends back the appropriate result back to the client using driver.
-If we update the statement or if there are n statements, the compiling and checking of statements happen.
