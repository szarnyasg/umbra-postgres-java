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

Then:

```bash
mvn compile exec:java -Dexec.mainClass="umbra.Main"
```
