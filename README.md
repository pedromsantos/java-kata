# Java kata starter

This project contains a number of katas with instructions ordered in a proven path described in my
book [Agile Technical Practices Distilled](https://leanpub.com/agiletechnicalpracticesdistilled).

## Instructions

### Build solution and execute tests

POSIX shell:

```sh
./mvnw clean verify -T 1C
```

PowerShell:

```powershell
mvnw.cmd clean verify -T 1C
```

### Coverage reports

```sh
./coverage/target/site/jacoco-aggregate/index.html
```
