mvn versions:set -DnewVersion=1.0
mvn clean deploy -Psonatype-oss-release
mvn versions:revert