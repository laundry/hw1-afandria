import java.util.Iterator;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.collection.base_cpm.CasObjectProcessor;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceProcessException;

public class AnnotationPrinter extends CasConsumer_ImplBase implements CasObjectProcessor {

  @Override
  public void processCas(CAS arg0) throws ResourceProcessException {
    // TODO Auto-generated method stub
    JCas jcas;
    try {
      jcas = arg0.getJCas();
    } catch (CASException e) {
      throw new ResourceProcessException(e);
    }
    Iterator<Annotation> i = jcas.getAnnotationIndex().iterator();
    while (i.hasNext())
    {
      Annotation a = i.next();
      System.out.println(a.getCoveredText());
    }
  }

}
