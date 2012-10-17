import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

/**
 * This annotator uses the Stanford NER to extract noun phrases (NNPs, well all named entities
 * should be NNPs) as a jumping point for our gene mention tagger.
 * 
 * @author afandria
 */
public class NNPAnnotator extends JCasAnnotator_ImplBase {

  /**
   * Debug flag to toggle print statements.
   */
  private static boolean DEBUG = false;

  /**
   * How much score/confidence to give for all named entities recognized
   */
  private static int DEFAULT_SCORE = 3;

  /**
   * Retrieve sentences formatted per sample.in from a string representing the entire document to be
   * annotated
   * 
   * @param document
   * @return Map from sentence identifiers to sentence contents
   */
  private Map<String, String> getSentences(String document) {
    String[] lines = document.split("\\n");
    Map<String, String> sentences = new TreeMap<String, String>();
    for (int i = 0; i < lines.length; i++) {
      // TODO (afandria): this is pretty ugly Java; find a more succinct way to say the following
      sentences.put(lines[i].substring(0, lines[i].indexOf(' ')),
              lines[i].substring(lines[i].indexOf(' ') + 1));
    }
    return sentences;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.apache.uima.analysis_component.JCasAnnotator_ImplBase#process(org.apache.uima.jcas.JCas)
   */
  @Override
  public void process(JCas arg0) throws AnalysisEngineProcessException {
    if (DEBUG)
      System.out.println("Noun Phrase Annotator!");
    PosTagNamedEntityRecognizer ner;
    try {
      ner = new PosTagNamedEntityRecognizer();
    } catch (ResourceInitializationException e) {
      throw new AnalysisEngineProcessException();
    }
    Map<String, String> sentences = getSentences(arg0.getDocumentText());
    Iterator<String> keyIterator = sentences.keySet().iterator();
    while (keyIterator.hasNext()) {
      String k = keyIterator.next();
      Set<Map.Entry<Integer, Integer>> spans = ner.getGeneSpans(sentences.get(k)).entrySet();
      Iterator<Map.Entry<Integer, Integer>> spanIterator = spans.iterator();
      while (spanIterator.hasNext()) {
        Map.Entry<Integer, Integer> me = spanIterator.next();
        // TODO (afandria): this is also pretty ugly Java; find a more succinct way to say the
        // following
        Integer normalizedBegin = me.getKey()
                - sentences.get(k).substring(0, me.getKey()).split(" ").length;
        if (normalizedBegin < 0)
          normalizedBegin = 0;
        Integer normalizedEnd = me.getValue()
                - sentences.get(k).substring(0, me.getValue()).split(" ").length;
        // add everything to the index
        Gene g = new Gene(arg0);
        g.setBegin(normalizedBegin);
        g.setEnd(normalizedEnd);
        g.setContent(sentences.get(k).substring(me.getKey(), me.getValue()));
        g.setIdentifier(k);
        g.setConfidence(DEFAULT_SCORE);
        g.addToIndexes();
        if (DEBUG)
          System.out.println(sentences.get(k).substring(me.getKey(), me.getValue()));
      }
    }
    // evaluate
  }

}
