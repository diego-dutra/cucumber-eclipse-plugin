
package info.cukes.feature;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class CucumberFeatureStandaloneSetup extends CucumberFeatureStandaloneSetupGenerated{

	public static void doSetup() {
		new CucumberFeatureStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

