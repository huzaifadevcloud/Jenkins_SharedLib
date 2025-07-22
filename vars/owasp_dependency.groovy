def call() {
    sh '''
        mkdir -p reports
        dependency-check.sh \
            --project Wanderlust \
            --scan ./ \
            --format XML \
            --out reports \
            --disableAssembly
    '''
    
    // Confirm the file was created
    sh 'ls -l reports/dependency-check-report.xml || echo "XML report not generated"'

    // Publish XML report
    dependencyCheckPublisher pattern: 'reports/dependency-check-report.xml'
}






/*def call() {
    sh 'mkdir -p reports'
    dependencyCheck additionalArguments: '--scan ./ --format XML --out reports', odcInstallation: 'OWASP'
    dependencyCheckPublisher pattern: 'reports/dependency-check-report.xml'
}
*/
