pipeline{

agent any

stages{

stage("Maven Clean Compile"){

	steps{
			withMaven(maven: 'maven-3.8.1'){
				sh 'mvn clean compile'}
	}

}

stage("Maven Test"){
		steps{
					withMaven(maven: 'maven-3.8.1'){
						sh 'mvn test'
						}
			}
}

}

}