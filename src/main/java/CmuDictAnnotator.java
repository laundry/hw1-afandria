import java.util.Iterator;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

public class CmuDictAnnotator extends JCasAnnotator_ImplBase {

  private static boolean DEBUG = true;

  @Override
  public void process(JCas arg0) throws AnalysisEngineProcessException {
    if (DEBUG) System.out.println("CMU Dict Annotator!");
    AnnotationIndex<Annotation> annotations = arg0.getAnnotationIndex(Gene.type);
    Iterator<Annotation> annotationIterator = annotations.iterator();
    while (annotationIterator.hasNext()) {
      Gene a = (Gene)annotationIterator.next();
      if (DEBUG) System.out.println(a.getConfidence() + a.getContent());
    }
  }

}
