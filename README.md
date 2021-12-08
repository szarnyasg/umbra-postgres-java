# umbra-postgres-java

Set the `UMBRA_LOCATION` environment variable:

```bash
export UMBRA_LOCATION=
```

Run the following commands:

```bash
rm -rf /tmp/umbra-scratch/
mkdir /tmp/umbra-scratch/
${UMBRA_LOCATION}/bin/sql --createdb /tmp/umbra-scratch/my.db create-role.sql
${UMBRA_LOCATION}/bin/server --address 127.0.0.1 /tmp/scratch/my.db
```

Try from Python:

```bash
python3 -c 'import psycopg2; con = psycopg2.connect(host="localhost", user="postgres", password="mysecretpassword", port=5432); cur = con.cursor(); cur.execute("SELECT 42 AS x;"); print(cur.fetchall());'
```

Try from Java:

```bash
mvn compile exec:java -Dexec.mainClass="umbra.Main"
```

Fails with:

```console
org.postgresql.util.PSQLException: An I/O error occurred while sending to the backend.
    at org.postgresql.core.v3.QueryExecutorImpl.execute (QueryExecutorImpl.java:381)
    at org.postgresql.core.v3.QueryExecutorImpl.execute (QueryExecutorImpl.java:314)
    at org.postgresql.core.SetupQueryRunner.run (SetupQueryRunner.java:55)
    at org.postgresql.core.v3.ConnectionFactoryImpl.runInitialQueries (ConnectionFactoryImpl.java:845)
    at org.postgresql.core.v3.ConnectionFactoryImpl.openConnectionImpl (ConnectionFactoryImpl.java:286)
    at org.postgresql.core.ConnectionFactory.openConnection (ConnectionFactory.java:51)
    at org.postgresql.jdbc.PgConnection.<init> (PgConnection.java:225)
    at org.postgresql.Driver.makeConnection (Driver.java:466)
    at org.postgresql.Driver.connect (Driver.java:265)
    at java.sql.DriverManager.getConnection (DriverManager.java:664)
    at java.sql.DriverManager.getConnection (DriverManager.java:208)
    at umbra.Main.main (Main.java:17)
    at org.codehaus.mojo.exec.ExecJavaMojo$1.run (ExecJavaMojo.java:254)
    at java.lang.Thread.run (Thread.java:748)
Caused by: java.io.EOFException
    at org.postgresql.core.PGStream.receiveChar (PGStream.java:452)
    at org.postgresql.core.v3.QueryExecutorImpl.processResults (QueryExecutorImpl.java:2118)
    at org.postgresql.core.v3.QueryExecutorImpl.execute (QueryExecutorImpl.java:354)
    at org.postgresql.core.v3.QueryExecutorImpl.execute (QueryExecutorImpl.java:314)
    at org.postgresql.core.SetupQueryRunner.run (SetupQueryRunner.java:55)
    at org.postgresql.core.v3.ConnectionFactoryImpl.runInitialQueries (ConnectionFactoryImpl.java:845)
    at org.postgresql.core.v3.ConnectionFactoryImpl.openConnectionImpl (ConnectionFactoryImpl.java:286)
    at org.postgresql.core.ConnectionFactory.openConnection (ConnectionFactory.java:51)
    at org.postgresql.jdbc.PgConnection.<init> (PgConnection.java:225)
    at org.postgresql.Driver.makeConnection (Driver.java:466)
    at org.postgresql.Driver.connect (Driver.java:265)
    at java.sql.DriverManager.getConnection (DriverManager.java:664)
    at java.sql.DriverManager.getConnection (DriverManager.java:208)
    at umbra.Main.main (Main.java:17)
    at org.codehaus.mojo.exec.ExecJavaMojo$1.run (ExecJavaMojo.java:254)
    at java.lang.Thread.run (Thread.java:748)
```
