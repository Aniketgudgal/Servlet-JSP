function displayData()
{
	let data = document.getElementById("deptName");
	let val = data.value;
	console.log(val);
	let tbody = document.getElementById("deptData");
	tbody.innerHTML = "";
	let aj = new XMLHttpRequest()
	aj.open("GET" , "/MVC_Project/searchDept?name="+val,true);
	aj.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200)
			{
				console.log(this.responseText);
				tbody.innerHTML = this.responseText;
			}
	};
	aj.send();
}