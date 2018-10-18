package com.java.android.hotelActivity;

import android.text.TextUtils;
import android.util.Patterns;




public class Validation {
	
	public boolean isValidUserRole(String user_role){
		 if(user_role.equalsIgnoreCase("Select")){
			return false;
		}
		return true;
	}
	
	public boolean isValidUserGender(String user_gender){
		 if(user_gender.equalsIgnoreCase("Select")){
			return false;
		}
		return true;
	}

	public boolean isValidUserName(String user_name) {
		if (TextUtils.isEmpty(user_name)) {
			return false;
		}
		return true;
	}

	public boolean isValidPassword(String pass_word) {
		if (pass_word != null && pass_word.length() < 6) {
			return false;
		}
		return true;
	}

	public boolean isValidFirstName(String first_name) {
		if (TextUtils.isEmpty(first_name)) {
			return false;
		}
		return true;
	}

	public boolean isValidLastName(String last_name) {
		if (TextUtils.isEmpty(last_name)) {
			return false;
		}
		return true;
	}

	public boolean isValidEmail(String email_id) {
		if (email_id == null) {
			return false;
		} else {
			return android.util.Patterns.EMAIL_ADDRESS.matcher(email_id).matches();
		}
	}

	public boolean isValidPhone(String phone_no) {
		if(phone_no.length()<6 || phone_no.length()>13 ||!TextUtils.isEmpty(phone_no)){
			return  Patterns.PHONE.matcher(phone_no).matches();
		}
		return true;
	}

}
