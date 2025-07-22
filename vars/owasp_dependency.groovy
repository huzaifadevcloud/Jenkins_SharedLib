def call() {
    sh 'mkdir -p reports'
    dependencyCheck additionalArguments: '--scan ./ --format XML --out reports', odcInstallation: 'OWASP'
    dependencyCheckPublisher pattern: 'reports/dependency-check-report.xml'
}
