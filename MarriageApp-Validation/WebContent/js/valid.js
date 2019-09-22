function valid(fm)
{
	document.getElementById("nameErr").innerHTML=" ";
	document.getElementById("ageErr").innerHTML=" ";
	
	var name=fm.pname.value;
	var age=fm.page.value;
	alert("Client side validation");
	if(name=="")
		{
		document.getElementById("nameErr").innerHTML="Person name is mandatory";
		fm.pname.focus;
		return false;
		}
	if(age=="")
	{
	document.getElementById("ageErr").innerHTML="Person age is mandatory";
	fm.page.focus;
	return false;
	}
	if(isNaN(age))
		{
		document.getElementById("ageErr").innerHTML="Person age must be number type";
		fm.page.focus;
		return false;
		}
	else if(age<0 || age>125)
		{
		document.getElementById("ageErr").innerHTML="Person age must be 1 to 125";
		fm.page.focus;
		return false;
		}
	return true;
	fm.status.value="yes";
	}
