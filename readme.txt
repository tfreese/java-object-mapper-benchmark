Projekt anlegen:
mvn archetype:generate \
          -DinteractiveMode=false \
          -DarchetypeGroupId=org.openjdk.jmh \
          -DarchetypeArtifactId=jmh-java-benchmark-archetype \
          -DgroupId=de.freese \
          -DartifactId=jmh-test.project \
          -Dversion=1.0
          
          
Console:
- java -jar target/benchmarks.jar -h
- java -jar target/benchmarks.jar -rf csv -rff results.csv
- java -jar target/benchmarks.jar -bm thrpt -f 1 -wi 2 -w 2s -i 3 -r 2s -jvmArgs '-server -disablesystemassertions' -rf csv -rff results.csv
- gnuplot benchmark.plt

Die Klassen-Annotations werden benutzt, wenn der Benchmark über 'org.openjdk.jmh.Main' aufgerufen wird.

Bei Meldung 'No benchmarks to run' -> mvn clean compile


JMH in Eclipse ausführen:
- m2e-apt Konnektor über MarketPlace installieren