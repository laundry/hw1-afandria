import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

public class NNPAnnotator extends JCasAnnotator_ImplBase {

  private static boolean DEBUG = false;
  
  private Map<String, String> getSentences(String document)
  {
    String[] lines = document.split("\\n");
    Map<String, String> sentences = new TreeMap<String, String>();
    for (int i = 0; i < lines.length; i++)
    {
      // TODO (afandria): this is pretty ugly Java; find a more succinct way to say the following
      sentences.put(lines[i].substring(0, lines[i].indexOf(' ')), lines[i].substring(lines[i].indexOf(' ') + 1));
    }
    return sentences;
  }
  
  @Override
  public void process(JCas arg0) throws AnalysisEngineProcessException {
    if (DEBUG) System.out.println("Noun Phrase Annotator!");
    PosTagNamedEntityRecognizer ner;
    try {
      ner = new PosTagNamedEntityRecognizer();
    } catch (ResourceInitializationException e) {
      throw new AnalysisEngineProcessException();
    }
    Map<String, String> sentences = getSentences(arg0.getDocumentText());
    Iterator<String> keyIterator = sentences.keySet().iterator();
    while (keyIterator.hasNext())
    {
      String k = keyIterator.next();
      Set<Map.Entry<Integer, Integer>> spans = ner.getGeneSpans(sentences.get(k)).entrySet();
      Iterator<Map.Entry<Integer, Integer>> spanIterator = spans.iterator();
      while (spanIterator.hasNext())
      {
        Map.Entry<Integer, Integer> me = spanIterator.next();
        // add everything to the index
        Gene g = new Gene(arg0);
        g.setBegin(me.getKey());
        g.setEnd(me.getValue());
        g.setContent(sentences.get(k).substring(me.getKey(), me.getValue()));
        g.setIdentifier(k);
        g.setConfidence(1);
        g.addToIndexes();
        if (DEBUG) System.out.println(sentences.get(k).substring(me.getKey(), me.getValue()));
      }
    }
  }

}
