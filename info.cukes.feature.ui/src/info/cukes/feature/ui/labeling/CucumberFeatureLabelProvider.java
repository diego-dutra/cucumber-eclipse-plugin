/*
 * generated by Xtext
 */
package info.cukes.feature.ui.labeling;

import info.cukes.feature.cucumberFeature.Background;
import info.cukes.feature.cucumberFeature.Feature;
import info.cukes.feature.cucumberFeature.FeatureDescription;
import info.cukes.feature.cucumberFeature.Scenario;
import info.cukes.feature.cucumberFeature.StepDefinition;
import info.cukes.feature.cucumberFeature.TableBlock;

import java.util.List;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 * 
 * see
 * http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class CucumberFeatureLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	public CucumberFeatureLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	// Labels and icons can be computed like this:

	String text(Feature elem) {
		return "Feature: " + join(elem.getFd().getText(), " ");
	}

	String image(Background elem) {
		return "background.png";
	}

	String text(Background elem) {
		return "Background";
	}

	String image(TableBlock elem) {
		return "limwire.png";
	}

	String text(TableBlock elem) {
		return "Examples";
	}

	String image(Scenario elem) {
		return "scenario.png";
	}

	String text(Scenario elem) {
		return "Scenario: " + join(elem.getDescription().getText(), " ");
	}

	String image(StepDefinition elem) {
		return "default.gif";
	}

	String text(StepDefinition elem) {
		return elem.getType() + " " + join(elem.getText()," ");
	}

	String image(Feature elem) {
		return "cucumber.png";
	}

	String image(FeatureDescription elem) {
		return "build_var_obj.gif";
	}

	public static String join(List<String> list, String separator) {
		StringBuilder out = new StringBuilder();
		for (Object o : list) {
			out.append(o.toString());
			out.append(separator);
		}
		return out.toString();
	}
}
