# Advanced JDBC

## JDBC Batch Updates

1. If we have a business logic where we have multiple DML statements against the database. Every time a DML statement runs there is a separate call made to the database.
2. This creates performance overhead to execute these statements separately. There will be network latency because the JDBC server is somewhere in different region to our client.
3. Using JDBC batch updates, we can group of a set of DML statements and send them all to the database for processing. After processing the DBMS will send a group of result back.

### Steps for Batching

1. The first step is to add DML statements using the statement interface `statement.addBatch(String dml)`. We can add any number of DML statements.
2. After adding all those DML statements we have to execute the query using,
   `int result[] = statement.executeBatch()` This `executeBatch()` returns array of integers in the exact order of executed DML statements.

## Result Set Metadata

1. Using `ResultSetMetaData` we can retrieve metadata of the data came in result set like column types, column names, number of columns that came back in each row and so on.
2. we can get this from the ResultSet.
3. Steps are:
   - We execute the query and get the result set back
     `ResultSet rs = st.executeQuery("select * from Emp");`
   - After getting result set back we have to call `rs.getMetaData();`.
     `ResultSetMetaData rsmd = rs.getMetaData();`
   - Now we can use the methods on the `ResultSetMetaData` like `rsmd.getColumnCount()` gives us the number of columns. We can loop through and get the names data types and so on.
   - We can get column name using `rsmd.getColumnName(i)` gives us the column name and `rsmd.getColumnType()` gives the data type.

## Transactions

1. A transaction is a logical unit of work in which all the operations get done or none of it gets done.
2. We have to set transaction boundaries to tell that 2 dml statements must execute at the same time.

### Transaction Properties

Every transaction has four properties, they are **ACID**.

1. **Atomicity**: All the operations in the transaction must execute or none of them must execute.
2. **Consistency**: The transaction must bring the database from one consistent state to another.
3. **Isolation**: When one transaction is happening it must be happen in isolation. So when one transaction is happening the other transactions should not read the corrupt data or should not read the wrong data.
4. **Durability**: Once the transaction is committed it must be durable. It means once the transaction is done despite the power loss or any other factor.

### Controlling Transactions

We can control transactions by using the _Connection_ interface. This interface has methods like

1. **Commit**: This is to tell the database that this is transaction boundary and we are done executing all dml statements and changes are ready to be committed.
2. **Rollback**: It is used when an exception is thrown or when we don't want to commit a transaction and we want to return everything to the prior state.
3. **SavePoint** : Using this we can commit a transaction or we can rollback to a certain point.
