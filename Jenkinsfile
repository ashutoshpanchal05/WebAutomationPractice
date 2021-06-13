pipeline{

agent any

stages{

stage("Maven Clean Compile"){

	steps{
			withMaven(maven: 'maven_3_8_1'){
				sh 'mvn clean compile'}
	}

}

stage("Maven Test"){
		steps{
					withMaven(maven: 'maven_3_8_1'){
						sh 'mvn test'
						}
			}
}

}

}