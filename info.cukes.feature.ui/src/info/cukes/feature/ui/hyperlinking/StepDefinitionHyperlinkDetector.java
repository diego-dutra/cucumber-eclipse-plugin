package info.cukes.feature.ui.hyperlinking;

import info.cukes.feature.cucumberFeature.StepDefinition;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.ParseTreeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

public class StepDefinitionHyperlinkDetector implements IHyperlinkDetector {

	@Override
	public IHyperlink[] detectHyperlinks(final ITextViewer textViewer, final IRegion region, final boolean canShowMultipleHyperlinks) {
		return ((IXtextDocument) textViewer.getDocument()).readOnly(new IUnitOfWork<IHyperlink[], XtextResource>() {
			public IHyperlink[] exec(final XtextResource resource) throws Exception {
				final AbstractNode foundNode = findStepDefinitionNode(region, resource);
				final IRegion linkRegion = foundNode == null ? region : new IRegion() {

					@Override
					public int getOffset() {
						return foundNode.getOffset();
					}

					@Override
					public int getLength() {
						return foundNode.getLength();
					}
				};

				return new IHyperlink[] { new IHyperlink() {

					@Override
					public void open() {
					}

					@Override
					public String getTypeLabel() {
						return "Blabel";
					}

					@Override
					public String getHyperlinkText() {
						return "Bla HyperlinkText";
					}

					@Override
					public IRegion getHyperlinkRegion() {
						return linkRegion;
					}
				} };
			}

		});

	}

	private AbstractNode findStepDefinitionNode(final IRegion region, final XtextResource resource) {
		IParseResult parseResult = resource.getParseResult();
		AbstractNode node = null;
		if (parseResult != null && parseResult.getRootNode() != null) {
			node = ParseTreeUtil.getCurrentOrFollowingNodeByOffset(parseResult.getRootNode(), region.getOffset());
			while (node != null) {
				if (node.getElement() instanceof StepDefinition)
					break;
				else
					node = node.getParent();
			}
		}
		return node;
	}

}
