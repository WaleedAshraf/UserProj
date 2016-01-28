
function validate_Email(email)
{
	var i =  email.indexOf('@');
	str1 = email.substring(i+1 , email.length);
	i = str1.indexOf('.');
	if(i == -1)
	{
		return false ;
	}
}

function validate_login()
{
	var lettersAndSpaces = /^[a-zA-Z\s]+$/ ;
	var nums = /^[0-9]+$/ ;

	var testStr = document.getElementById('tfUserName').value ;

	if(testStr == "")
	{
		alert("Please Enter User Name First....");
		return false ;
	}
	else if (testStr.length < 5)
	{
		alert("User Name can not be less then five characters long");
		return false;
	}
	else if (/^[a-zA-Z0-9_]+$/.test(testStr) == false)
	{
		alert("User Name is not valid...Please Check This...\n\n User Name can contain only letters , numbers and _");
		return false ;
	}

	testStr = document.getElementById('tff_Name').value ;
	if(testStr == "")
	{
		alert("Please Enter First Name...");
		return false ;
	}
	else if (lettersAndSpaces.test(testStr) == false)
	{
		alert("First Name is not valid...");
		return false ;
	}

	testStr = document.getElementById('tfL_Name').value ;
	if(testStr == "")
	{
		alert("Please Enter Last Name...");
		return false ;
	}
	else if (lettersAndSpaces.test(testStr) == false)
	{
		alert("Last Name is not valid...");
		return false ;
	}

	testStr = document.getElementById('tpassword').value ;
	if( testStr == "")
	{
		alert("Please Enter Password First..");
		return false ;
	}
	else if (testStr.length < 5)
	{
		alert("Length of password can not be less then five..");
		return false ;
	}

	if(document.getElementById('tCpassword').value == "")
	{
		alert("Please Confirm Password First..");
		return false ;
	}

	if(document.getElementById('tpassword').value != document.getElementById('tCpassword').value)
	{
		alert("Password does not match..");
		return false ;
	}

	testStr = document.getElementById('tfEmail').value ;
	if( testStr == "")
	{
		alert("Please Enter email First");
		return false ;
	}
	else if (validate_Email(testStr) == false)
	{
		alert("Email is not valid");
		return false ;
	}

	testStr = document.getElementById('tfpNo').value
	if(testStr == "")
	{
		alert("Please Enter phone no. First");
		return false ;
	}
	else if (nums.test(testStr) == false)
	{
		
		alert("Phone no. is not valid");
		return false ;
	}
	else if (testStr.length < 11)
	{
		alert("Phone no. is too short \n It should be at least 11 characters long");
		return false ;
	}

	if(document.getElementById('tfdate').value == "")
	{
		alert("Please Enter date First");
		return false ;
	}

	if(document.getElementById('tfAdd').value == "")
	{
		alert("Please Enter Address First");
		return false ;
	}

}