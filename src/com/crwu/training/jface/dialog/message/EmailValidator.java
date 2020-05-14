/**
 * 
 */
package com.crwu.training.jface.dialog.message;
import org.eclipse.jface.dialogs.IInputValidator;
/**
 * @author cr.wu
 *
 */
public class EmailValidator implements IInputValidator{
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IInputValidator#isValid(java.lang.String)
	 */
	@Override
	public String isValid(String paramString) {
		// TODO Auto-generated method stub
		if(paramString.indexOf("@") == -1){
			
			return "error 没有@";
		}
		
		if(paramString.indexOf(".com") == -1){
			
			return "error 没有com";
		}
		
		return null;
	}
}

