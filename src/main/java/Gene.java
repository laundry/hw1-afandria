

/* First created by JCasGen Sun Oct 14 23:34:49 EDT 2012 */

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Mon Oct 15 03:01:44 EDT 2012
 * XML source: C:/scratch/eclipse_workspace/hw1-afandria/src/main/java/GeneAnnotationCollectionReaderDescriptor.xml
 * @generated */
public class Gene extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Gene.class);
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
  protected Gene() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Gene(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Gene(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Gene(JCas jcas, int begin, int end) {
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
  //* Feature: startIndex

  /** getter for startIndex - gets 
   * @generated */
  public int getStartIndex() {
    if (Gene_Type.featOkTst && ((Gene_Type)jcasType).casFeat_startIndex == null)
      jcasType.jcas.throwFeatMissing("startIndex", "Gene");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Gene_Type)jcasType).casFeatCode_startIndex);}
    
  /** setter for startIndex - sets  
   * @generated */
  public void setStartIndex(int v) {
    if (Gene_Type.featOkTst && ((Gene_Type)jcasType).casFeat_startIndex == null)
      jcasType.jcas.throwFeatMissing("startIndex", "Gene");
    jcasType.ll_cas.ll_setIntValue(addr, ((Gene_Type)jcasType).casFeatCode_startIndex, v);}    
   
    
  //*--------------*
  //* Feature: endIndex

  /** getter for endIndex - gets 
   * @generated */
  public int getEndIndex() {
    if (Gene_Type.featOkTst && ((Gene_Type)jcasType).casFeat_endIndex == null)
      jcasType.jcas.throwFeatMissing("endIndex", "Gene");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Gene_Type)jcasType).casFeatCode_endIndex);}
    
  /** setter for endIndex - sets  
   * @generated */
  public void setEndIndex(int v) {
    if (Gene_Type.featOkTst && ((Gene_Type)jcasType).casFeat_endIndex == null)
      jcasType.jcas.throwFeatMissing("endIndex", "Gene");
    jcasType.ll_cas.ll_setIntValue(addr, ((Gene_Type)jcasType).casFeatCode_endIndex, v);}    
   
    
  //*--------------*
  //* Feature: content

  /** getter for content - gets 
   * @generated */
  public String getContent() {
    if (Gene_Type.featOkTst && ((Gene_Type)jcasType).casFeat_content == null)
      jcasType.jcas.throwFeatMissing("content", "Gene");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Gene_Type)jcasType).casFeatCode_content);}
    
  /** setter for content - sets  
   * @generated */
  public void setContent(String v) {
    if (Gene_Type.featOkTst && ((Gene_Type)jcasType).casFeat_content == null)
      jcasType.jcas.throwFeatMissing("content", "Gene");
    jcasType.ll_cas.ll_setStringValue(addr, ((Gene_Type)jcasType).casFeatCode_content, v);}    
  }

    