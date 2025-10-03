# Java kata starter

This project contains a number of katas with instructions ordered in a proven path described in my
book [Agile Technical Practices Distilled](https://leanpub.com/agiletechnicalpracticesdistilled).

## License

Copyright (c) 2025 Pedro Santos

Licensed under the EUPL-1.2

This work is licensed under the European Union Public Licence v. 1.2. You may obtain a copy of the License at https://eupl.eu/1.2/en/

This is a reference kit for educational and development purposes. You are free to use, modify, and distribute this work under the terms of the EUPL-1.2 license.

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
