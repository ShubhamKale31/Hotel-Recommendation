function validateHotel(form) {



	if (form.hotelName.value == "") {
		alert("Error: HotelName cannot be blank!");
		form.hotelName.focus();
		return false;
	}
	re = /[0-9]/;
	if (re.test(form.hotelName.value)) {
		alert("Error: HotelName should not contain numbers!");
		form.hotelName.focus();
		return false;
	}
	re = /[A-Za-z]/;
	if (!re.test(form.hotelName.value)) {
		alert("Error: Hotelname should not contain other character!");
		form.hotelName.focus();
		return false;
	}

	if (form.address.value == "") {
		alert("Error: address cannot be blank!");
		form.address.focus();
		return false;
	}
	
	if (form.contactPerson.value == "") {
		alert("Error: ContactPerson cannot be blank!");
		form.contactPerson.focus();
		return false;
	}
	re = /[0-9]/;
	if (re.test(form.contactPerson.value)) {
		alert("Error: contactPerson should not contain numbers!");
		form.contactPerson.focus();
		return false;
	}
	re = /[A-Za-z]/;
	if (!re.test(form.contactPerson.value)) {
		alert("Error: contactPerson should not contain other character!");
		form.contactPerson.focus();
		return false;
	}
	if (form.contactNo.value == "") {
		alert("Error: Contact Number cannot be blank!");
		form.contactNo.focus();
		return false;
	}
	re = /[0-9]/;
	if (!re.test(form.contactNo.value)) {
		alert("Error: Contact Number contain digit!");
		form.contactNo.focus();
		return false;
	}
	re = /^[0-9]{10,12}$/;
	if (!re.test(form.contactNo.value)) {
		alert("Error: Enter 10 or 12 digit Contact Number!");
		form.contactNo.focus();
		return false;
	}
	if (form.email.value == "") {
		alert("Error: Email Id cannot be blank!");
		form.email.focus();
		return false;
	}
	re = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	if (!re.test(form.email.value)) {
		alert("Error: Invalid Email Id!");
		form.email.focus();
		return false;
	}
	if (form.Latitude.value == "") {
		alert("Error: Latitude cannot be blank!");
		form.Latitude.focus();
		return false;
	}
	if (form.Longitude.value == "") {
		alert("Error: Longitude cannot be blank!");
		form.Longitude.focus();
		return false;
	}
	return true;

	}

