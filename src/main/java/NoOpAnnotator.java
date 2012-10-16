import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

public class NoOpAnnotator extends JCasAnnotator_ImplBase {

  @Override
  public void process(JCas arg0) throws AnalysisEngineProcessException {
    String docText = arg0.getDocumentText();
    System.out.println(docText);
  }

}
