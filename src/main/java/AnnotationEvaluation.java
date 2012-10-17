import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.collection.base_cpm.CasObjectProcessor;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceProcessException;
import org.apache.uima.util.FileUtils;

public class AnnotationEvaluation extends CasConsumer_ImplBase implements CasObjectProcessor {

  /**
   * Debug flag to toggle print statements.
   */
  private static boolean DEBUG = false;

  /**
   * This is where our truths lie (default)
   */
  private static String TRUTH_PATH = "src/main/resources/data/sample.out";

  /**
   * Create set of strings that are our gold standard
   * 
   * @return set of strings contained by truths in TRUTH_PATH
   * @throws IOException
   */
  private Set<String> getTruths() throws IOException {
    Set<String> truths = new HashSet<String>();
    // TODO get actual config
    String fp = (String) getConfigParameterValue("TruthFilePath");
    if (fp == null)
      fp = TRUTH_PATH;
    File f = new File(fp);
    String document = FileUtils.file2String(f, "UTF-8");
    String[] lines = document.split("\\n");
    for (int i = 0; i < lines.length; i++) {
      truths.add(lines[i]);
    }
    return truths;
  }

  /**
   * Prints the precision, recall, and f-measure between the sets truths & comparison.
   * 
   * @param truths
   *          Set<String> of known truths
   * @param comparison
   *          Set<String> of hypotheses to be compared to the truths set
   */
  public void evaluatePrint(Set<String> truths, Set<String> comparison) {
    float precisionCount = 0, recallCount = 0;
    // precision counts
    Iterator<String> comparisonIterator = comparison.iterator();
    while (comparisonIterator.hasNext()) {
      if (truths.contains(comparisonIterator.next())) {
        precisionCount++;
      }
    }
    // recall counts
    Iterator<String> truthIterator = truths.iterator();
    while (truthIterator.hasNext()) {
      if (comparison.contains(truthIterator.next())) {
        recallCount++;
      }
    }
    // calculate p, r, f
    float precision = 0, recall = 0, f = 0;
    if (DEBUG) {
      System.out.println("Precision ct: " + precisionCount);
      System.out.println("Recall ct: " + recallCount);
      System.out.println("Comparison ct: " + comparison.size());
      System.out.println("Truth ct: " + truths.size());
    }
    try {
      precision = precisionCount / comparison.size();
      recall = recallCount / truths.size();
      f = 2 * precision * recall / (precision + recall);
    } catch (Exception e) {
    }
    // print it out
    System.out.println("Precision: " + precision);
    System.out.println("Recall: " + recall);
    System.out.println("F-measure: " + f);
  }

  /* (non-Javadoc)
   * @see org.apache.uima.collection.base_cpm.CasObjectProcessor#processCas(org.apache.uima.cas.CAS)
   */
  @SuppressWarnings("deprecation")
  @Override
  public void processCas(CAS aCAS) throws ResourceProcessException {
    JCas jcas;
    try {
      jcas = aCAS.getJCas();
    } catch (CASException e) {
      throw new ResourceProcessException(e);
    }
    // get truths
    Set<String> truths = new HashSet<String>();
    try {
      truths = getTruths();
    } catch (IOException e) {
      e.printStackTrace();
    }
    // get what we think at the moment
    Set<String> comparison = new HashSet<String>();
    // get annotations
    AnnotationIndex<Annotation> annotations = jcas.getAnnotationIndex(Gene.type);
    Iterator<Annotation> annotationIterator = annotations.iterator();
    while (annotationIterator.hasNext()) {
      Gene g = (Gene) annotationIterator.next();
      if (g.getConfidence() >= 3) {
        // TODO (afandria): StringBuilders are so ugly. Is there another way?
        StringBuilder lineBuilder = new StringBuilder();
        lineBuilder.append(g.getIdentifier());
        lineBuilder.append("|");
        lineBuilder.append(g.getStart());
        lineBuilder.append(" ");
        lineBuilder.append(g.getEnd());
        lineBuilder.append("|");
        lineBuilder.append(g.getContent());
        comparison.add(lineBuilder.toString());
      }
    }
    evaluatePrint(truths, comparison);
  }
}
