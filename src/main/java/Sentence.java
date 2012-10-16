

/* First created by JCasGen Sun Oct 14 23:34:49 EDT 2012 */

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Tue Oct 16 10:58:53 EDT 2012
 * XML source: C:/scratch/eclipse_workspace/hw1-afandria/src/main/java/GeneAnnotationTypeSystemDescriptor.xml
 * @generated */
public class Sentence extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Sentence.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Sentence() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Sentence(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Sentence(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Sentence(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: identifier

  /** getter for identifier - gets Something like P00001606T0076
   * @generated */
  public String getIdentifier() {
    if (Sentence_Type.featOkTst && ((Sentence_Type)jcasType).casFeat_identifier == null)
      jcasType.jcas.throwFeatMissing("identifier", "Sentence");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Sentence_Type)jcasType).casFeatCode_identifier);}
    
  /** setter for identifier - sets Something like P00001606T0076 
   * @generated */
  public void setIdentifier(String v) {
    if (Sentence_Type.featOkTst && ((Sentence_Type)jcasType).casFeat_identifier == null)
      jcasType.jcas.throwFeatMissing("identifier", "Sentence");
    jcasType.ll_cas.ll_setStringValue(addr, ((Sentence_Type)jcasType).casFeatCode_identifier, v);}    
   
    
  //*--------------*
  //* Feature: content

  /** getter for content - gets Something like "Comparison with alkaline phosphatases and 5-nucleotidase"
   * @generated */
  public String getContent() {
    if (Sentence_Type.featOkTst && ((Sentence_Type)jcasType).casFeat_content == null)
      jcasType.jcas.throwFeatMissing("content", "Sentence");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Sentence_Type)jcasType).casFeatCode_content);}
    
  /** setter for content - sets Something like "Comparison with alkaline phosphatases and 5-nucleotidase" 
   * @generated */
  public void setContent(String v) {
    if (Sentence_Type.featOkTst && ((Sentence_Type)jcasType).casFeat_content == null)
      jcasType.jcas.throwFeatMissing("content", "Sentence");
    jcasType.ll_cas.ll_setStringValue(addr, ((Sentence_Type)jcasType).casFeatCode_content, v);}    
  }

    