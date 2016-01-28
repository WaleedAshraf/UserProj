
function validate_login()
{
	if (document.loginForm.tLogUserN2.value == "")
	{
		alert("User Name field is empty!!");
			return false;
	}

	if (document.getElementById('tLogpassword').value == "")
	{
		alert("Password field is empty!!");
			return false;
	}
}