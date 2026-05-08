function searchEmployee()
{
	alert('Hello word');
}
function deleteAlert()
{
	alert('Are you sure ?');
}
function confirmDelete() {

    return confirm("Do you want to delete this record?");
}
function updateConfirm()
{
	return confirm("Are you sure to Update?");
}
function addDeptConfirm()
{
	return confirm("Sure to Add?");
}
function confirmToDelDepartment()
{
	return confirm("Are You Sure to Delete Department?");
}
function sureToUpdateDept()
{
	return confirm("Sure to Update Information");
}
function confirmToAddEmp()
{
	return confirm("Confirm to Add Employee");
}
function accessDataEmp() {

	let data = document.getElementById("data");
	let val = data.value;
	console.log(val);
	let tbody = document.getElementById("tbody");
	tbody.innerHTML = "";
    let aj = new XMLHttpRequest();
    aj.open("GET", "/MVC_Project/searchBEmp?data="+val, true);

    aj.onreadystatechange = function() {

        if(this.readyState == 4 && this.status == 200) {

		tbody.innerHTML = this.responseText;	
        }
    };

    aj.send();
}

function accessDeptSearch()
{
	let data = document.getElementById("deptName");
	let val = data.value;
	console.log(val);
}