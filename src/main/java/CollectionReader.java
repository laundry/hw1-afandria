import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReader_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.FileUtils;
import org.apache.uima.util.Progress;

public class CollectionReader extends CollectionReader_ImplBase {

  private boolean read;

  public void initialize() throws ResourceInitializationException {
    System.out.println("Initializing collection reader");
    read = false;
  }

  @Override
  public void getNext(CAS arg0) throws IOException, CollectionException {
    JCas jcas;
    String fp;
    try {
      jcas = arg0.getJCas();
      fp = (String)getConfigParameterValue("InputFilePath");
      // TODO get actual config
      if (fp == null) fp = "src/main/resources/data/hw1.in";
    } catch (CASException e) {
      throw new CollectionException();
    }
    
    File f = new File(fp);
    jcas.setDocumentText(FileUtils.file2String(f, "UTF-8"));
    read = true;

  }

  @Override
  public void close() throws IOException {
    System.out.println("closing");
  }

  @Override
  public Progress[] getProgress() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean hasNext() throws IOException, CollectionException {
    return !read;
  }

}
