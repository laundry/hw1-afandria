
/* First created by JCasGen Sun Oct 14 23:34:49 EDT 2012 */

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Mon Oct 15 03:01:44 EDT 2012
 * @generated */
public class Gene_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Gene_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Gene_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Gene(addr, Gene_Type.this);
  			   Gene_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Gene(addr, Gene_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Gene.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("Gene");
 
  /** @generated */
  final Feature casFeat_startIndex;
  /** @generated */
  final int     casFeatCode_startIndex;
  /** @generated */ 
  public int getStartIndex(int addr) {
        if (featOkTst && casFeat_startIndex == null)
      jcas.throwFeatMissing("startIndex", "Gene");
    return ll_cas.ll_getIntValue(addr, casFeatCode_startIndex);
  }
  /** @generated */    
  public void setStartIndex(int addr, int v) {
        if (featOkTst && casFeat_startIndex == null)
      jcas.throwFeatMissing("startIndex", "Gene");
    ll_cas.ll_setIntValue(addr, casFeatCode_startIndex, v);}
    
  
 
  /** @generated */
  final Feature casFeat_endIndex;
  /** @generated */
  final int     casFeatCode_endIndex;
  /** @generated */ 
  public int getEndIndex(int addr) {
        if (featOkTst && casFeat_endIndex == null)
      jcas.throwFeatMissing("endIndex", "Gene");
    return ll_cas.ll_getIntValue(addr, casFeatCode_endIndex);
  }
  /** @generated */    
  public void setEndIndex(int addr, int v) {
        if (featOkTst && casFeat_endIndex == null)
      jcas.throwFeatMissing("endIndex", "Gene");
    ll_cas.ll_setIntValue(addr, casFeatCode_endIndex, v);}
    
  
 
  /** @generated */
  final Feature casFeat_content;
  /** @generated */
  final int     casFeatCode_content;
  /** @generated */ 
  public String getContent(int addr) {
        if (featOkTst && casFeat_content == null)
      jcas.throwFeatMissing("content", "Gene");
    return ll_cas.ll_getStringValue(addr, casFeatCode_content);
  }
  /** @generated */    
  public void setContent(int addr, String v) {
        if (featOkTst && casFeat_content == null)
      jcas.throwFeatMissing("content", "Gene");
    ll_cas.ll_setStringValue(addr, casFeatCode_content, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Gene_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_startIndex = jcas.getRequiredFeatureDE(casType, "startIndex", "uima.cas.Integer", featOkTst);
    casFeatCode_startIndex  = (null == casFeat_startIndex) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_startIndex).getCode();

 
    casFeat_endIndex = jcas.getRequiredFeatureDE(casType, "endIndex", "uima.cas.Integer", featOkTst);
    casFeatCode_endIndex  = (null == casFeat_endIndex) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_endIndex).getCode();

 
    casFeat_content = jcas.getRequiredFeatureDE(casType, "content", "uima.cas.String", featOkTst);
    casFeatCode_content  = (null == casFeat_content) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_content).getCode();

  }
}



    