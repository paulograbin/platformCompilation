/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.acceleratorstorefrontcommons.forms;
import javax.validation.constraints.NotNull;


/**
 * Form object for registration
 */
public class RegisterForm
{
	@NotNull(message = "{general.required}")
	private boolean otpForRegistrationEnabled;

	private String titleCode;
	private String firstName;
	private String lastName;
	private String email;
	private String pwd;
	private String checkPwd;
	private ConsentForm consentForm;
	private boolean termsCheck;

	@NotNull(message = "{general.required}")
	private String verificationTokenCode;

	@NotNull(message = "{general.required}")
	private String verificationTokenId;

	public String getVerificationTokenCode()
	{
		return verificationTokenCode;
	}

	public void setVerificationTokenCode(final String verificationTokenCode)
	{
		this.verificationTokenCode = verificationTokenCode;
	}

	public String getVerificationTokenId()
	{
		return verificationTokenId;
	}

	public void setVerificationTokenId(final String verificationTokenId)
	{
		this.verificationTokenId = verificationTokenId;
	}





	/**
	 * @return the titleCode
	 */
	public String getTitleCode()
	{
		return titleCode;
	}

	/**
	 * @param titleCode
	 *           the titleCode to set
	 */
	public void setTitleCode(final String titleCode)
	{
		this.titleCode = titleCode;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName()
	{
		return firstName;
	}

	/**
	 * @param firstName
	 *           the firstName to set
	 */
	public void setFirstName(final String firstName)
	{
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName()
	{
		return lastName;
	}

	/**
	 * @param lastName
	 *           the lastName to set
	 */
	public void setLastName(final String lastName)
	{
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * @param email
	 *           the email to set
	 */
	public void setEmail(final String email)
	{
		this.email = email;
	}

	/**
	 * @return the pwd
	 */
	public String getPwd()
	{
		return pwd;
	}

	/**
	 * @param pwd
	 *           the pwd to set
	 */
	public void setPwd(final String pwd)
	{
		this.pwd = pwd;
	}

	/**
	 * @return the checkPwd
	 */
	public String getCheckPwd()
	{
		return checkPwd;
	}

	/**
	 * @param checkPwd
	 *           the checkPwd to set
	 */
	public void setCheckPwd(final String checkPwd)
	{
		this.checkPwd = checkPwd;
	}

	public ConsentForm getConsentForm()
	{
		return consentForm;
	}

	public void setConsentForm(final ConsentForm consentForm)
	{
		this.consentForm = consentForm;
	}

	public boolean isTermsCheck()
	{
		return termsCheck;
	}

	public void setTermsCheck(final boolean termsCheck)
	{
		this.termsCheck = termsCheck;
	}

	public boolean isOtpForRegistrationEnabled()
	{
		return otpForRegistrationEnabled;
	}

	public void setOtpForRegistrationEnabled(final boolean otpForRegistrationEnabled)
	{
		this.otpForRegistrationEnabled = otpForRegistrationEnabled;
	}

}
