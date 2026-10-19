# SonarQube Java Severity Demo

Small Java/Maven project for a Jenkins + SonarQube classroom demo.

**Training only:** the source intentionally contains code-quality and security-sensitive patterns. Do not deploy it or reuse these patterns in production.

## Push to a new GitHub repository (Windows)

1. Extract this ZIP.
2. Create an empty GitHub repository named `sonarqube-java-severity-demo`.
3. Open Command Prompt in this folder and run (replace YOUR-USERNAME):

```bat
git init
git add .
git commit -m "Add SonarQube Java severity demo"
git branch -M main
git remote add origin https://github.com/YOUR-USERNAME/sonarqube-java-severity-demo.git
git push -u origin main
```

## Jenkins + SonarQube

1. Configure the job to check out your GitHub repository.
2. Confirm the scanner is configured in **Manage Jenkins → Tools** and the SonarQube server in **Manage Jenkins → System**.
3. Ensure the token's user has **Execute Analysis** permission on the SonarQube project.
4. Use this project key: `sonarqube-java-severity-demo`.
5. Run the job, then open the project in SonarQube at `http://localhost:9000`.

Example scanner command for a Freestyle job using **Execute Windows batch command**:

```bat
sonar-scanner.bat -Dsonar.projectKey=sonarqube-java-severity-demo -Dsonar.projectName="SonarQube Java Severity Demo" -Dsonar.sources=src/main/java -Dsonar.java.source=17
```

Use the scanner installation/path configured on your Jenkins machine. If your job already passes `sonar.projectKey`, update that setting to match the key above.

## About severity buckets

A scan is not guaranteed to produce an issue in every severity bucket. Results depend on SonarQube version, active Java rules, quality profile, and rule categorization. Some versions display **Blocker / High / Medium / Low / Info** for software-quality impact; the standard experience may display **Blocker / Critical / Major / Minor / Info**. Security Hotspots may be listed separately and require review.

If a bucket is empty, inspect the active Java rules and issue filters in SonarQube. Avoid changing rule severities just to populate a demo dashboard unless you label that as a custom training configuration.
