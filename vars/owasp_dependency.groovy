def call() {

  // Ensure the output folder exists
  sh 'mkdir -p reports'

  // Run the OWASP Dependency-Check scan with XML output
  dependencyCheck additionalArguments: '--scan ./', odcInstallation: 'OWASP'
  dependencyCheckPublisher pattern: '**/dependency-check-report.xml'

}
