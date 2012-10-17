import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.util.FileUtils;

public class HistoryAnnotator extends JCasAnnotator_ImplBase {

  private static boolean DEBUG = false;

  private static String DICT_PATH = "src/main/resources/data/sample.out";

  private Set<String> getDictionary() throws AnalysisEngineProcessException {
    Set<String> dictionary = new HashSet<String>();
    try {
      String[] lines = FileUtils.file2String(new File(DICT_PATH)).split("\\n");
      for (int i = 0; i < lines.length; i++) {
        if (lines[i].indexOf(";") != 0) {
          dictionary.add(lines[i].split("|")[3]);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
      throw new AnalysisEngineProcessException();
    }
    return dictionary;
  }

  @Override
  public void process(JCas arg0) throws AnalysisEngineProcessException {
    if (DEBUG)
      System.out.println("History Annotator!");
    // get the named entity history
    Set<String> dictionary = getDictionary();
    // get annotations
    AnnotationIndex<Annotation> annotations = arg0.getAnnotationIndex(Gene.type);
    Iterator<Annotation> annotationIterator = annotations.iterator();
    while (annotationIterator.hasNext()) {
      Gene a = (Gene) annotationIterator.next();
      // increment confidence if it's in the history
      if (dictionary.contains(a.getContent())) {
        a.setConfidence(a.getConfidence() + 5);
      }
      if (DEBUG)
        System.out.println(a.getConfidence() + " " + a.getContent());
    }
  }

}
